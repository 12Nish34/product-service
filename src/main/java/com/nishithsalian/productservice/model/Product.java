package com.nishithsalian.productservice.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


import java.math.BigInteger;

@Document(value = "Product")
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Product {
    @Id
    private String id;
    private String name;
    private String description;
    private BigInteger price;

}
