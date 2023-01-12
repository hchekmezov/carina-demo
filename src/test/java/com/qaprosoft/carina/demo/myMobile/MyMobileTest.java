package com.qaprosoft.carina.demo.myMobile;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.myMobile.common.LoginPageBase;
import com.qaprosoft.carina.demo.myMobile.common.WebViewPageBase;
import com.qaprosoft.carina.demo.myMobile.common.WelcomePageBase;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyMobileTest implements IAbstractTest, IMobileUtils {
    String name = "John";
    String password = "Doe";

    @Test()
    @MethodOwner(owner = "gleb")
    public void verifyLoginPage() {
        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        Assert.assertTrue(welcomePage.isPageOpened(), "Welcome page is not opened!");
        LoginPageBase loginPage = welcomePage.openLoginPageByClickNextBtn();
        Assert.assertTrue(loginPage.isPageOpened(), "Login page is not opened!");
        // 1
        Assert.assertTrue(loginPage.isNameFieldPresent(), "Name field is not present!");
        Assert.assertTrue(loginPage.isPasswordFieldPresent(), "Password field is not present");
        Assert.assertTrue(loginPage.isFemaleRadioPresent(), "Female radio button is not present!");
        Assert.assertTrue(loginPage.isMaleRadioPresent(), "Male radio button is not present!");
        Assert.assertTrue(loginPage.isPrivacyCheckboxPresent(), "Privacy checkbox is not present!");
        Assert.assertTrue(loginPage.isFemaleRadioUnchecked(), "Female radio button is checked!");
        Assert.assertTrue(loginPage.isMaleRadioUnchecked(), "Male radio button is checked");
        Assert.assertTrue(loginPage.isPrivacyCheckboxUnchecked(), "Privacy checkbox is checked!");
        Assert.assertTrue(loginPage.isSignUpBtnDisabled(), "Sign up button is enabled!");
        // 2
        loginPage.typeName(name);
        loginPage.typePassword(password);
        Assert.assertTrue(loginPage.isTypedCorrectName(name), "Name is not typed!");
        Assert.assertTrue(loginPage.isTypedCorrectPassword(password), "Password is not typed!");
        // 3
        loginPage.checkMailRadioButton();
        Assert.assertFalse(loginPage.isMaleRadioUnchecked(), "Male radio button is unchecked!");
        // 4
        loginPage.checkPrivacyCheckbox();
        Assert.assertFalse(loginPage.isPrivacyCheckboxUnchecked(), "Privacy checkbox is unchecked!");
        // 5
        Assert.assertFalse(loginPage.isSignUpBtnDisabled(), "Sign Up button is disabled!");
        WebViewPageBase webViewPage = loginPage.openWebViewPageByClickSignUpBtn();
        Assert.assertTrue(webViewPage.isPageOpened(), "Web View page is not opened, that means user is not logged in!");
        // 6
    }
}
