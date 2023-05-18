package com.mfp.mobile.gui.pages.common.diary;

import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class DeletePanelBase extends AbstractUIObject {
    public DeletePanelBase(WebDriver driver) {
        super(driver);
    }

    public DeletePanelBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract boolean isPanelPresent();

    public abstract DiaryPageBase clickDeleteButton();
}
