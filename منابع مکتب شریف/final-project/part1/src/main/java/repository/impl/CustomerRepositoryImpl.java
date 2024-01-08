package repository.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import domain.userEntity.Customer;
import repository.CustomerRepository;

import javax.persistence.EntityManager;

public class CustomerRepositoryImpl extends BaseEntityRepositoryImpl<Integer, Customer> implements CustomerRepository {

    public CustomerRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Customer> getEntityClass() {
        return Customer.class;
    }
}
