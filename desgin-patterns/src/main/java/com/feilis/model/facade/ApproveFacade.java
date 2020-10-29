package com.feilis.model.facade;

/**
 * 门面类
 */
public class ApproveFacade {

    private static HealthOffice healthOffice;
    private static RevenueOffice revenueOffice;
    private static SaicOffice saicOffice;

    static {
        healthOffice = new HealthOffice();
        revenueOffice = new RevenueOffice();
        saicOffice = new SaicOffice();
    }

    /**
     * 登记注册门面类
     */
    void approve() {
        healthOffice.approve();
        revenueOffice.approve();
        saicOffice.approve();
    }

}
