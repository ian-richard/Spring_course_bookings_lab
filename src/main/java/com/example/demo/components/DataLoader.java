package com.example.demo.components;

import com.example.demo.models.Booking;
import com.example.demo.models.Course;
import com.example.demo.models.Customer;
import com.example.demo.repositories.BookingRepository;
import com.example.demo.repositories.CourseRepository;
import com.example.demo.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    BookingRepository bookingRepository;

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CustomerRepository customerRepository;

    public DataLoader(){

    }

    public void run(ApplicationArguments args){
        Course course1 = new Course("Python", "London", 5);
        courseRepository.save(course1);

        Course course2 = new Course("Java", "Edinburgh", 4);
        courseRepository.save(course2);

        Course course3 = new Course("Ruby", "Manchester", 4);
        courseRepository.save(course3);

        Customer customer1 = new Customer("John","Edinburgh", 35);
        customerRepository.save(customer1);

        Customer customer2 = new Customer("Jane","Manchester", 26);
        customerRepository.save(customer2);

        Customer customer3 = new Customer("Jack","Dublin", 30);
        customerRepository.save(customer3);

        Customer customer4 = new Customer("Bob","edinburgh", 35);
        customerRepository.save(customer4);

        Booking booking1 = new Booking("01-01-21", course1, customer1);
        bookingRepository.save(booking1);

        Booking booking2 = new Booking("01-01-21", course1, customer2);
        bookingRepository.save(booking2);

        Booking booking3 = new Booking("01-03-22", course3, customer3);
        bookingRepository.save(booking3);

        Booking booking4 = new Booking("01-01-21", course1, customer4);
        bookingRepository.save(booking4);
    }

}
