package com.mfp.mobile.gui.pages.android;

import com.mfp.mobile.gui.pages.common.*;
import com.mfp.mobile.gui.pages.common.BottomNavigationBarBase;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = MFPCommonPageBase.class)
public class MFPCommonPage extends MFPCommonPageBase {
    public MFPCommonPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "com.myfitnesspal.android:id/bottomNavigationBar")
    private BottomNavigationBar bottomNavigationBar;

    @FindBy(id = "com.myfitnesspal.android:id/progressPleaseWait")
    private ExtendedWebElement progressSpinner;

    @Override
    public BottomNavigationBarBase getBottomNavigateBar() {
        return bottomNavigationBar;
    }

    @Override
    public DashboardPageBase login(String email, String password){
        PreviewPageBase previewPage = initPage(getDriver(), PreviewPageBase.class);
        Assert.assertTrue(previewPage.isOpened(),
                "[Preview Page] Preview Page is not opened!");
        LogInPageBase logInPage = previewPage.clickLogInButton();
        Assert.assertTrue(logInPage.isOpened(),
                "[LogIn Page] LogIn Page is not opened after clicking Log In Button!");
        logInPage.typeEmailAndPassword(email, password);
        Assert.assertTrue(logInPage.isLogInButtonEnabled(),
                "[LogIn Page] Log In Button is not enabled after filling Email and Password fields!");
        return logInPage.getDashboardPage();
    }

    @Override
    public boolean waitUntilSpinnerRounding() {
        return waitUntil(ExpectedConditions.invisibilityOfElementLocated(progressSpinner.getBy()),
                IConstant.THIRTY_SECONDS);
    }
}
