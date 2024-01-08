package repository.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import domain.other.Comments;
import domain.serviceEntity.SubService;
import repository.CommentsRepository;
import repository.SubServiceRepository;

import javax.persistence.EntityManager;

public class SubServiceRepositoryImpl  extends BaseEntityRepositoryImpl<Integer, SubService> implements SubServiceRepository {

    public SubServiceRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<SubService> getEntityClass() {
        return SubService.class;
    }
}
