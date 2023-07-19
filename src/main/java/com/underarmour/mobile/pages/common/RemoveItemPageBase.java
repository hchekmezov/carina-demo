package com.underarmour.mobile.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class RemoveItemPageBase extends AbstractPage {
    public RemoveItemPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isOpened();

    public abstract BagPageBase clickRemoveButton();
}
