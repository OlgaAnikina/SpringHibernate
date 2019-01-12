package com.netcracker.model;


import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name="buy")
public class Buy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="buy_id")
    private int id;
    @Column(name = "cost", nullable = false)
    private Integer cost;
    @Column(name = "count", nullable = false)
    private Integer count;
    @Column(name="datebuys", nullable = false)
    private Date dateBuy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "saller")
    private Shop saller;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "buyer")
    private Buyer buyer;


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book")
    private Book book;


    public Buy() {}

    public Buy(Integer cost, Integer count, Date dateBuy) {
        this.cost = cost;
        this.count = count;
        this.dateBuy = dateBuy;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Date getDateBuy() {
        return dateBuy;
    }

    public void setDateBuy(Date dateBuy) {
        this.dateBuy = dateBuy;
    }

    public Shop getSaller() {
        return saller;
    }

    public void setSaller(Shop saller) {
        this.saller = saller;
    }

    public Buyer getBuyer() {
        return buyer;
    }

    public void setBuyer(Buyer buyer) {
        this.buyer = buyer;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    @Override
    public String toString() {
        return "Buy{" +
                "id=" + id +
                ", saller ='" + saller.toString() + '\'' +
                ", buyer ='" + buyer.toString() + '\'' +
                ", book =" + book.toString() +
                ", count =" + count +
                ", cost =" + cost +
                ", dateBuy =" + dateBuy +
                '}';
    }

}
