package com.meeting.demo.service;


import lombok.Getter;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.*;


@Getter
@Service
public class TimeService {

    HashMap<LocalTime , Integer> timeIntervalMap = new HashMap<>();
    LocalTime[]  timeArray =  new LocalTime[48];
    LocalTime time = LocalTime.MIDNIGHT;
    int intervalIndex = 0;

    public TimeService()
    {
        for (int i = 0; i < 24 * 2; i++) { // 48 intervals for 24 hours
            timeArray[intervalIndex] = time ;
            timeIntervalMap.put(time , intervalIndex);
            time =  time.plusMinutes(30);
            intervalIndex++;
        }
    }



}
