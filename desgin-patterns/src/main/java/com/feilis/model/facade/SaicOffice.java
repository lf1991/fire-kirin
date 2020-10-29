package com.feilis.model.facade;

/**
 * 工商局审批
 */
public class SaicOffice implements Executive {
    @Override
    public void approve() {
        System.out.println("工商局办理营业执照......");
    }
}
