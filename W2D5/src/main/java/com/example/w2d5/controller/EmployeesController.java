package com.example.w2d5.controller;

import com.example.w2d5.model.Api;
import com.example.w2d5.model.Employee;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/employee")

public class EmployeesController {

    ArrayList<Employee> employeeList = new ArrayList<>();


            @GetMapping
            public ResponseEntity getEmployee(){
            return ResponseEntity.status(200).body(employeeList);
        }

            @PostMapping("/register")
            public ResponseEntity addEmployee(@RequestBody @Valid Employee employee, Errors errors){
                if(errors.hasErrors()){
                    String message = errors.getFieldError().getDefaultMessage();
                    return ResponseEntity.status(400).body(new Api("Error, bad syntax", 400));
                }
                employeeList.add(employee);
                return ResponseEntity.status(200).body( new Api("New user added !",200));
            }
            @PutMapping("/{index}")
            public ResponseEntity updateEmployee(@RequestBody @Valid Employee employee, @PathVariable int index, Errors errors){
                if (errors.hasErrors()){
                    String message = errors.getFieldError().getDefaultMessage();
                    return ResponseEntity.status(400).body(new Api("Error, bad syntax", 400));
                    }
                if(index>=employeeList.size()){
                    return ResponseEntity.status(400).body(new Api("Invalid index",400));
                    }
                    employeeList.set(index,employee);
                    return ResponseEntity.status(201).body( new Api("User updated !",201));
                }
            @DeleteMapping("/employee/{index}")
            public ResponseEntity deleteEmployee(@PathVariable int index){
                if(index>=employeeList.size()){
                    return ResponseEntity.status(400).body(new Api("Invalid index", 200));
                    }
                    employeeList.remove(index);
                    return ResponseEntity.status(200).body(new Api("Employee deleted !", 200 ));
    }

}