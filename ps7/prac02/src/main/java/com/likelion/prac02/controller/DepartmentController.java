package com.likelion.prac02.controller;

import com.likelion.prac02.dto.DepartmentDto;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * DepartmentController
 */
@RestController
@RequestMapping("/departments")
class DepartmentController {

  @PostMapping("/")
  public ResponseEntity<String>
  createDepartment(@Valid @RequestBody DepartmentDto departmentDto) {
    return ResponseEntity.ok("Department created successfully");
  }
}
