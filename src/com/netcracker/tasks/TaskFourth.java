package com.netcracker.tasks;

import com.netcracker.model.Buy;
import com.netcracker.services.iServices.IBuyService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskFourth {
    // a.	фамилию покупателя и название магазина, где производилась покупка;
    //  b.	дату, фамилию покупателя, скидку, название и количество купленных книг

    private static void fioBuyerAndShopsName(IBuyService buyService) {
        List<Buy> buys = buyService.findAllBuys();
        Map<String, String> fioName = new HashMap<>();
        for(int i = 0; i < buys.size(); i++) {
            Buy buy = buys.get(i);
            fioName.put(buy.getBuyer().getFirstName(), buy.getSaller().getName());
        }

        System.out.println("Fio and name of shop:");
        fioName.forEach((e, k) -> {
            System.out.println("FIO = " + e + " Shop's name = " + k);
        });

    }

    private static void infoOfBuy(IBuyService buyService) {
        List<Buy> buys = buyService.findAllBuys();
        System.out.println("Info of buys:");
        for(int i = 0; i < buys.size(); i++) {
            Buy buy = buys.get(i);
            System.out.println("Date of buy :" + buy.getDateBuy());
            System.out.println("Fio of buyer :" + buy.getBuyer().getFirstName());
            System.out.println("Sale of buy :" + buy.getBuyer().getSale());
            System.out.println("Sale of buy :" + buy.getBuyer().getSale());
            System.out.println("Name of book :" + buy.getBook().getBookname());
            System.out.println("Count of book :" + buy.getCount());

        }

    }

    public static void getInfo(IBuyService buyService) {
        fioBuyerAndShopsName(buyService);
        System.out.println();
        infoOfBuy(buyService);
        System.out.println();
    }

}
