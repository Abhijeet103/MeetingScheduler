package com.meeting.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalTime;


@AllArgsConstructor
@Data
public class Intervals {

    private long employeeId ;
    private  LocalTime start ;
    private LocalTime end ;
}
