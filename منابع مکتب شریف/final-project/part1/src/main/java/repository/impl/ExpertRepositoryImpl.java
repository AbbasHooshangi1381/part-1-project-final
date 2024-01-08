package repository.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import domain.userEntity.Customer;
import domain.userEntity.Expert;
import repository.ExpertRepository;

import javax.persistence.EntityManager;
import java.util.List;

public class ExpertRepositoryImpl extends BaseEntityRepositoryImpl<Integer,Expert> implements ExpertRepository {


    public ExpertRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Expert> getEntityClass() {
        return Expert.class;
    }
}
