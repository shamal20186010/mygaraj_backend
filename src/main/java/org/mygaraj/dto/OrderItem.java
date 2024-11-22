package org.mygaraj.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class OrderItem {

    private Long id;
    private String productName;
    private Double price;
    private Integer quantity;

}
