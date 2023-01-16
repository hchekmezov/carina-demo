package com.qaprosoft.carina.demo.myMobile.android.additional;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;

public class LoginFormItem extends AbstractUIObject {

    private final ExtendedWebElement element;

    public LoginFormItem(WebDriver driver, ExtendedWebElement element) {
        super(driver);
        this.element = element;
    }

    public String readName() {
        return element.getName();
    }

    public boolean isElementPresent() {
        return element.isElementPresent();
    }
}
