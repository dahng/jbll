package com.likelion.prac02.dto;

import java.util.Date;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * EmployeeDto
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

  @NotNull private long employeeId;
  @NotNull @Size(min = 10, max = 50) private String name;
  @NotNull private Date birthDate;
  @NotNull private String gender;
  @NotNull @Email(message = "Invalid email format") private String email;
}
