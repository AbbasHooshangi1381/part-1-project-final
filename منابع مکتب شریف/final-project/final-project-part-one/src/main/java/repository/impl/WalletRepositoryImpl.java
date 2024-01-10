package repository.impl;

import base.repository.impl.BaseEntityRepositoryImpl;
import domain.other.Wallet;
import repository.WalletRepository;

import javax.persistence.EntityManager;

public class WalletRepositoryImpl  extends BaseEntityRepositoryImpl<Integer, Wallet> implements WalletRepository {

    public WalletRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Class<Wallet> getEntityClass() {
        return Wallet.class;
    }
}
