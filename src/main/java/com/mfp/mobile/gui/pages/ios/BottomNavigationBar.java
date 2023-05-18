package com.mfp.mobile.gui.pages.ios;

import com.mfp.mobile.gui.pages.common.BottomNavigationBarItem;
import com.mfp.mobile.gui.pages.common.BottomNavigationBarBase;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = BottomNavigationBarBase.class)
public class BottomNavigationBar extends BottomNavigationBarBase implements ICustomTypePageFactory {

    public BottomNavigationBar(WebDriver driver) {
        super(driver);
    }

    public BottomNavigationBar(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public AbstractPage clickBottomNavBarButton(BottomNavigationBarItem item) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isBottomNavBarButtonClickable(BottomNavigationBarItem item) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isBottomNavBarPresent() {
        throw new NotImplementedException();
    }
}
