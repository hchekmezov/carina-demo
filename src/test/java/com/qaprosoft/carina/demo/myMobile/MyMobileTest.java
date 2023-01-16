package com.qaprosoft.carina.demo.myMobile;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.myMobile.android.additional.CheckableItem;
import com.qaprosoft.carina.demo.myMobile.android.enums.LoginFields;
import com.qaprosoft.carina.demo.myMobile.android.additional.LoginFormItem;
import com.qaprosoft.carina.demo.myMobile.android.enums.Sex;
import com.qaprosoft.carina.demo.myMobile.common.LoginPageBase;
import com.qaprosoft.carina.demo.myMobile.common.WebViewPageBase;
import com.qaprosoft.carina.demo.myMobile.common.WelcomePageBase;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class MyMobileTest implements IAbstractTest, IMobileUtils {

    public static final String NAME = "John";
    public static final String PASSWORD = "Doe";

    @Test()
    @MethodOwner(owner = "hchekmezov")
    public void verifyLoginPageTest() {
        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        Assert.assertTrue(welcomePage.isOpened(), String.format("%s is not opened!", welcomePage.getName()));
        LoginPageBase loginPage = welcomePage.clickNextButton();
        Assert.assertTrue(loginPage.isOpened(), String.format("%s is not opened!", loginPage.getName()));
        // 1
        List<LoginFormItem> loginFormItems = loginPage.getLoginFormItems();
        for(LoginFormItem it : loginFormItems) {
            Assert.assertTrue(it.isElementPresent(), String.format("%s is not present!", it.readName()));
        }
        List<CheckableItem> checkableItems = loginPage.getCheckableItems();
        for(CheckableItem it : checkableItems) {
            Assert.assertFalse(it.isChecked(), String.format("%s is checked!", it.readName()));
        }
        // 2
        loginPage.typeName(NAME);
        loginPage.typePassword(PASSWORD);
        Assert.assertEquals(loginPage.getTextInField(LoginFields.NAME), NAME,
                String.format("%s is not typed correctly!", LoginFields.NAME.toString()));
        Assert.assertEquals(loginPage.getTextInField(LoginFields.PASSWORD), PASSWORD,
                String.format("%s is not typed correctly!", LoginFields.PASSWORD.toString()));
        // 3
        loginPage.checkSexRadioButton(Sex.MALE);
        Assert.assertTrue(loginPage.isSexChecked(Sex.MALE),
                String.format("%s radio button is unchecked!", Sex.MALE.toString()));
        // 4
        loginPage.checkPrivacyCheckbox();
        Assert.assertTrue(loginPage.isPrivacyCheckboxChecked(),
                "Privacy checkbox is unchecked!");
        // 5
        WebViewPageBase webViewPage = loginPage.clickSignUpButton();
        Assert.assertTrue(webViewPage.isOpened(),
                String.format("%s is not opened, that means user is not logged in!", webViewPage.getName()));
        // 6
    }

    @Test()
    @MethodOwner(owner = "hchekmezov")
    public void verifySignUpBtnActivityTest() {
        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        LoginPageBase loginPage = welcomePage.clickNextButton();
        loginPage.typeName(NAME);
        loginPage.typePassword(PASSWORD);
        loginPage.checkSexRadioButton(Sex.FEMALE);
        Assert.assertFalse(loginPage.isSignUpButtonEnabled(), "Sign up button is enabled!");
    }

}
