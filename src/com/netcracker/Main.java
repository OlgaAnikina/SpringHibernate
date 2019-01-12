package com.netcracker;

import com.netcracker.config.SpringConfig;
import com.netcracker.model.Book;
import com.netcracker.model.Buy;
import com.netcracker.model.Buyer;
import com.netcracker.model.Shop;
import com.netcracker.services.iServices.IBookService;
import com.netcracker.services.iServices.IBuyService;
import com.netcracker.services.iServices.IBuyerService;
import com.netcracker.services.iServices.IShopService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.sql.Date;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        AbstractApplicationContext context
                = new AnnotationConfigApplicationContext(SpringConfig.class);
        IBuyerService buyerService =
                (IBuyerService) context.getBean("buyerService");
        IBookService bookService =
                (IBookService) context.getBean("bookService");
        IShopService shopService =
                (IShopService) context.getBean("shopService");


        IBuyService buyService =
                (IBuyService) context.getBean("buyService");
        Buy buy = new Buy (100, 2, new Date(System.currentTimeMillis()));
        Book book1 = new Book("Щерук ищщл", 100, "Sklad2", 1);
        Buyer buyer1 = new Buyer( "Vik","Soviet",10);
        Shop shop1 = new Shop("shop3", "Soviet", 200);
        buy.setBook(book1);
        buy.setBuyer(buyer1);
        buy.setSaller(shop1);

        buyerService.saveBuyer(buyer1);
        shopService.saveShop(shop1);
        bookService.saveBook(book1);
        buyService.saveBuy(buy);
        List<Buy> buyList = buyService.findAllBuys();
        System.out.println(buyList.size());





    }

}
