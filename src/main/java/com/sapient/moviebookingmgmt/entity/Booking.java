package com.sapient.moviebookingmgmt.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table("BOOKING")
public class Booking {
    @Id
    private Integer id;
    @Column("screenId")
    private Integer screenId;
    private LocalDate date;
    @Column("seatsBooked")
    private Integer seatsBooked;
    private Boolean active;
}