package com.meeting.demo.service;

import com.meeting.demo.dto.MeetingRequestDto;
import com.meeting.demo.entity.Employee;
import com.meeting.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashSet;

@Service
public class MeetingServiceImpl implements MeetingService {

    @Autowired
    TimeService timeService ;

    @Autowired
    EmployeeRepository employeeRepository ;
    @Override
    public ArrayList<LocalTime> freeSlots(long id1, long id2) {
        Employee e1 = employeeRepository.findById(id1).orElseThrow();
        Employee e2 = employeeRepository.findById(id2).orElseThrow();
        HashSet<Integer> time1 =  e1.getTime();
        HashSet<Integer> time2 =  e2.getTime();

        ArrayList<LocalTime>  avaliable_slots = new ArrayList<>();
        for (int  i=0 ;i<48 ; i++)
        {
            if (!(time1.contains(i)  || time2.contains(i)))
            {
                avaliable_slots.add(timeService.timeArray[i]);
            }
        }
        return avaliable_slots;
    }

    @Override
    public ArrayList<Employee> getBusyEmployees(MeetingRequestDto dto) {
        ArrayList<Long> ids = (ArrayList<Long>) dto.getInvites();
        ArrayList<Employee> invites = (ArrayList<Employee>) employeeRepository.findAllById(ids);
        int start  =  timeService.timeIntervalMap.get(dto.getStart());
        int end  = timeService.timeIntervalMap.get(dto.getEnd());

        HashSet<Employee> temp  =  new HashSet<>();
        for(int i  =  start  ; i<=end ;i++)
        {
            for(Employee e :  invites)
            {
                HashSet<Integer> time = e.getTime();
                if(time.contains(i))
                {
                    temp.add(e);
                }
            }
        }
        return new ArrayList<>(temp);
    }
}
