package com.gjw.Dao;

import java.util.List;

public class CustomerDao extends MyDao<Customer> {


    @Override
    public void add(Customer customer) {

    }

    @Override
    public boolean remove(int index) {
        return false;
    }

    @Override
    public void update(int index, Customer customer) {

    }

    @Override
    public Customer getIndex(int index) {
        return null;
    }

    @Override
    public List<Customer> getForList() {
        return null;
    }
}
