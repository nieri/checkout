package br.com.munieri.checkout.domain.product.service;

import br.com.munieri.checkout.domain.product.Product;

import java.util.List;

public interface ProductService {

    Product find(Product product);

    Product findById(Long id);

    List<Product> findAll();

    void delete(Long id);

    void save(Product product);

    void update(Product product);

    void refresh(Product product);
}
