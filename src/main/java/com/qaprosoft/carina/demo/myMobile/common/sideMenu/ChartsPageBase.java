package com.qaprosoft.carina.demo.myMobile.common.sideMenu;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ChartsPageBase extends AbstractPage {

    public ChartsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isOpened();
}
