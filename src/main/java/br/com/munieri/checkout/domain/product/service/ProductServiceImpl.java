package br.com.munieri.checkout.domain.product.service;

import br.com.munieri.checkout.domain.product.Product;
import br.com.munieri.checkout.infrastructure.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository repository;

    @Override
    public Product find(Product product) {
        return repository.findById(product.getId());
    }

    @Override
    public Product findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public void delete(Long id) {
        repository.delete(id);
    }

    @Override
    public void save(Product product) {
        repository.save(product);
    }

    @Override
    public void update(Product product) {
        repository.update(product);
    }

    @Override
    public void refresh(Product product) {
        repository.refresh(product);
    }
}
