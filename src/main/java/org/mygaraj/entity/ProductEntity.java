package org.mygaraj.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "product")
public class ProductEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer prId;
    private String prName;
    private String prDescription;
    private Integer prQty;
    private String prCategory;
    private Integer prPrice;
    private String imageUrl;
}
