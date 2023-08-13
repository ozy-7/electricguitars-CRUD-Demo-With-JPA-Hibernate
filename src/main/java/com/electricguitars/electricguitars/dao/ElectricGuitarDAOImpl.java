package com.electricguitars.electricguitars.dao;

import com.electricguitars.electricguitars.entity.ElectricGuitar;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Transient;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Type;
import java.util.List;

@Repository
public class ElectricGuitarDAOImpl implements ElectricGuitarDAO{
    EntityManager entityManager;




    @Autowired
    public ElectricGuitarDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }



    @Override
    @Transactional
    public void save(ElectricGuitar theElectricGuitar) {
        entityManager.persist(theElectricGuitar);
    }

    @Override
    public ElectricGuitar findById(Integer id) {
        return entityManager.find(ElectricGuitar.class, id);
    }

    @Override
    public List<ElectricGuitar> findAll() {
        TypedQuery<ElectricGuitar> theQuery = entityManager.createQuery("FROM ElectricGuitar", ElectricGuitar.class);
        return theQuery.getResultList();
    }

    @Override
    public List<ElectricGuitar> findByBrand(String theBrand) {
        TypedQuery<ElectricGuitar> theQuery = entityManager.createQuery("from ElectricGuitar WHERE Brand=:theBrand", ElectricGuitar.class)
                .setParameter("theBrand", theBrand);
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(ElectricGuitar theElectricGuitar) {
        entityManager.merge(theElectricGuitar);
    }

    @Override
    @Transactional
    public void deleteById(Integer id) {
        entityManager.remove(id);
    }

    @Override
    public void deletebyBrand(String theBrand) {
        entityManager.createQuery("DELETE FROM ElectricGuitar WHERE Brand=:theBrand", ElectricGuitar.class)
                .setParameter("theBrand", theBrand)
                .executeUpdate();
        return;
    }

    @Override
    @Transactional
    public int deleteAll() {
        int numOfRowsDeleted = entityManager.createQuery("DELETE FROM ElectricGuitar").executeUpdate();
        return numOfRowsDeleted;
    }
}
