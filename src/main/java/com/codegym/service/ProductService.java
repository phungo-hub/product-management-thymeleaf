package com.codegym.service;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService{
    private static final Map<Integer, Product> products;

    static {
        products = new HashMap<>();
        products.put(1, new Product(1, "sua ong Tho1", "sua tot cho suc khoe",99.99));
        products.put(2, new Product(2, "sua ong Tho2", "sua tot cho suc khoe",99.99));
        products.put(3, new Product(3, "sua ong Tho3", "sua tot cho suc khoe",99.99));
        products.put(4, new Product(4, "sua ong Tho4", "sua tot cho suc khoe",99.99));
        products.put(5, new Product(5, "sua ong Tho5", "sua tot cho suc khoe",99.99));
        products.put(6, new Product(6, "sua ong Tho6", "sua tot cho suc khoe",99.99));
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(products.values());
    }

    @Override
    public void save(Product product) {
        products.put(product.getId(), product);
    }

    @Override
    public Product findById(int id) {
        return products.get(id);
    }

    @Override
    public void update(int id, Product product) {
        products.put(id, product);
    }

    @Override
    public void remove(int id) {
        products.remove(id);
    }
}
