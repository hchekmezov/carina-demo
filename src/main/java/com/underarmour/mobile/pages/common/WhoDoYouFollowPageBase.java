package com.underarmour.mobile.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class WhoDoYouFollowPageBase extends AbstractPage {
    public WhoDoYouFollowPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isOpened();

   public abstract WhoDoYouShopForPageBase clickSkipButton();

    // public abstract ForYouPageBase clickSkipButton();
}
