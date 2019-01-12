package com.netcracker.tasks;

import com.netcracker.model.Buy;
import com.netcracker.services.iServices.IBuyService;

import java.util.*;
import java.util.stream.Collectors;

public class TaskFive {

    // a.	номер заказа, фамилию покупателя и дату для покупок,
    // в которых было продано книг на сумму не меньшую чем 60000 руб.

    // b.	покупки, сделанные покупателем в своем районе не ранее марта месяца.
    // Вывести фамилию покупателя, район, дату. Произвести сортировку;

    // c.	магазины, расположенные в любом районе, кроме Автозаводского,
    // где покупали книги те, у кого скидка от 10 до 15 %;

    //  d.	данные по покупке книг (название, район складирования, количество),
    //  приобретенных в районе складирования и содержащихся в запасе более 10 штук.
    //  Включить данные о стоимости и отсортировать по возрастанию.

    private static void aTask(List<Buy> buys) {
        System.out.println("If cost of buy more than 60000:");
        for (int i = 0; i < buys.size(); i++) {
            Buy buy = buys.get(i);
            if (buy.getCost() > 60000) {
                System.out.println("Order of buy: " + buy.getId());
                System.out.println("Fio og buyer: " + buy.getBuyer().getFirstName());
                System.out.println("Date of buy: " + buy.getDateBuy());
            }
        }
    }

    private static void bTask(List<Buy> buys) {
        System.out.println("If date of buy was later than Mart:");
        Map<Buy, Integer> buyerInfo = new HashMap<>();
        for (int i = 0; i < buys.size(); i++) {
            Buy buy = buys.get(i);
            if ((buy.getMonth() > 3) && (buy.getSaller().getDistrict()
                    .equals(buy.getBuyer().getDistrict()))) {
                buyerInfo.put(buy, buy.getMonth());
            }
            buyerInfo = TaskThree.sortByValue(buyerInfo);

            buyerInfo.forEach((e, k) -> {
                System.out.println("Name = " + e.getBuyer().getFirstName() +
                        " District = " + e.getBuyer().getDistrict()
                        + e.getDateBuy());
            });
        }
    }

    private static void cTask(List<Buy> buys) {
        Map<String, String> fioName = new HashMap<>();
        for (int i = 0; i < buys.size(); i++) {
            Buy buy = buys.get(i);
            if (!(buy.getSaller().getDistrict().
                    contains(TaskThree.districts.Avtozavod.toString()))) {
                if ((buy.getBuyer().getSale() < 15) && (buy.getBuyer().getSale() > 10)) {
                    fioName.put(buy.getSaller().getName(), buy.getBuyer().getFirstName());
                }
            }
        }
        System.out.println("Fio and name of shop if 10 < sale < 15 and without Avtozavod :");
        fioName.forEach((e, k) -> {
            System.out.println("FIO = " + e + " Shop's name = " + k);
        });
    }

    private static void dTask(List<Buy> buys) {

        Map<Buy, Integer> buyInfo = new HashMap<>();
        for (int i = 0; i < buys.size(); i++) {
            Buy buy = buys.get(i);
            if (buy.getBook().getCount() > 10) {
                buyInfo.put(buy, buy.getCost());
            }
        }
        buyInfo = sortByValue(buyInfo);
        System.out.println("Info of buy, if books of them have more then 10 in warehouse :");
        buyInfo.forEach((e, k) -> {
            System.out.println("Name of book = " + e.getBook().getBookname());
            System.out.println("District of warehouse = " + e.getBook().getWarehouse());
            System.out.println("Count in the warehouse = " + e.getBook().getCount());
            System.out.println("Cost of the buy = " + k);

        });

    }

    private static Map<Buy, Integer> sortByValue(Map<Buy, Integer> map) {
        return map.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (e1, e2) -> e1,
                        LinkedHashMap::new
                ));
    }

    public static void getInfo(IBuyService buyService) {
        List<Buy> buys = buyService.findAllBuys();
        System.out.println();
        aTask(buys);
        System.out.println();
        bTask(buys);
        System.out.println();
        cTask(buys);
        System.out.println();
        dTask(buys);
        System.out.println();

    }
}
