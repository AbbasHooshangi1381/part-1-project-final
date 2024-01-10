package repository.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import domain.other.Comments;
import domain.serviceEntity.SubService;
import repository.CommentsRepository;
import repository.SubServiceRepository;

import javax.persistence.EntityManager;

public class SubServiceRepositoryImpl extends BaseEntityRepositoryImpl<Integer, SubService> implements SubServiceRepository {

    public SubServiceRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<SubService> getEntityClass() {
        return SubService.class;
    }



    @Override
    public Boolean updateDescriptionField(Integer subServiceId, String newDescription) {
        try {
            beginTransaction();
            SubService subService = entityManager.find(SubService.class, subServiceId);

          /*   if (subService !=null){
                 subService.setDescription(newDescription);
                 subService.setPrice(newPrice);

                 commitTransaction();
             }*/

            if (subService != null) {
                entityManager.createQuery("UPDATE SubService s SET s.description = :newDescription " +
                                " WHERE s.id IN :installmentIds ")
                        .setParameter("newDescription", newDescription)
                        .executeUpdate();

                commitTransaction();
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return false;
    }

    @Override
    public Boolean updatePriceField(Integer subServiceId, Double price) {
        try {
            beginTransaction();
            SubService subService = entityManager.find(SubService.class, subServiceId);

          /*   if (subService !=null){
                 subService.setDescription(newDescription);
                 subService.setPrice(newPrice);

                 commitTransaction();
             }*/

            if (subService != null) {
                entityManager.createQuery("UPDATE SubService s SET s.price = :price " +
                                " WHERE s.id IN :installmentIds ")
                        .setParameter("price", price)
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