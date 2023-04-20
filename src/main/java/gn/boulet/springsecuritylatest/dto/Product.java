package gn.boulet.springsecuritylatest.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Product {
    private int id;
    private String name;
    private int qty;
    private int price;
}
