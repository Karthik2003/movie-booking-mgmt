package com.sapient.moviebookingmgmt.entity;

import com.sapient.moviebookingmgmt.enums.Shows;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Document(indexName = "screens")
public class Screens {
    @Id
    private int screenId;
    private String screenName;
    private String area;
    private String city;
    private String movieName;
    @Enumerated(EnumType.STRING)
    private Shows movieTime;
}
