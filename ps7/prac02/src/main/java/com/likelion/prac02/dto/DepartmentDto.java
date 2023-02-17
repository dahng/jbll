package com.likelion.prac02.dto;

import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * DepartmentDto
 */
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class DepartmentDto {

  @NotNull private long departmentId;
  @NotNull @Size(min = 10, max = 50) private String deptName;
  @NotNull private String description;
  @NotNull @Valid private List<EmployeeDto> employees;
}
