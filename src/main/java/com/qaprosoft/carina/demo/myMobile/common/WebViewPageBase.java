package com.qaprosoft.carina.demo.myMobile.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class WebViewPageBase extends AbstractPage {

    public WebViewPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isOpened();

    public abstract boolean isMapButtonPresent();

    public abstract void clickImageButton();

    public abstract MapPageBase clickMapButton();

    public abstract boolean isImageButtonPresent();
}
