package com.qaprosoft.carina.demo.myMobile.common.sideMenu;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class UIElementsPageBase extends AbstractPage {
    public UIElementsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isOpened();

    public abstract boolean isEnableSwitchPresent();

    public abstract boolean isEnableSwitchChecked();

    public abstract boolean isEmailFieldPresent();

    public abstract boolean isBottomContentFramePresent();

    public abstract void checkEnableSwitch();
}
