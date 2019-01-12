package com.netcracker.tasks;

import com.netcracker.model.Book;
import com.netcracker.model.Buyer;
import com.netcracker.model.Shop;
import com.netcracker.services.iServices.IBookService;
import com.netcracker.services.iServices.IBuyService;
import com.netcracker.services.iServices.IBuyerService;
import com.netcracker.services.iServices.IShopService;

import java.util.*;
import java.util.stream.Collectors;

public class TaskThree {
    public enum districts {Nizhegorodsky, Soviet, Sormovo, Avtozavod}

    //a)	фамилиях и размере скидки всех покупателей, проживающих в Нижегородском районе;
    //b)	названиях магазинов Сормовского или Советского районов;
    //c)	Названиях  и стоимости книг, в которых встречается слово Windows, или стоящих более 20000 руб.
    // Вывод результатов организовать по названию и убыванию цены книг.

    private static void fioAndSale(IBuyerService buyerService) {
        List<Buyer> buyers = buyerService.findAllBuyers();
        Map<String, Integer> fioSale = new HashMap<>();
        for (int i = 0; i < buyers.size(); i++) {
            if (buyers.get(i).getDistrict().contains(districts.Nizhegorodsky.toString()))
                fioSale.put(buyers.get(i).getFirstName(), buyers.get(i).getSale());
        }

        System.out.println("Fio and sale buyer of Nizhegorodsky district:");
        fioSale.forEach((e, k) -> {
            System.out.println("FIO = " + e + " SALE = " + k);
        });
    }

    private static void namesOfShop(IShopService shopService) {
        List<Shop> shops = shopService.findAllShops();
        Map<String, String> namesShop = new HashMap<>();

        for (int i = 0; i < shops.size(); i++) {
            if ((shops.get(i).getDistrict().contains(districts.Soviet.toString()) ||
                    (shops.get(i).getDistrict().contains(districts.Sormovo.toString()))))
                namesShop.put(shops.get(i).getName(), shops.get(i).getDistrict());
        }

        System.out.println("Shop's name of Soviet and Sormovo districts:");
        namesShop.forEach((e, k) -> {
            System.out.println("Name = " + e + " District = " + k);
        });
    }

    private static void namesWithWindows(IBookService bookService) {
        List<Book> books = bookService.findAllBooks();
        Map<String, Integer> fioCost = new HashMap<>();
        for (int i = 0; i < books.size(); i++) {
            if ((books.get(i).getBookname().contains("Windows")) ||
                    (books.get(i).getCost() > 20000))
                fioCost.put(books.get(i).getBookname(), books.get(i).getCost());
        }
        fioCost = sortByValue(fioCost);
        System.out.println("Name with 'Windows' or cost more than 20000:");
        fioCost.forEach((e, k) -> {
            System.out.println("Name = " + e + " Cost = " + k);
        });

    }

    public static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Collections.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

    public static void getInfo(IBuyerService buyerService,
                               IBookService bookService, IShopService shopService){
        System.out.println();
        fioAndSale(buyerService);
        System.out.println();
        namesOfShop(shopService);
        System.out.println();
        namesWithWindows(bookService);
        System.out.println();
    }
}
