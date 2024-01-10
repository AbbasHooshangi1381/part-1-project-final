package repository.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import domain.userEntity.Customer;
import repository.CustomerRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class CustomerRepositoryImpl extends BaseEntityRepositoryImpl<Integer, Customer> implements CustomerRepository {

    public CustomerRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Customer> getEntityClass() {
        return Customer.class;
    }

    @Override
    public List<String> showEmail() {
        TypedQuery<String> query = entityManager.createQuery("SELECT c.email FROM Customer c", String.class);
        return query.getResultList();
    }
}
