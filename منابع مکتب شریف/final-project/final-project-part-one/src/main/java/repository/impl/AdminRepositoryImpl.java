package repository.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import domain.userEntity.Admin;
import repository.AdminRepository;

import javax.persistence.EntityManager;

public class AdminRepositoryImpl extends BaseEntityRepositoryImpl<Integer, Admin> implements AdminRepository {
    public AdminRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Admin> getEntityClass() {
        return Admin.class;
    }
}
