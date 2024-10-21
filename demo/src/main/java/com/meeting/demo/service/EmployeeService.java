package com.meeting.demo.service;
import com.meeting.demo.entity.Employee;

import java.time.LocalTime;
import java.util.List;

public interface EmployeeService {

    public void bookMeeting(Long id  , LocalTime start , LocalTime end) ;
    public void updateEmployee(Employee employee) ;

    public List<Employee> getAll() ;
}
