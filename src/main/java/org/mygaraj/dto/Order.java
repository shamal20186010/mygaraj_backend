package org.mygaraj.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Order {

    private Long id;
    private String customerName;
    private String address;
    private Double totalAmount;
    private List<OrderItem> items;

}
