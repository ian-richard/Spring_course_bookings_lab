package com.example.demo.repositories;

import com.example.demo.models.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    List<Customer> findCustomerByBookingsCourseName (String name);

    List<Customer> findAllCustomersByBookingsCourseTownAndBookingsCourseName (String town, String courseName);

}
