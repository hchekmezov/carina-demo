package com.underarmour.mobile.pages.android.categories;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.underarmour.mobile.pages.common.categories.MensCategoriesPageBase;
import com.underarmour.mobile.pages.common.categories.MensCategoriesVariant;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MensCategoriesPageBase.class)
public class MensCategoriesPage extends MensCategoriesPageBase {

    @FindBy(xpath = "//*[@resource-id='com.ua.shop:id/toolbar']/android.widget.TextView[@text=\"MEN'S\"]")
    private ExtendedWebElement title;

    public MensCategoriesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return title.isElementPresent();
    }

    @Override
    public AbstractPage chooseVariant(MensCategoriesVariant variant) {
        driver.findElement(By.xpath(variant.getXpath())).click();
        return initPage(driver, variant.getBaseClass());
    }
}
