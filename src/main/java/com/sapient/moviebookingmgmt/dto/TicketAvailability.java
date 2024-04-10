package com.sapient.moviebookingmgmt.dto;

import lombok.Data;
@Data
public class TicketAvailability {
    private Integer screenId;
    private String screenName;
    private Integer totalCapacity;
    private Integer seatsBooked;
    private Integer seatsAvailable;
}