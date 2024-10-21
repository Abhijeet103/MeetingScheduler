# Calendar Assistant for Meeting Booking

## Overview

This project demonstrates an algorithm to manage employee calendars and assist with booking meetings. The day is split into 48 segments of 30 minutes each, and a HashMap is used to map time slots to segment indices. Each employee has a calendar represented by a HashSet of integers, with each integer corresponding to an occupied time slot.

## Features

1. **Book a Meeting**:
   - Checks if an employee is available during the specified time and books the slot if available.

2. **Available Slots**:
   - Retrieves all the available slots for employees to schedule meetings.

3. **Meeting Request**:
   - Determines which employees have a conflict with a meeting request and returns the list of conflicting employees.

4. **Exception Handling**:
   - Exceptions are handled for scenarios like invalid time slots, already booked slots, and invalid employee IDs.

## Algorithm

- The 24-hour day is divided into 48 segments of 30 minutes each.
- A HashMap is used to map the time slots to an index.
- Each employee's calendar is represented by a HashSet of integers, where each integer indicates an occupied time slot.

### Usage

1. **Book a Meeting**:
   - Endpoint: `localhost:8080/bookMeeting`
   - Request Body:
     ```json
     {
       "employeeId": 53,
       "start": "10:00:00",
       "end": "10:30:00"
     }
     ```
   - Response:  
     Books the meeting only if the slot is not already occupied.
     ![image](https://github.com/user-attachments/assets/a1cc4cb6-b5e9-4336-b701-c99375f6a7f5)

2. **Find Available Slots**:
   - Endpoint: `localhost:8080/availableSlots`
   - Request Body:
     ```json
     {
       "employeeId1": 53,
       "employeeId2": 52
     }
     ```
   - Response:  
     Retrieves the free time slots for both employees.
     ![Screenshot 2024-10-21 202328](https://github.com/user-attachments/assets/2fbe417a-ee1c-4d56-8443-db3e885ddb87)

3. **Meeting Request**:
   - Endpoint: `localhost:8080/meetingRequest`
   - Request Body:
     ```json
     {
       "start": "15:00:00",
       "end": "16:30:00",
       "invites": [52, 53, 54]
     }
     ```
   - Response:  
     Lists all employee IDs with conflicts. If none have conflicts, it returns an empty array.

## Exception Handling

- **Invalid Time Slot**: Exception is raised if the time slot is out of bounds.
- **Already Booked Slot**: If a slot is already booked, an appropriate error message is returned.
- **Invalid Employee ID**: Error handling for non-existent employee IDs.


