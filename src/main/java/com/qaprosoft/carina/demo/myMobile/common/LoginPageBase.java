package com.qaprosoft.carina.demo.myMobile.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.myMobile.android.additional.CheckableItem;
import com.qaprosoft.carina.demo.myMobile.android.enums.LoginFields;
import com.qaprosoft.carina.demo.myMobile.android.additional.LoginFormItem;
import com.qaprosoft.carina.demo.myMobile.android.enums.Sex;
import org.openqa.selenium.WebDriver;

import java.util.List;

public abstract class LoginPageBase extends AbstractPage {

    public LoginPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract WebViewPageBase clickSignUpButton();

    public abstract boolean isOpened();

    public abstract boolean isSexChecked(Sex sex);

    public abstract boolean isPrivacyCheckboxChecked();

    public abstract boolean isSignUpButtonEnabled();

    public abstract String getTextInField(LoginFields loginField);

    public abstract void typeName(String name);

    public abstract void typePassword(String password);

    public abstract void checkSexRadioButton(Sex sex);

    public abstract void checkPrivacyCheckbox();

    public abstract List<LoginFormItem> getLoginFormItems();

    public abstract List<CheckableItem> getCheckableItems();

    public abstract String getName();

}
