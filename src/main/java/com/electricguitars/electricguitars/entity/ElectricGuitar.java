package com.electricguitars.electricguitars.entity;
import jakarta.persistence.*;

@Entity
@Table(name="electricguitars")
public class ElectricGuitar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="brand")
    private String Brand;

    @Column(name="model")
    private String Model;

    @Column(name="pickup")
    private String Pickup;

    @Column(name="fret_count")
    private int fretCount;

    @Column(name="wood_type")
    private String WoodType;

    public ElectricGuitar(String Brand, String Model, String Pickup, int fretCount, String WoodType) {
        this.Brand = Brand;
        this.Model = Model;
        this.Pickup = Pickup;
        this.fretCount = fretCount;
        this.WoodType = WoodType;
    }

    public ElectricGuitar() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getPickup() {
        return Pickup;
    }

    public void setPickup(String pickup) {
        Pickup = pickup;
    }

    public int getFretCount() {
        return fretCount;
    }

    public void setFretCount(int fretCount) {
        this.fretCount = fretCount;
    }

    public String getWoodType() {
        return WoodType;
    }

    public void setWoodType(String woodType) {
        WoodType = woodType;
    }

    @Override
    public String toString() {
        return "ElectricGuitar{" +
                "id=" + id +
                ", Brand='" + Brand + '\'' +
                ", Model='" + Model + '\'' +
                ", Pickup='" + Pickup + '\'' +
                ", fretCount=" + fretCount +
                ", WoodType='" + WoodType + '\'' +
                '}';
    }
}
