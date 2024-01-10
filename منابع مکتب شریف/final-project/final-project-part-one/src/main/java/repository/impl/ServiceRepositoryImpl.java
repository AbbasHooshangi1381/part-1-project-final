package repository.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import domain.serviceEntity.Service;
import repository.ServiceRepository;

import javax.persistence.EntityManager;

public class ServiceRepositoryImpl  extends BaseEntityRepositoryImpl<Integer, Service> implements ServiceRepository {
    public ServiceRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Service> getEntityClass() {
        return Service.class;
    }
}
