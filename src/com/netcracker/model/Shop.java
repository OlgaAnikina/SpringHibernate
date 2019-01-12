package com.netcracker.model;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;


@Entity
@Table(name="shop")
public class Shop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="shop_id")
    private int id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "district", nullable = false)
    private String district;
    @Column(name="commissions", nullable = false)
    private Integer commission;

    @OneToMany(mappedBy = "saller", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Buy> buys;

    public Shop() {}

   public List<Buy> getBuys() {
        return buys;
    }

    public void setBuys(List<Buy> buys) {
        this.buys = buys;
    }

    public void addBuy(Buy buy) {
        buy.setSaller(this);
        buys.add(buy);
    }

    public void removeBuy(Buy buy) {
        buys.remove(buy);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Integer getCommission() {
        return commission;
    }

    public void setCommission(Integer commission) {
        this.commission = commission;
    }

    public Shop(String name, String district, Integer commission) {
        this.name = name;
        this.district = district;
        this.commission =commission;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", district='" + district + '\'' +
                ", commission=" + commission +
                '}';
    }
}


