package com.qaprosoft.carina.demo.myMobile.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class SideMenuPageBase extends AbstractPage {

    public SideMenuPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isMapButtonPresent();

    public abstract boolean isOpened();

    public abstract MapPageBase clickMapButton();
}
