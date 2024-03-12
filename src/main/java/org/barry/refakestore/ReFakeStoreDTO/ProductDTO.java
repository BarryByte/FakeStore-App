package org.barry.refakestore.ReFakeStoreDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    Long id;
    String title;
    int price;
    String category;
    String description;
    String image;
}
