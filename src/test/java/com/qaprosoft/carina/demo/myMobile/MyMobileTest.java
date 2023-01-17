package com.qaprosoft.carina.demo.myMobile;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.myMobile.android.enums.LoginField;
import com.qaprosoft.carina.demo.myMobile.android.enums.Sex;
import com.qaprosoft.carina.demo.myMobile.common.LoginPageBase;
import com.qaprosoft.carina.demo.myMobile.common.WebViewPageBase;
import com.qaprosoft.carina.demo.myMobile.common.WelcomePageBase;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyMobileTest implements IAbstractTest, IMobileUtils {

    public static final String NAME = "John";
    public static final String PASSWORD = "Doe";

    @Test()
    @MethodOwner(owner = "hchekmezov")
    public void verifyLoginPageTest() {
        // 1
        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        Assert.assertTrue(welcomePage.isOpened(), String.format("%s is not opened!", welcomePage.getName()));
        LoginPageBase loginPage = welcomePage.clickNextButton();
        Assert.assertTrue(loginPage.isOpened(), String.format("%s is not opened!", loginPage.getName()));
        // 2
//        for(LoginFields lf : LoginFields.values()) {
//            Assert.assertTrue(loginPage.isLoginFieldPresent(lf), String.format("%s is not present!", lf));
//        }
        Assert.assertTrue(loginPage.isLoginFieldPresent(LoginField.NAME),
                String.format("%s is not present", LoginField.NAME));
        Assert.assertTrue(loginPage.isLoginFieldPresent(LoginField.PASSWORD),
                String.format("%s is not present", LoginField.PASSWORD));
//        for(Sex sex : Sex.values()) {
//            Assert.assertTrue(loginPage.isSexElementPresent(sex), String.format("%s is not present!", sex));
//        }
        Assert.assertTrue(loginPage.isSexElementPresent(Sex.MALE), String.format("%s is not present!", Sex.MALE));
        Assert.assertTrue(loginPage.isSexElementPresent(Sex.FEMALE), String.format("%s is not present!", Sex.FEMALE));
        Assert.assertTrue(loginPage.isPrivacyCheckboxPresent(), "Privacy Checkbox is not present!");
//        for(Sex sex : Sex.values()) {
//            Assert.assertFalse(loginPage.isSexChecked(sex), String.format("%s is checked!", sex));
//        }
        Assert.assertFalse(loginPage.isSexChecked(Sex.FEMALE), String.format("%s is checked!", Sex.FEMALE));
        Assert.assertFalse(loginPage.isSexChecked(Sex.MALE), String.format("%s is checked!", Sex.MALE));
        Assert.assertFalse(loginPage.isPrivacyCheckboxChecked(), "Privacy Checkbox is checked!");
        // 3
        loginPage.typeName(NAME);
        loginPage.typePassword(PASSWORD);
        Assert.assertEquals(loginPage.getTextInField(LoginField.NAME), NAME,
                String.format("%s is not typed correctly!", LoginField.NAME));
        Assert.assertEquals(loginPage.getTextInField(LoginField.PASSWORD), PASSWORD,
                String.format("%s is not typed correctly!", LoginField.PASSWORD));
        // 4
        loginPage.checkSexRadioButton(Sex.MALE);
        Assert.assertTrue(loginPage.isSexChecked(Sex.MALE),
                String.format("%s radio button is unchecked!", Sex.MALE));
        // 5
        Assert.assertFalse(loginPage.isSignUpButtonEnabled(), "Sign Up Button is enabled!");
        // 6
        loginPage.checkPrivacyCheckbox();
        Assert.assertTrue(loginPage.isPrivacyCheckboxChecked(),
                "Privacy Checkbox is unchecked!");
        // 7
        WebViewPageBase webViewPage = loginPage.clickSignUpButton();
        Assert.assertTrue(webViewPage.isOpened(),
                String.format("%s is not opened, that means user is not logged in!", webViewPage.getName()));
    }
}
