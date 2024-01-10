package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import domain.userEntity.Expert;
import repository.ExpertRepository;
import service.ExpertService;

import java.util.List;

public class ExpertServiceImpl extends BaseEntityServiceImpl<Integer, Expert, ExpertRepository>
        implements ExpertService {
    public ExpertServiceImpl(ExpertRepository baseRepository) {
        super(baseRepository);
    }


    @Override
    public List<String> showEmail() {
        return baseRepository.showEmail();
    }
}
