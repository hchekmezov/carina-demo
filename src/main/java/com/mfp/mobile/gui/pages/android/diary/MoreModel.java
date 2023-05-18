package com.mfp.mobile.gui.pages.android.diary;

import com.mfp.mobile.gui.pages.common.diary.MoreModelBase;
import com.mfp.mobile.gui.pages.common.diary.MoreModelElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MoreModelBase.class)
public class MoreModel extends MoreModelBase implements ICustomTypePageFactory {
    public MoreModel(WebDriver driver) {
        super(driver);
    }

    public MoreModel(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @FindBy(xpath = "//android.widget.TextView[@text='%s']/..")
    private ExtendedWebElement moreModelButton;

    @FindBy(id = "com.myfitnesspal.android:id/listViewList")
    private ExtendedWebElement buttonList;

    @Override
    public AbstractPage openPage(MoreModelElement element) {
        moreModelButton.format(element.getButtonName()).click();
        return initPage(getDriver(), element.getBaseClass());
    }

    @Override
    public boolean isOpened() {
        return buttonList.isElementPresent();
    }
}
