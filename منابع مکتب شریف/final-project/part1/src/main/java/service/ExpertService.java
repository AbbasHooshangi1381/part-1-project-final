package service;

import base.service.BaseEntityService;
import domain.userEntity.Expert;

import java.util.List;

public interface ExpertService extends BaseEntityService<Integer, Expert> {
    List<Expert> showEmail();

}
