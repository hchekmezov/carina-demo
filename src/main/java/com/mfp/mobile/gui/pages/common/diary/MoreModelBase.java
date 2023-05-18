package com.mfp.mobile.gui.pages.common.diary;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class MoreModelBase extends AbstractUIObject {
    public MoreModelBase(WebDriver driver) {
        super(driver);
    }

    public MoreModelBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract AbstractPage openPage(MoreModelElement element);

    public abstract boolean isOpened();
}
