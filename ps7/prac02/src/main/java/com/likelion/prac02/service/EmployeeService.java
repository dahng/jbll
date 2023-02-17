package com.likelion.prac02.service;

import com.likelion.prac02.dto.EmployeeDto;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/**
 * EmployeeService
 */
@Service
public class EmployeeService {

  private static final Logger logger =
      LoggerFactory.getLogger(EmployeeService.class);

  public EmployeeDto getEmployeeDto(EmployeeDto employeeDto) {
    logger.info("getEmployeeDto called with employeeDto: {}", employeeDto);
    return employeeDto;
  }

  @AfterThrowing(
      pointcut =
          "execution(* com.likelion.prac02.service.EmployeeService.getEmployeeDto(..))",
      throwing = "ex")
  public void
  logAfterThrowing(JoinPoint joinPoint, Throwable ex) {
    logger.error("Exception in {}.{} with cause = {}",
                 joinPoint.getSignature().getDeclaringTypeName(),
                 joinPoint.getSignature().getName(),
                 ex.getCause() != null ? ex.getCause() : "NULL");
  }
}
