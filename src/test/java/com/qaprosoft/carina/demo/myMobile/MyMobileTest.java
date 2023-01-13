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
    final String name = "John";
    final String password = "Doe";

    @Test()
    @MethodOwner(owner = "hchekmezov")
    public void verifyLoginPageTest() {
        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        Assert.assertTrue(welcomePage.isOpened(), "Welcome page is not opened!");
        LoginPageBase loginPage = welcomePage.clickNextButton();
        Assert.assertTrue(loginPage.isOpened(), "Login page is not opened!");
        // 1
        Assert.assertTrue(loginPage.isElementPresent("name"), "Name field is not present!");
        Assert.assertTrue(loginPage.isElementPresent("password"), "Password field is not present");
        Assert.assertTrue(loginPage.isElementPresent("radio_female"), "Female radio button " +
                "is not present!");
        Assert.assertTrue(loginPage.isElementPresent("radio_male"), "Male radio button is not " +
                "present!");
        Assert.assertTrue(loginPage.isElementPresent("checkbox"), "Privacy checkbox is not " +
                "present!");
        Assert.assertTrue(loginPage.isElementUnchecked("radio_female"), "Female radio button is " +
                "checked!");
        Assert.assertTrue(loginPage.isElementUnchecked("radio_male"), "Male radio button is " +
                "checked");
        Assert.assertTrue(loginPage.isElementUnchecked("checkbox"), "Privacy checkbox is " +
                "checked!");
        // 2
        loginPage.typeName(name);
        loginPage.typePassword(password);
        Assert.assertEquals(loginPage.getTextInField("name"), name, "Name is not typed correctly!");
        Assert.assertEquals(loginPage.getTextInField("password"), password, "Password is not typed " +
                "correctly!");
        // 3
        loginPage.checkRadioElement("radio_male");
        Assert.assertTrue(loginPage.isElementsChecked("radio_male"), "Male radio button " +
                "is unchecked!");
        // 4
        loginPage.checkRadioElement("checkbox");
        Assert.assertTrue(loginPage.isElementsChecked("checkbox"), "Privacy checkbox " +
                "is unchecked!");
        // 5
        WebViewPageBase webViewPage = loginPage.clickSignUpButton();
        Assert.assertTrue(webViewPage.isOpened(), "Web View page is not opened, " +
                "that means user is not logged in!");
        // 6
    }
}
