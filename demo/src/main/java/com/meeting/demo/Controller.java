package com.meeting.demo;

import com.meeting.demo.dto.Intervals;
import com.meeting.demo.dto.MeetingRequestDto;
import com.meeting.demo.dto.SlotsDto;
import com.meeting.demo.entity.Employee;
import com.meeting.demo.service.EmployeeService;
import com.meeting.demo.service.MeetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.List;

@RestController
public class Controller {

    @Autowired
    EmployeeService employeeService ;

    @Autowired
    MeetingService meetingService ;

    @PostMapping("/bookMeeting")
    String bookMeeting(@RequestBody Intervals interval)
    {
        long id =  interval.getEmployeeId();
        employeeService.bookMeeting(id , interval.getStart() , interval.getEnd());
        return "Meeting booked successFully" ;
    }

    @GetMapping("/getAll")
    List<Employee> getAll()
    {
        return employeeService.getAll();
    }
    @PostMapping("/createEmployee")
    Employee createEmployee()
    {
        Employee employee  = new Employee();
        employeeService.updateEmployee(employee);
        return employee ;
    }

    @PostMapping("/availableSlots")
    List<LocalTime> allAvailableSlots(@RequestBody SlotsDto slots)
    {
        return  meetingService.freeSlots(slots.getEmployeeId1(), slots.getEmployeeId2());
    }

    @PostMapping("/meetingRequest")
    List<Employee> busyEmployees( @RequestBody  MeetingRequestDto dto)
    {
        return meetingService.getBusyEmployees(dto);
    }
}
