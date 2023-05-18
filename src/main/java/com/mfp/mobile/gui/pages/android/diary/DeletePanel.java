package com.mfp.mobile.gui.pages.android.diary;

import com.mfp.mobile.gui.pages.common.diary.DeletePanelBase;
import com.mfp.mobile.gui.pages.common.diary.DiaryPageBase;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = DeletePanelBase.class)
public class DeletePanel extends DeletePanelBase implements ICustomTypePageFactory {
    public DeletePanel(WebDriver driver) {
        super(driver);
    }

    public DeletePanel(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @FindBy(id = "android:id/button1")
    private ExtendedWebElement deleteButton;

    @FindBy(id = "android:id/button2")
    private ExtendedWebElement cancelButton;

    @Override
    public boolean isPanelPresent() {
        return deleteButton.isElementPresent()
                && cancelButton.isElementPresent();
    }

    @Override
    public DiaryPageBase clickDeleteButton() {
        deleteButton.click();
        return initPage(getDriver(), DiaryPageBase.class);
    }
}
