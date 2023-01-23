package com.qaprosoft.carina.demo.myMobile.common.sideMenu;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class UIElementsPageBase extends AbstractPage {
    public UIElementsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isOpened();

    public abstract boolean isEnableCheckboxPresent();

    public abstract boolean isEnableCheckboxChecked();

    public abstract void checkEnableCheckbox();
}
