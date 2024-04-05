package com.example.module3finalexam.controller;

import com.example.module3finalexam.model.Department;
import com.example.module3finalexam.model.Employee;
import com.example.module3finalexam.service.EmployeeService;

import java.io.*;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "EmployeeController", value = "/employees")
public class EmployeeController extends HttpServlet {
    private EmployeeService employeeService = new EmployeeService();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        switch (action) {
            case "home":
                showHome(request,response);
                break;
            case "add":
                showAddForm(request,response);
                break;
            case "edit":
                showEditForm(request,response);
                break;
        }
    }

    public void showHome(HttpServletRequest req, HttpServletResponse resp)throws ServletException, IOException{
        List<Employee> employeelist= employeeService.findAll();
        req.setAttribute("employeelist", employeelist);
        RequestDispatcher dispatcher = req.getRequestDispatcher("employee/home.jsp");
        dispatcher.forward(req,resp);
    }

    public void showAddForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        List<Employee> list = this.employeeService.findAll();
        req.setAttribute("list", list);
        RequestDispatcher dispatcher = req.getRequestDispatcher("employee/add.jsp");
        dispatcher.forward(req,resp);
    }
    
    private void showEditForm(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        int idEdit = Integer.parseInt(req.getParameter("idEdit"));
        Employee employeeEdit = employeeService.findById(idEdit);
        req.setAttribute("employeeEdit", employeeEdit);
        RequestDispatcher dispatcher = req.getRequestDispatcher("employee/edit.jsp");
        dispatcher.forward(req,resp);
    }
    
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String action = req.getParameter("action");
        switch(action){
            case "add":
                addEmployee(req,resp);
                break;
            case "edit":
                editEmployee(req,resp);
                break;
        }
    }
    
    private void addEmployee(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String phoneNumber = req.getParameter("phoneNumber");
        double salary = Double.parseDouble(req.getParameter("salary"));
        int idDepartment = Integer.parseInt(req.getParameter("idDepartment"));
        Department department = new Department(idDepartment);
        Employee newEmployee = new Employee(name, email,address,phoneNumber,salary, department);
        employeeService.add(newEmployee);
        resp.sendRedirect("/employee?action=home");
    }

    private void editEmployee(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException{
        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String email = req.getParameter("email");
        String address = req.getParameter("address");
        String phoneNumber = req.getParameter("phoneNumber");
        double salary = Double.parseDouble(req.getParameter("salary"));
        int idDepartment = Integer.parseInt(req.getParameter("idDepartment"));
        Department department = new Department(idDepartment);
        Employee newEmployee = new Employee(name, email,address,phoneNumber,salary, department);
        resp.sendRedirect("/employee?action=home");
    }
    
}