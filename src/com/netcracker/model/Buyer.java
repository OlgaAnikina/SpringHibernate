package com.netcracker.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="buyer")
public class Buyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="buyer_id")
    private Long id;
    @Column(name = "first_name", nullable = false)
    private String firstName;
    @Column(name = "district", nullable = false)
    private String district;
    @Column(name="sale", nullable = false)
    private Integer sale;


   @OneToMany(mappedBy = "buyer", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Buy> buys;

    public List<Buy> getBuys() {
        return buys;
    }

    public void setBuys(List<Buy> buys) {
        this.buys = buys;
    }

    public void addBuy(Buy buy) {
        buy.setBuyer(this);
        buys.add(buy);
    }

    public void removeBuy(Buy buy) {
        buys.remove(buy);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public Integer getSale() {
        return sale;
    }

    public void setSale(Integer sale) {
        this.sale = sale;
    }

    public Buyer() {
    }


    public Buyer(  String firstName, String district, Integer sale) {
        this.firstName = firstName;
        this.district = district;
        this.sale = sale;
    }

    @Override
    public String toString() {
        return "Buyer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", district='" + district + '\'' +
                ", sale=" + sale +
                '}';
    }

}
