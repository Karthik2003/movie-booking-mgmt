package com.sapient.moviebookingmgmt.dto;

import org.springframework.data.annotation.Id;
import lombok.Data;
@Data
public class Screen {
    @Id
    private Integer id;
    private String name;
    private String area;
    private String city;
    private Integer rows;
    private Integer columns;
    private Integer capacity;
}