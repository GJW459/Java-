package com.gjw.Dao;

import org.junit.Test;

import java.util.List;

public class DaoTest {
    @Test
    public void test(){
        CustomerDao customerDao = new CustomerDao();
        customerDao.add(new Customer());
        List<Customer> forList = customerDao.getForList();
        StudentDao studentDao = new StudentDao();
        List<Student> forList1 = studentDao.getForList();
    }
}
