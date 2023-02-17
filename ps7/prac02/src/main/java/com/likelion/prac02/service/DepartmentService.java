package com.likelion.prac02.service;

import com.likelion.prac02.dto.DepartmentDto;
import com.likelion.prac02.dto.EmployeeDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * DepartmentService
 */

@Service
public class DepartmentService {

  private static final Logger logger =
      LoggerFactory.getLogger(DepartmentService.class);

  public DepartmentDto getDepartmentDto(DepartmentDto departmentDto) {
    logger.info("Entering getDepartmentDto method");

    DepartmentDto result = new DepartmentDto();

    result.setDepartmentId(departmentDto.getDepartmentId());
    result.setDeptName(departmentDto.getDeptName());
    result.setDescription(departmentDto.getDescription());
    List<EmployeeDto> employeeList = new ArrayList<>();
    for (EmployeeDto employeeDto : departmentDto.getEmployees()) {
      employeeList.add(employeeDto);
    }
    result.setEmployees(employeeList);

    logger.info("Exiting getDepartmentDto method");

    return result;
  }
}
