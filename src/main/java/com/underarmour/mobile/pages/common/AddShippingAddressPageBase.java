package com.underarmour.mobile.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class AddShippingAddressPageBase extends AbstractPage {
    public AddShippingAddressPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isOpened();
}
