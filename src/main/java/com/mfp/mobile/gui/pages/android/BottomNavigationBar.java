package com.mfp.mobile.gui.pages.android;

import com.mfp.mobile.gui.pages.common.BottomNavigationBarBase;
import com.mfp.mobile.gui.pages.common.BottomNavigationBarItem;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = BottomNavigationBarBase.class)
public class BottomNavigationBar extends BottomNavigationBarBase implements ICustomTypePageFactory {

    public BottomNavigationBar(WebDriver driver) {
        super(driver);
    }

    public BottomNavigationBar(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @FindBy(id = "com.myfitnesspal.android:id/action_%s")
    private ExtendedWebElement navBarButton;

    @FindBy(xpath = "//android.widget.FrameLayout[@resource-id='com.myfitnesspal.android:id/bottomNavigationBar']" +
            "/android.view.ViewGroup")
    private ExtendedWebElement navBarViewGroup;

    @Override
    public boolean isBottomNavBarButtonClickable(BottomNavigationBarItem item) {
        return Boolean.parseBoolean(navBarButton.format(item.getButtonName().toLowerCase()).getAttribute("clickable"));
    }

    @Override
    public boolean isBottomNavBarPresent() {
        return navBarViewGroup.isElementPresent();
    }

    @Override
    public AbstractPage clickBottomNavBarButton(BottomNavigationBarItem item) {
        navBarButton.format(item.getButtonName().toLowerCase()).click();
        return initPage(getDriver(), item.getBaseClass());
    }
}
