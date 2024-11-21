package org.mygaraj.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
    private Long prId;
    private String prName;
    private String prDescription;
    private Integer prQty;
    private String prCategory;
    private double prPrice;

    private String image;

    private LocalDateTime createdAt;
}
