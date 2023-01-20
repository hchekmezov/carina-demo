package com.qaprosoft.carina.demo.myMobile;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.demo.myMobile.android.enums.LoginField;
import com.qaprosoft.carina.demo.myMobile.android.enums.Sex;
import com.qaprosoft.carina.demo.myMobile.android.enums.SideMenuButton;
import com.qaprosoft.carina.demo.myMobile.android.enums.ZoomButton;
import com.qaprosoft.carina.demo.myMobile.common.*;
import com.zebrunner.carina.core.registrar.ownership.MethodOwner;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class MyMobileTest implements IAbstractTest, IMobileUtils {

    public static final String NAME = "John";
    public static final String PASSWORD = "Doe";

    @BeforeMethod
    public void defaultlogin() {
        WelcomePageBase welcomePageBase = initPage(getDriver(), WelcomePageBase.class);
        LoginPageBase loginPageBase = welcomePageBase.clickNextButton();
        loginPageBase.typeName(NAME);
        loginPageBase.typePassword(PASSWORD);
        loginPageBase.checkSexRadioButton(Sex.MALE);
        loginPageBase.checkPrivacyCheckbox();
        loginPageBase.clickSignUpButton();
    }

    @Test(enabled = false)
    @MethodOwner(owner = "hchekmezov")
    public void verifyLoginPageTest() {
        // 1
        WelcomePageBase welcomePage = initPage(getDriver(), WelcomePageBase.class);
        Assert.assertTrue(welcomePage.isOpened(), "[Welcome Page] Welcome Page is not opened!");
        LoginPageBase loginPage = welcomePage.clickNextButton();
        Assert.assertTrue(loginPage.isOpened(),
                "[Login Page] Login Page is not opened after clicking Next Button!");
        // 2
//        for(LoginFields lf : LoginFields.values()) {
//            Assert.assertTrue(loginPage.isLoginFieldPresent(lf),
//            String.format("[Login Page] %s field is not present!", lf));
//        }
        Assert.assertTrue(loginPage.isLoginFieldPresent(LoginField.NAME),
                String.format("[Login Page] %s field is not present!", LoginField.NAME));
        Assert.assertTrue(loginPage.isLoginFieldPresent(LoginField.PASSWORD),
                String.format("[Login Page] %s field is not present", LoginField.PASSWORD));
//        for(Sex sex : Sex.values()) {
//            Assert.assertTrue(loginPage.isSexRadioButtonPresent(sex),
//            String.format("[Login Page] %s radio button is not present!", sex));
//        }
        Assert.assertTrue(loginPage.isSexRadioButtonPresent(Sex.MALE),
                String.format("[Login Page] %s radio button is not present!", Sex.MALE));
        Assert.assertTrue(loginPage.isSexRadioButtonPresent(Sex.FEMALE),
                String.format("[Login Page] %s radio button is not present!", Sex.FEMALE));
        Assert.assertTrue(loginPage.isPrivacyCheckboxPresent(),
                "[Login Page] Privacy Checkbox radio button is not present!");
//        for(Sex sex : Sex.values()) {
//            Assert.assertFalse(loginPage.isSexChecked(sex),
//            String.format("[Login Page] %s radio button is checked without checking it!", sex));
//        }
        Assert.assertFalse(loginPage.isSexRadioButtonChecked(Sex.FEMALE),
                String.format("[Login Page] %s radio button is checked without checking it!", Sex.FEMALE));
        Assert.assertFalse(loginPage.isSexRadioButtonChecked(Sex.MALE),
                String.format("[Login Page] %s radio button is checked without checking it!", Sex.MALE));
        Assert.assertFalse(loginPage.isPrivacyCheckboxChecked(),
                "[Login Page] Privacy Checkbox radio button is checked without checking it!");
        // 3
        loginPage.typeName(NAME);
        loginPage.typePassword(PASSWORD);
        Assert.assertEquals(loginPage.getTextInField(LoginField.NAME), NAME,
                String.format("[Login Page] %s field is not filled correctly!", LoginField.NAME));
        Assert.assertEquals(loginPage.getTextInField(LoginField.PASSWORD), PASSWORD,
                String.format("[Login Page] %s field is not filled correctly!", LoginField.PASSWORD));
        // 4
        loginPage.checkSexRadioButton(Sex.MALE);
        Assert.assertTrue(loginPage.isSexRadioButtonChecked(Sex.MALE),
                String.format("[Login Page] %s radio button is unchecked after checking it!", Sex.MALE));
        // 5
        Assert.assertFalse(loginPage.isSignUpButtonEnabled(),
                "[Login Page] Sign Up Button is enabled when it should be disabled!");
        // 6
        loginPage.checkPrivacyCheckbox();
        Assert.assertTrue(loginPage.isPrivacyCheckboxChecked(),
                "[Login Page] Privacy Checkbox is unchecked after checking it!");
        // 7
        WebViewPageBase webViewPage = loginPage.clickSignUpButton();
        Assert.assertTrue(webViewPage.isOpened(),
                "[Login Page] Web View Page is not opened, that means user is not logged in!");
    }

    @Test()
    @MethodOwner(owner = "hchekmezov")
    public void verifyMapFeatureTest() {
        // 1
        WebViewPageBase webViewPage = initPage(getDriver(), WebViewPageBase.class);
        Assert.assertTrue(webViewPage.isOpened(),
                "[Web View Page] Web View Page is not opened after clicking Sign Up Button, " +
                        "that means user is not logged in!");
        // 2
        Assert.assertTrue(webViewPage.isSideMenuButtonPresent(),
                "[Web View Page] Side Menu Button is not present!");
        SideMenuPageBase sideMenu = webViewPage.clickSideMenuButton();
        Assert.assertTrue(sideMenu.isOpened(),
                "[Side Menu Page] Side Menu Page isn't opened after clicking Side Menu Button");
        Assert.assertTrue(sideMenu.isButtonOfSideMenuPresent(SideMenuButton.MAP_BUTTON),
                "[Side Menu Page] Map Button is not present after clicking Side Menu Button");
        MapPageBase mapPage = (MapPageBase) sideMenu.clickButtonOfSideMenu(SideMenuButton.MAP_BUTTON);
        Assert.assertTrue(mapPage.isOpened(),
                "[Map Page] Map Page isn't opened after clicking Map Button");
        SoftAssert softAssert = new SoftAssert();
        for(ZoomButton zoomButton : ZoomButton.values()) {
            softAssert.assertTrue(mapPage.isZoomButtonPresent(zoomButton),
                    String.format("[Map Page] %s zoom button is not present!", zoomButton));
        }
        softAssert.assertAll();
    }
}
