package com.netcracker.model;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="book")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="book_id")
    private int id;
    @Column(name = "bookname", nullable = false)
    private String bookname;
    @Column(name = "cost", nullable = false)
    private Integer cost;
    @Column(name="warehouse", nullable = false)
    private String warehouse;
    @Column(name = "count", nullable = false)
    private Integer count;

    @OneToMany(mappedBy = "book", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Buy> buys;



    public Book() {};

    public Book(String bookname, Integer cost, String warehouse, Integer count) {
        this.bookname = bookname;
        this.cost = cost;
        this.warehouse = warehouse;
        this.count = count;
    }

    public List<Buy> getBuys() {
        return buys;
    }

    public void setBuys(List<Buy> buys) {
        this.buys = buys;
    }

    public void addBuy(Buy buy) {
        buy.setBook(this);
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

    public String getBookname() {
        return bookname;
    }

    public void setBookname(String bookname) {
        this.bookname = bookname;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }

    public String getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(String warehouse) {
        this.warehouse = warehouse;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", bookname='" + bookname + '\'' +
                ", cost='" + cost + '\'' +
                ", warehouse=" + warehouse +
                ", count =" + count +
                '}';
    }
}
