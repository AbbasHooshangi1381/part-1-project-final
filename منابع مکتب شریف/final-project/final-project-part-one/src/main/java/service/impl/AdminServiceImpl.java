package service.impl;

import base.service.impl.BaseEntityServiceImpl;
import domain.userEntity.Admin;
import repository.AdminRepository;
import service.AdminService;

public class AdminServiceImpl extends BaseEntityServiceImpl<Integer, Admin, AdminRepository>
        implements AdminService {
    public AdminServiceImpl(AdminRepository baseRepository) {
        super(baseRepository);
    }
}
