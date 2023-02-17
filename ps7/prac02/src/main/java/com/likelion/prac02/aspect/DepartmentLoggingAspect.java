package com.likelion.prac02.aspect;

import com.likelion.prac02.dto.DepartmentDto;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * DepartmentLoggingAspect
 */

@Aspect
@Component
public class DepartmentLoggingAspect {

  private static final Logger logger =
      LoggerFactory.getLogger(DepartmentLoggingAspect.class);

  @Before(
      "execution(* com.likelion.prac02.service.DepartmentService.getDepartmentDto(..)) && args(departmentDto)")
  public void
  logBeforeGetDepartmentDto(JoinPoint joinPoint, DepartmentDto departmentDto) {
    logger.info("Entering getDepartmentDto method with departmentDto: {}",
                departmentDto);
  }

  @AfterReturning(
      pointcut =
          "execution(* com.likelion.prac02.service.DepartmentService.getDepartmentDto(..))",
      returning = "result")
  public void
  logAfterGetDepartmentDto(JoinPoint joinPoint, DepartmentDto result) {
    logger.info("Exiting getDepartmentDto method with result: {}", result);
  }
}
