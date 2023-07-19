package com.underarmour.mobile.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ShippingAddressPageBase extends AbstractPage {
    public ShippingAddressPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isOpened();

    public abstract boolean isAnyShippingAddressExists();

    public abstract void chooseRandomAvailableAddress();

    public abstract CheckoutPageBase clickBackButton();
}
