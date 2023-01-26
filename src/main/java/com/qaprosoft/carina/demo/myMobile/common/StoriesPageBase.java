package com.qaprosoft.carina.demo.myMobile.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class StoriesPageBase extends AbstractPage {
    public StoriesPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isOpened();

    public abstract boolean isCloseButtonPresent();

    public abstract void clickCloseButton();

}
