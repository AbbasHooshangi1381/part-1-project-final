package service;

import base.service.BaseEntityService;
import domain.userEntity.Customer;

import java.util.List;

public interface CustomerService extends BaseEntityService<Integer, Customer> {

    public List<String> showEmail();
}
