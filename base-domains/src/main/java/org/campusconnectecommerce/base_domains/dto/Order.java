package org.campusconnectecommerce.base_domains.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import lombok.Getter;
import lombok.Setter;
// use any @Getter, @Setter or @Data
@Getter
@Setter
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private String id;
    private String name;
    private int quantity;
    private double price;
}
