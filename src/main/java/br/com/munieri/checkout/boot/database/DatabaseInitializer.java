package br.com.munieri.checkout.boot.database;

import br.com.munieri.checkout.domain.product.Product;
import br.com.munieri.checkout.infrastructure.repository.product.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Profile("staging")
public class DatabaseInitializer {

    @Autowired
    private Environment env;

    @Autowired
    private ProductRepository repository;

    @PostConstruct
    public void init() {
        Product entity = new Product("Celular", 200.00);
        repository.save(entity);

        entity = new Product("Televisor", 3000.00);
        repository.save(entity);

    }
}