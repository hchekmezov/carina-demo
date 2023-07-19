package com.underarmour.mobile.pages.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ActivitiesInterestsPageBase extends AbstractPage {
    public ActivitiesInterestsPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isOpened();

    public abstract ForYouPageBase clickSkipButton();
}
