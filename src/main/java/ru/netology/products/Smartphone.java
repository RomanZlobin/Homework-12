package ru.netology.products;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Smartphone extends Product {
    private String brand;

    public Smartphone(int id, String name, int cost, String brand) {
        super(id, name, cost);
        this.brand = brand;
    }
}
