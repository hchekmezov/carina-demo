package com.qaprosoft.carina.demo.myMobile.android.additional;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import org.openqa.selenium.WebDriver;

public class CheckableItem extends AbstractUIObject {

    private final ExtendedWebElement element;

    public CheckableItem(WebDriver driver, ExtendedWebElement element) {
        super(driver);
        this.element = element;
    }

    public String readName() {
        return element.getName();
    }

    public boolean isChecked() {
        return element.isChecked();
    }
}
