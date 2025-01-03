package com.example.Lab1TBD.persistence.entities;

import lombok.*;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CustomerOpinion {
    private Long opinion_id;
    private String commentary;
    private Float rating;
    private Long product_id;
    private Long client_id;
}
