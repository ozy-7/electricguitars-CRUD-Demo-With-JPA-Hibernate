package com.example.cruddemo.electricguitars.electricguitars.dao;

import com.example.cruddemo.electricguitars.electricguitars.entity.ElectricGuitar;

import java.util.List;

public interface ElectricGuitarDAO {
    void save(ElectricGuitar theElectricGuitar);
    ElectricGuitar findById(Integer id);
    List<ElectricGuitar> findAll();
    List<ElectricGuitar> findByBrand(String theBrand);
    void update (ElectricGuitar theElectricGuitar);
    void deleteById(Integer id);
    void deletebyBrand(String theBrand);
    int deleteAll();

}
