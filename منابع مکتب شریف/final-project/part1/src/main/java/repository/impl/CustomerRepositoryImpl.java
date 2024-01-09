package repository.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import domain.userEntity.Customer;
import repository.CustomerRepository;

import javax.persistence.EntityManager;
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
    public List<Customer> showGmails() {
        return entityManager.createQuery("SELECT c.email FROM Customer c ")
               .getResultList();
    }
}
