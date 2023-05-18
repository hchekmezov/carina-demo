package com.mfp.mobile.gui.pages.common.diary;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class EditDiaryPageBase extends AbstractPage {
    public EditDiaryPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isOpened();

    public abstract DiaryPageBase deleteAllItems();
}
