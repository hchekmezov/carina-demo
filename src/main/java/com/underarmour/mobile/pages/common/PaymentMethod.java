package com.underarmour.mobile.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;

public enum PaymentMethod {
    CREDIT_AND_DEBIT_CARDS("com.ua.shop:id/credit_debit_payment_method", null),
    PAYPAL("com.ua.shop:id/paypal_payment_method", null),
    KLARNA("com.ua.shop:id/klarna_payment_method", KlarnaBasePage.class);

    private final String id;
    private final Class<? extends AbstractPage> baseClass;

    PaymentMethod(String id, Class<? extends AbstractPage> baseClass) {
        this.baseClass = baseClass;
        this.id = id;
    }


    public String getId() {
        return id;
    }

    public Class<? extends AbstractPage> getBaseClass() {
        return baseClass;
    }
}
