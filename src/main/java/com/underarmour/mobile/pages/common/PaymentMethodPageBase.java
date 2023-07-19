package com.underarmour.mobile.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class PaymentMethodPageBase extends AbstractPage {
    public PaymentMethodPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isOpened();

    public abstract AbstractPage openPaymentMethod(PaymentMethod paymentMethod);

    public abstract CheckoutPageBase clickBackButton();
}
