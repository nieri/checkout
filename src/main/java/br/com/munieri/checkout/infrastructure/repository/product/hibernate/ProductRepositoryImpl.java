package br.com.munieri.checkout.infrastructure.repository.product.hibernate;

import br.com.munieri.checkout.domain.product.Product;
import br.com.munieri.checkout.infrastructure.repository.product.ProductRepository;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class ProductRepositoryImpl implements ProductRepository {

    private Session session;

    @Autowired
    public ProductRepositoryImpl(SessionFactory factory) {
        this.session = factory.openSession();
    }

    @Override
    public List<br.com.munieri.checkout.domain.product.Product> findAll() {
        List<br.com.munieri.checkout.domain.product.Product> products = session.createQuery("from Product").list();
        return products;
    }

    @Override
    public void delete(Long id) {
        Query query = session.createQuery("delete Product where id = :ID");
        query.setParameter("ID", id);

        query.executeUpdate();
    }

    @Override
    public Product findById(Long id) {
        return (Product) session.get(Product.class, id);
    }

    @Override
    public void save(Product entity) {
        session.save(entity);
    }

    @Override
    public void update(br.com.munieri.checkout.domain.product.Product entity) {
        Transaction tx = session.beginTransaction();
        session.merge(entity);
        tx.commit();
    }

    @Override
    public void refresh(br.com.munieri.checkout.domain.product.Product entity) {
        session.refresh(entity);
    }
}
