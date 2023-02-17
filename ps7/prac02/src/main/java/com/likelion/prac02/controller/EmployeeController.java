package com.likelion.prac02.controller;

import com.likelion.prac02.dto.EmployeeDto;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * EmployeeController
 */
@RestController
@RequestMapping("/employees")
public class EmployeeController {

  @PostMapping("/")
  public ResponseEntity<String>
  createEmployee(@Valid @RequestBody EmployeeDto employeeDto) {
    return ResponseEntity.ok("Employee created successfully");
  }
}
