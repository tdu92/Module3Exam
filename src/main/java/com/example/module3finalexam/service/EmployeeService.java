package com.example.module3finalexam.service;

import com.example.module3finalexam.model.Department;
import com.example.module3finalexam.model.Employee;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService implements IEmployeeService<Employee>{
    private Connection connection = ConnectToMySQL.getConnection();

    public EmployeeService(){}

    public List<Employee> findAll(){
        String sql = "select employee.*, c.name as 'nameDepartment' from employee join department c on employee.idDepartment=c.id;";
        List<Employee> list = new ArrayList<>();
        try{
            PreparedStatement prSt = connection.prepareStatement(sql);
            ResultSet resultSet = prSt.executeQuery();
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("phoneNumber");;
                double salary = resultSet.getDouble("salary");
                int idDepartment = resultSet.getInt("idDepartment");
                String nameDepartment = resultSet.getString("nameDepartment");
                Department department = new Department(idDepartment, nameDepartment);
                Employee employee = new Employee(id, name, email, address, phoneNumber, salary, department);
                list.add(employee);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }
    public void add(Employee employee){
        String sql = "INSERT INTO employee(name, email,address,phoneNumber,salary,idDepartment) values (?,?,?,?,?,?);";
    try{
        PreparedStatement prSt = connection.prepareStatement(sql);
        prSt.setString(1, employee.getName());
        prSt.setString(2, employee.getEmail());
        prSt.setString(3, employee.getAddress());
        prSt.setString(4, employee.getPhoneNumber());
        prSt.setDouble(5, employee.getSalary());
        prSt.setInt(6, employee.getDepartment().getId());
        prSt.executeUpdate();
    }catch(Exception e){
        e.printStackTrace();
        }
    }

    public void edit(int id, Employee employee) {
        String sql = "update employee set name = ?, email = ?, address =?, phoneNumber=?, salary =? where id = ?;";
        try{
            PreparedStatement prSt = connection.prepareStatement(sql);
            prSt.setString(1, employee.getName());
            prSt.setString(2, employee.getEmail());
            prSt.setString(3, employee.getAddress());
            prSt.setString(4, employee.getPhoneNumber());
            prSt.setDouble(5, employee.getSalary());
            prSt.setInt(6,id);
            prSt.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();

        }
    }
    public void delete(int id){
        String sql = "DELETE FROM employee WHERE id = ?;";
        try{
            PreparedStatement prSt = connection.prepareStatement(sql);
            prSt.setInt(1,id);
            prSt.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public int findIndexById(int id){
        return -1;
    }
    public Employee findById(int id){
        String sql = "SELECT employee.*, c.name as 'nameDepartment' from employee join department c on employee.idDepartment = c.id where employee.id = ?;";
        Employee employee = null;
        try{
            PreparedStatement prSt = connection.prepareStatement(sql);
            prSt.setInt(1,id);
            ResultSet resultSet = prSt.executeQuery();
            while(resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");
                String address = resultSet.getString("address");
                String phoneNumber = resultSet.getString("phoneNumber");
                double salary = resultSet.getDouble("salary");
                int idDepartment = resultSet.getInt("idDepartment");
                String nameDepartment = resultSet.getString("nameDepartment");
                Department department = new Department(idDepartment, nameDepartment);
                employee = new Employee(id, name, email,address,phoneNumber,salary,department);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return employee;
    }
}
