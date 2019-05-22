package com.ostanin.service.interfaces;

import com.ostanin.dto.Order;

public interface IOrderService {

    int summa(String[] title1, String[] additionalIngr);

    void orderCheck(Order order);

    void orderZakaz(Order orderVhodnoy);

}
