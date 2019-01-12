package com.netcracker;

import com.netcracker.config.SpringConfig;
import com.netcracker.services.iServices.IBookService;
import com.netcracker.services.iServices.IBuyService;
import com.netcracker.services.iServices.IBuyerService;
import com.netcracker.services.iServices.IShopService;
import com.netcracker.tasks.TaskFive;
import com.netcracker.tasks.TaskFourth;
import com.netcracker.tasks.TaskThree;
import com.netcracker.tasks.TaskTwo;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

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

        System.out.println("TASK TWO:");
        TaskTwo.getInfo(bookService, buyService, buyerService);

        System.out.println("TASK THREE:");
        TaskThree.getInfo(buyerService, bookService, shopService);

        System.out.println("TASK FOUR:");
        TaskFourth.getInfo(buyService);

        System.out.println("TASK FIVE:");
        TaskFive.getInfo(buyService);





    }

}
