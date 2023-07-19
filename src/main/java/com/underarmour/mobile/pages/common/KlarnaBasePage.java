package com.underarmour.mobile.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class KlarnaBasePage extends AbstractPage {
    public KlarnaBasePage(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isOpened();

    public abstract PaymentMethodPageBase clickBackButton();
}
