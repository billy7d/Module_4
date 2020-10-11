package service;

import model.Customer;

import java.util.Iterator;
import java.util.List;

public interface ICustomer<T> {

    List<T> findAll();

    T findById(int id);

    T save(T model);

    T update(T model);

    void remove(int id);


}
