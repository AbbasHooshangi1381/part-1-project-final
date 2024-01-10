package repository.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import domain.userEntity.Expert;
import repository.ExpertRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ExpertRepositoryImpl extends BaseEntityRepositoryImpl<Integer, Expert> implements ExpertRepository {


    public ExpertRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Expert> getEntityClass() {
        return Expert.class;
    }

    @Override
    public List<String> showEmail() {
        TypedQuery<String> query = entityManager.createQuery("SELECT e.email FROM Expert e", String.class);
        return query.getResultList();
    }

    @Override
    public Boolean addToService(Integer id) {
        try {
            beginTransaction();
            List<Integer> idOfExpert = entityManager.createQuery("SELECT e.id FROM Expert e WHERE e.id = :id", Integer.class)
                    .setParameter("id", id)
                    .getResultList();

            if (idOfExpert != null) {
                entityManager.createQuery("UPDATE Expert e " +
                                "SET e.subServiceList.service.id = :serviceId, " +
                                "e.subServiceList.id = :subServiceId " +
                                "WHERE e.id = :expertId")
                        .setParameter("serviceId", 2)
                        .setParameter("subServiceId", 2)
                        .setParameter("expertId", idOfExpert)
                        .executeUpdate();

                commitTransaction();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
