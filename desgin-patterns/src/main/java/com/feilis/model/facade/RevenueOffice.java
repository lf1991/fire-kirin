package com.feilis.model.facade;

/**
 * 税务局类
 */
public class RevenueOffice implements Executive {
    @Override
    public void approve() {
        System.out.println("税务局完成登记......");
    }
}
