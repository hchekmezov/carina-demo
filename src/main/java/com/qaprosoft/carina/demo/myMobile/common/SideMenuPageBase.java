package com.qaprosoft.carina.demo.myMobile.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.myMobile.android.enums.SideMenuButton;
import org.openqa.selenium.WebDriver;

public abstract class SideMenuPageBase extends AbstractPage {

    public SideMenuPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isButtonOfSideMenuPresent(SideMenuButton sideMenuButton);

    public abstract boolean isOpened();

    public abstract AbstractPage clickButtonOfSideMenu(SideMenuButton sideMenuButton);
}
