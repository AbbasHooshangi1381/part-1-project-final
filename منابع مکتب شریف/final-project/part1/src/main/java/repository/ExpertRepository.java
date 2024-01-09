package repository;

import base.repository.BaseEntityRepository;
import domain.serviceEntity.SubService;
import domain.userEntity.Customer;
import domain.userEntity.Expert;

import java.util.List;

public interface ExpertRepository extends BaseEntityRepository<Integer, Expert> {

    List<Expert> showEmail();
}
