package com.feilis.model.facade;

/**
 * 卫生局类
 */
public class HealthOffice implements Executive {
    @Override
    public void approve() {
        System.out.println("卫生局通过审批......");
    }
}
