package com.qaprosoft.carina.demo.myMobile.common.sideMenu;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class CommonPageBase extends AbstractPage {
    public CommonPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isNavigateButtonPresent();

    public abstract SideMenuPageBase clickNavigateButton();
}
