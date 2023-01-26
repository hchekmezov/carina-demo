package com.qaprosoft.carina.demo.myMobile.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.myMobile.common.StoriesPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = StoriesPageBase.class)
public class StoriesPage extends StoriesPageBase {

    @FindBy(id = "com.joom:id/title")
    private ExtendedWebElement title;

    @FindBy(id = "com.joom:id/subtitle")
    private ExtendedWebElement subTitle;

    @FindBy(id = "com.joom:id/close_button")
    private ExtendedWebElement closeButton;

    public StoriesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return title.isElementPresent() && subTitle.isElementPresent();
    }

    @Override
    public boolean isCloseButtonPresent() {
        return closeButton.isElementPresent();
    }

    @Override
    public void clickCloseButton() {
        closeButton.click();
    }
}
