package com.netcracker.tasks;

import com.netcracker.model.Book;
import com.netcracker.model.Buy;
import com.netcracker.model.Buyer;
import com.netcracker.services.iServices.IBookService;
import com.netcracker.services.iServices.IBuyService;
import com.netcracker.services.iServices.IBuyerService;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TaskTwo {
    //a)всех различных названий и стоимостей книг;
    //b)всех различных районов, в которых проживают покупатели;
    //c)всех различных месяцев, когда производились покупки.
    private static void differentNameAndCostBook(IBookService bookService) {
        List<Book> books = bookService.findAllBooks();
        Set<String> namesSet = new HashSet<>();
        Set<Integer> coastSet = new HashSet<>();

        for (int i = 0; i < books.size(); i++) {
            namesSet.add(books.get(i).getBookname());
            coastSet.add(books.get(i).getCost());
        }

        System.out.println("Different names of books:");
        namesSet.forEach((e) -> {
            System.out.println(e);
        });

        System.out.println("Different coast of books:");
        coastSet.forEach((e) -> {
            System.out.println(e);
        });

    }

    private static void differentDistrict(IBuyerService buyerService) {
        List<Buyer> buyerList = buyerService.findAllBuyers();
        Set<String> districtSet = new HashSet<>();
        for (int i = 0; i < buyerList.size(); i++) {
            districtSet.add(buyerList.get(i).getDistrict());
        }
        System.out.println("Different districts of buyers:");
        districtSet.forEach((e) -> {
            System.out.println(e);
        });
    }

    private static void differentDateOfBuy(IBuyService buyService) {
        List<Buy> buyList = buyService.findAllBuys();
        Set<Integer> monthSet = new HashSet<>();
        for (int i = 0; i < buyList.size(); i++) {
            monthSet.add(buyList.get(i).getMonth());
        }
        System.out.println("Different month of buys:");
        monthSet.forEach((e) -> {
            System.out.println(e);
        });
    }

    public static void getInfo(IBookService bookService,
                               IBuyService buyService, IBuyerService buyerService) {
        System.out.println();
        differentNameAndCostBook(bookService);
        System.out.println();
        differentDistrict(buyerService);
        System.out.println();
        differentDateOfBuy(buyService);
        System.out.println();
    }


}
