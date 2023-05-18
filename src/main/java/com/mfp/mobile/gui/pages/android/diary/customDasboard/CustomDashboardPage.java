package com.mfp.mobile.gui.pages.android.diary.customDasboard;

import com.mfp.mobile.gui.pages.common.IConstant;
import com.mfp.mobile.gui.pages.common.diary.DiaryPageBase;
import com.mfp.mobile.gui.pages.common.diary.customDashboard.CustomDashboardItem;
import com.mfp.mobile.gui.pages.common.diary.customDashboard.CustomDashboardPageBase;
import com.mfp.mobile.gui.pages.common.diary.customDashboard.CustomSummaryPageBase;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CustomDashboardPageBase.class)
public class CustomDashboardPage extends CustomDashboardPageBase {
    public CustomDashboardPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//android.view.ViewGroup[@resource-id='com.myfitnesspal.android:id/toolbar']" +
            "/android.widget.TextView")
    private ExtendedWebElement pageTitle;

    @FindBy(id = "com.myfitnesspal.android:id/rb%s")
    private ExtendedWebElement customDashboardItemById;

    @Override
    public boolean isOpened() {
        return pageTitle.isElementPresent()
                && pageTitle.getText().equals(IConstant.CUSTOM_DASHBOARD);
    }

    @Override
    public boolean isCustomDashboardItemPresent(CustomDashboardItem item) {
        return customDashboardItemById.format(item.getItemId()).isElementPresent();
    }

    @Override
    public AbstractPage clickCustomDashboardItem(CustomDashboardItem item) {
        Assert.assertTrue(isCustomDashboardItemPresent(item),
                String.format("[Custom Dashboard Page] %s dashboard page item is not present!", item));
        customDashboardItemById.format(item.getItemId()).click();
        if (item.equals(CustomDashboardItem.CUSTOM)) {
            return initPage(getDriver(), CustomSummaryPageBase.class);
        }
        return initPage(getDriver(), DiaryPageBase.class);
    }
}
