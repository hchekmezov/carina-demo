package com.mfp.mobile.gui.pages.android;

import com.mfp.mobile.gui.pages.common.BottomNavigationBarItem;
import com.mfp.mobile.gui.pages.common.MFPCommonPageBase;
import com.mfp.mobile.gui.pages.common.NewsfeedPageBase;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = NewsfeedPageBase.class)
public class NewsfeedPage extends NewsfeedPageBase {

    public NewsfeedPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//android.view.ViewGroup[@resource-id='com.myfitnesspal.android:id/toolbar']" +
            "/android.widget.TextView")
    private ExtendedWebElement title;

    @Override
    public boolean isOpened() {
        return title.isElementPresent()
                && title.getText().equals(BottomNavigationBarItem.NEWSFEED_BUTTON.getButtonName())
                && !(initPage(getDriver(), MFPCommonPageBase.class))
                .getBottomNavigateBar()
                .isBottomNavBarButtonClickable(BottomNavigationBarItem.NEWSFEED_BUTTON);
    }
}
