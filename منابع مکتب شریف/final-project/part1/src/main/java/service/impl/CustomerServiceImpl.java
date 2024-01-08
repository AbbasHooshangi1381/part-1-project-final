package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import domain.userEntity.Customer;
import repository.CustomerRepository;
import service.CustomerService;

public class CustomerServiceImpl extends BaseEntityServiceImpl<Integer, Customer, CustomerRepository>
        implements CustomerService {
    public CustomerServiceImpl(CustomerRepository baseRepository) {
        super(baseRepository);
    }
}
