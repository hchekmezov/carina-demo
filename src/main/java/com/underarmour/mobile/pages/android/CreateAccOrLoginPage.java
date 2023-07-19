package com.underarmour.mobile.pages.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.underarmour.mobile.pages.common.CreateAccOrLoginLayout;
import com.underarmour.mobile.pages.common.CreateAccOrLoginPageBase;
import com.underarmour.mobile.pages.common.IConstant;
import com.underarmour.mobile.pages.common.MorePageBase;
import com.zebrunner.carina.utils.android.IAndroidUtils;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = CreateAccOrLoginPageBase.class)
public class CreateAccOrLoginPage extends CreateAccOrLoginPageBase implements IAndroidUtils {


    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc='Create Account']")
    private ExtendedWebElement createAccountLayout;

    @FindBy(xpath = "//android.widget.LinearLayout[@content-desc='Log In']")
    private ExtendedWebElement loginLayout;

    @FindBy(xpath = "//*[@resource-id='com.ua.shop:id/input_email']//android.widget.EditText")
    private ExtendedWebElement loginLayoutEmailField;

    @FindBy(xpath = "//*[@resource-id='com.ua.shop:id/input_password']//android.widget.EditText")
    private ExtendedWebElement loginLayoutPasswordField;

    @FindBy(id = "com.ua.shop:id/login_button")
    private ExtendedWebElement loginLayoutLoginButton;

    @FindBy(id = "com.ua.shop:id/square_2")
    private ExtendedWebElement squareLoader;



    public CreateAccOrLoginPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return createAccountLayout.isElementPresent() && loginLayout.isElementPresent();
    }

    @Override
    public void selectLayout(CreateAccOrLoginLayout createOrLoginLayout) {
        switch (createOrLoginLayout) {
            case LOGIN_LAYOUT:
                loginLayout.click();
                break;
            case CREATE_ACCOUNT_LAYOUT:
                createAccountLayout.click();
                break;
            default:
                throw new RuntimeException("Unknown CreateAccOrLoginLayout type!");
        }
    }

    @Override
    public AbstractPage login(String email, String password, Class<? extends AbstractPage> baseClass) {
        loginLayoutEmailField.type(email);
        loginLayoutPasswordField.type(password);
        hideKeyboard();
        loginLayoutLoginButton.click();
        waitUntil(ExpectedConditions.invisibilityOfElementLocated(squareLoader.getBy()), IConstant.THIRTY_SECONDS);
        return initPage(driver, baseClass);
    }
}
