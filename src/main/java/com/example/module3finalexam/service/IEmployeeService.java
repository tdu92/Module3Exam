package com.example.module3finalexam.service;

import java.util.List;

public interface IEmployeeService<E> {
    List<E> findAll();
    void add(E e);
    void edit(int id, E e);
    void delete(int id);
    int findIndexById(int id);
    E findById(int id);
}
