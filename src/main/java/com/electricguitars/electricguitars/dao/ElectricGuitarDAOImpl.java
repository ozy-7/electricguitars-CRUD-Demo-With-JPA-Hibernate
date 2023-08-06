package com.example.cruddemo.electricguitars.electricguitars.dao;

import com.example.cruddemo.electricguitars.electricguitars.entity.ElectricGuitar;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ElectricGuitarDAOImpl implements ElectricGuitarDAO {

    //define field for entity manager
    private EntityManager entityManager;

    //inject entity manager using constructor

    @Autowired
    public ElectricGuitarDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    //implement save method
    @Override
    @Transactional      //transactional if alters the values of the table
    public void save(ElectricGuitar theElectricGuitar) {
        entityManager.persist(theElectricGuitar);
    }

    @Override
    public ElectricGuitar findById(Integer id) {
        return entityManager.find(ElectricGuitar.class, id);
    }

    @Override
    public List<ElectricGuitar> findAll() {
        TypedQuery<ElectricGuitar> theQuery = entityManager.createQuery("FROM electricguitars", ElectricGuitar.class);

        //return query results
        return theQuery.getResultList();
    }

    @Override
    public List<ElectricGuitar> findByBrand(String theBrand) {

        //create query
        TypedQuery<ElectricGuitar> theQuery = entityManager.createQuery("FROM electricguitars WHERE brand=:theBrand", ElectricGuitar.class);

        //set query parameter
        theQuery.setParameter("brand", theBrand);

        //return the list
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
        ElectricGuitar electricGuitar = findById(id);
        entityManager.remove(electricGuitar);
    }

    @Override
    @Transactional
    public void deletebyBrand(String theBrand) {
        entityManager.createQuery("DELETE FROM ElectricGuitar WHERE Brand=:theData", ElectricGuitar.class)
                .setParameter("theData", theBrand)
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
