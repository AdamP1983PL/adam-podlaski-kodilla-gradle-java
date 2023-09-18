package com.kodilla.good.patterns.foodToDoor.dto;

public class ProductDto {

    private String name;
    private boolean isAvailable;

    public ProductDto(String name, boolean isAvailable) {
        this.name = name;
        this.isAvailable = isAvailable;
    }

    public ProductDto() {
    }

    public String getName() {
        return name;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    @Override
    public String toString() {
        return name;
    }
}
