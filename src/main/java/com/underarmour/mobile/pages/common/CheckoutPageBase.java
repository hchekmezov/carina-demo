package com.underarmour.mobile.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CheckoutPageBase extends AbstractPage {
    public CheckoutPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isOpened();

    public abstract ShippingAddressPageBase openShippingAddressPage();

    public abstract PaymentMethodPageBase openPaymentPage();

    public abstract boolean isPlaceOrderButtonEnabled();
}
