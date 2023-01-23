package com.qaprosoft.carina.demo.myMobile.android.sideMenu;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.myMobile.common.sideMenu.UIElementsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = UIElementsPageBase.class)
public class UIElementsPage extends UIElementsPageBase {

    @FindBy(id = "com.solvd.carinademoapplication:id/switch1")
    private ExtendedWebElement enableCheckbox;

    @FindBy(id = "com.solvd.carinademoapplication:id/textView")
    private ExtendedWebElement textView;

    @FindBy(id = "com.solvd.carinademoapplication:id/textView2")
    private ExtendedWebElement textView2;

    public UIElementsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return textView.isElementPresent() && textView2.isElementPresent();
    }

    @Override
    public boolean isEnableCheckboxPresent() {
        return enableCheckbox.isElementPresent();
    }

    @Override
    public boolean isEnableCheckboxChecked() {
        return enableCheckbox.isChecked();
    }

    @Override
    public void checkEnableCheckbox() {
        enableCheckbox.check();
    }
}
