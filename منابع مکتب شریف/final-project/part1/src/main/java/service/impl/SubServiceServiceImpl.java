package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import domain.serviceEntity.SubService;
import repository.SubServiceRepository;
import service.SubServiceService;

public class SubServiceServiceImpl extends BaseEntityServiceImpl<Integer, SubService, SubServiceRepository>
        implements SubServiceService {
    public SubServiceServiceImpl(SubServiceRepository baseRepository) {
        super(baseRepository);
    }
}
