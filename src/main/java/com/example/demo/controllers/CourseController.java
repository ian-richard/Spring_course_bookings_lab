package com.example.demo.controllers;

import com.example.demo.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class  CourseController {

    @Autowired
    CourseRepository courseRepository;

    @GetMapping(value="/courses")
    public ResponseEntity getAllCoursesAndFilters(
            @RequestParam(required = false, name = "name") String name,
            @RequestParam(required = false, name = "town") String town,
            @RequestParam(required = false, name = "rating") Integer rating,
            @RequestParam(required = false, name = "customerName") String customerName)

    {
        if (rating != null){
            return new ResponseEntity(courseRepository.findCourseByRating(rating), HttpStatus.OK);
        }
        if (customerName != null){
            return new ResponseEntity(courseRepository.findCourseByBookingsCustomerName(customerName), HttpStatus.OK);
        }
        return new ResponseEntity(courseRepository.findAll(), HttpStatus.OK);
    }

    @GetMapping(value = "/courses/{id}")
    public ResponseEntity getCourses(@PathVariable Long id) {
        return new ResponseEntity(courseRepository.findById(id), HttpStatus.OK);
    }


}
