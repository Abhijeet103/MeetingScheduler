package com.meeting.demo.service;

import com.meeting.demo.entity.Employee;
import com.meeting.demo.exceptions.InvalidIntervalException;
import com.meeting.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


@Service
public class EmployeeServiceImpl implements EmployeeService{
    @Autowired
    TimeService timeService ;

    @Autowired
    EmployeeRepository employeeRepository ;
    @Override
    public void bookMeeting(Long Id , LocalTime start, LocalTime end) {

         long timerange = Duration.between(start , end).getSeconds();
         if (timerange < 30*60)
         {
             throw   new InvalidIntervalException("Minimum 30 minute intervals Allowed ");
         }
         HashMap<LocalTime , Integer> intervals  = timeService.getTimeIntervalMap();
         int startIndex =  intervals.get(start) ;
         int endIndex =  intervals.get(end) ;
         Employee employee = getEmployee(Id);
         HashSet<Integer> calender = employee.getTime();
         for(int i  = startIndex ; i<=endIndex ;i++)
         {
             if (calender.contains(i))
             {
                 throw  new InvalidIntervalException("Requested interval is already Occupied");
             }
             calender.add(i);
         }
         updateEmployee(employee);
    }

    public Employee getEmployee(Long id)
    {
        return employeeRepository.findById(id).orElseThrow();
    }

    public void updateEmployee(Employee employee)
    {
        employeeRepository.save(employee);
    }
    public List<Employee> getAll()
    {
        return employeeRepository.findAll();
    }


}
