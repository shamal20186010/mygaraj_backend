package org.mygaraj.dto;

import jakarta.persistence.Lob;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Product {
    private Integer prId;
    private String prName;
    private String prDescription;
    private Integer prQty;
    private String prCategory;
    private Integer prPrice;
    private String imageUrl;
}
