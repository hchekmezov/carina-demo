package com.qaprosoft.carina.demo.myMobile.common.login;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.myMobile.android.enums.LoginField;
import com.qaprosoft.carina.demo.myMobile.android.enums.Sex;
import com.qaprosoft.carina.demo.myMobile.common.sideMenu.WebViewPageBase;
import org.openqa.selenium.WebDriver;

public abstract class LoginPageBase extends AbstractPage {

    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract WebViewPageBase clickSignUpButton();

    public abstract boolean isOpened();

    /**
     * Sex.OTHER = Sex.FEMALE in this method
     * @param sex a parameter of Sex Enum
     * @return true if sex radio button checked and false if not
     */
    public abstract boolean isSexRadioButtonChecked(Sex sex);

    public abstract boolean isPrivacyCheckboxChecked();

    public abstract boolean isSignUpButtonEnabled();

    /**
     * Sex.OTHER = Sex.FEMALE in this method
     * @param sex a parameter of Sex Enum
     * @return true if sex radio element present and false if not
     */
    public abstract boolean isSexRadioButtonPresent(Sex sex);

    public abstract boolean isLoginFieldPresent(LoginField loginField);

    public abstract boolean isPrivacyCheckboxPresent();

    public abstract String getTextInField(LoginField loginField);

    public abstract void typeName(String name);

    public abstract void typePassword(String password);

    /**
     *
     * @param sex a parameter of Sex Enum, Sex.OTHER unsupported
     */
    public abstract void checkSexRadioButton(Sex sex);

    public abstract void checkPrivacyCheckbox();
}
