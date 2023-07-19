package com.underarmour.mobile.pages.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.underarmour.mobile.pages.common.BottomNavigationViewItem;
import com.underarmour.mobile.pages.common.CategoriesPageBase;
import com.underarmour.mobile.pages.common.categories.CategoriesVariant;
import com.underarmour.mobile.pages.common.UnderArmourCommonPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CategoriesPageBase.class)
public class CategoriesPage extends CategoriesPageBase {

    @FindBy(xpath = "//*[@resource-id='com.ua.shop:id/toolbar']/android.widget.TextView[@text='CATEGORIES']")
    private ExtendedWebElement title;

    public CategoriesPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return title.isElementPresent()
                && !initPage(driver, UnderArmourCommonPageBase.class)
                .getBottomNavigationView()
                .isItemClickable(BottomNavigationViewItem.CATEGORIES);
    }

    @Override
    public AbstractPage chooseVariant(CategoriesVariant variant) {
        driver.findElement(By.xpath(variant.getXpath())).click();
        return initPage(driver, variant.getBaseClass());
    }
}
