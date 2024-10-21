package com.meeting.demo.dto;

import lombok.Data;

import java.time.LocalTime;
import java.util.List;


@Data
public class MeetingRequestDto {

    LocalTime start;
    LocalTime end ;
    List<Long> invites ;
}
