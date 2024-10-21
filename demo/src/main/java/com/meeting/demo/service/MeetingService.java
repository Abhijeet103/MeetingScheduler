package com.meeting.demo.service;

import com.meeting.demo.dto.MeetingRequestDto;
import com.meeting.demo.entity.Employee;

import java.time.LocalTime;
import java.util.ArrayList;

public interface MeetingService {

    ArrayList<LocalTime> freeSlots(long id1 , long  id2 );

    ArrayList<Employee> getBusyEmployees(MeetingRequestDto dto);
}
