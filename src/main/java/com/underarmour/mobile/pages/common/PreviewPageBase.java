package com.underarmour.mobile.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class PreviewPageBase extends AbstractPage {
    public PreviewPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isOpened();

    public abstract WhoDoYouFollowPageBase clickSkipButton();

}
