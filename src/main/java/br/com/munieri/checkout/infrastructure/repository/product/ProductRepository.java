package br.com.munieri.checkout.infrastructure.repository.product;

import br.com.munieri.checkout.domain.product.Product;

import java.util.List;

public interface ProductRepository {


    List<Product> findAll();

    void delete(Long id);

    Product findById(Long id);

    void save(Product entity);

    void update(Product entity);

    void refresh(Product entity);

}
