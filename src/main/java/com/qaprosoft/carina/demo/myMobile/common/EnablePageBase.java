package com.qaprosoft.carina.demo.myMobile.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;


public abstract class EnablePageBase extends AbstractPage {
    public EnablePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isOpened();

    public abstract boolean isDontAllowButtonPresent();

    public abstract void clickEnableButton();

    public abstract void clickDontAllowButton();
}
