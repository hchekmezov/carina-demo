package com.qaprosoft.carina.demo.myMobile.common.sideMenu;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.myMobile.android.enums.Sex;
import org.openqa.selenium.WebDriver;

public abstract class UIElementsPageBase extends AbstractPage {
    public UIElementsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isOpened();

    public abstract boolean isEnableSwitchPresent();

    public abstract boolean isEmailFieldPresent();

    public abstract boolean isBottomContentFramePresent();

    public abstract boolean isSexRadioButtonChecked(Sex sex);

    public abstract boolean isSexRadioButtonPresent(Sex sex);

    public abstract void checkSexRadioButton(Sex sex);
}
