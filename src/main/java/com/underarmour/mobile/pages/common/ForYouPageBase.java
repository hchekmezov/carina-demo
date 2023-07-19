package com.underarmour.mobile.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ForYouPageBase extends AbstractPage {
    public ForYouPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isOpened();
}
