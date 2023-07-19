package com.underarmour.mobile.pages.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.underarmour.mobile.pages.common.BottomNavigationViewBase;
import com.underarmour.mobile.pages.common.BottomNavigationViewItem;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = BottomNavigationViewBase.class)
public class BottomNavigationView extends BottomNavigationViewBase implements ICustomTypePageFactory {

    @FindBy(id = "%s")
    private ExtendedWebElement bottomNavViewItem;

    @FindBy(xpath = "//*[@resource-id='com.ua.shop:id/bottom_nav_view']/android.view.ViewGroup")
    private ExtendedWebElement viewGroup;

    public BottomNavigationView(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public boolean isPresent() {
        return viewGroup.isElementPresent();
    }

    @Override
    public boolean isItemClickable(BottomNavigationViewItem item) {
        return Boolean.parseBoolean(bottomNavViewItem.format(item.getId()).getAttribute("clickable"));
    }

    @Override
    public AbstractPage openPage(BottomNavigationViewItem item) {
        bottomNavViewItem.format(item.getId()).click();
        return initPage(driver, item.getBasePageClass());
    }
}
