package com.qaprosoft.carina.demo.myMobile.common.components;

import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.qaprosoft.carina.demo.myMobile.enums.BottomBarButton;
import org.openqa.selenium.WebDriver;

public abstract class BottomBarBase extends AbstractUIObject {
    public BottomBarBase(WebDriver driver) {
        super(driver);
    }

    public abstract void clickButton(BottomBarButton barButton);

    public abstract boolean isClickable(BottomBarButton barButton);

    public abstract boolean isPresent();

}
