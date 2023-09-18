package com.kodilla.good.patterns.foodToDoor.mapper;

import com.kodilla.good.patterns.foodToDoor.dto.ProductDto;
import com.kodilla.good.patterns.foodToDoor.pojo.Product;

public class ProductMapper {

    public static ProductDto mapToProductDto(Product product) {
        return new ProductDto(product.getName(), product.isAvailable());
    }

}
