package org.barry.refakestore.models;

import jdk.jfr.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private Long id;
    private String title;
    private Category category;
    private int price;
    private String description;
    private String imageUrl;

}
