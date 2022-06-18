package org.monjasa.utopia.repository.base.impl;

import org.monjasa.utopia.repository.base.JpaClearableRepository;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.io.Serializable;

public class JpaClearableRepositoryImpl<T, ID extends Serializable> extends SimpleJpaRepository<T, ID> implements JpaClearableRepository<T, ID> {

    private final EntityManager entityManager;

    public JpaClearableRepositoryImpl(JpaEntityInformation<T, ID> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public void clear() {
        entityManager.clear();
    }
}
