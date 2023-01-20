package com.qaprosoft.carina.demo.myMobile.android;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.myMobile.common.SideMenuPageBase;
import com.qaprosoft.carina.demo.myMobile.common.UIElementsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = UIElementsPageBase.class)
public class UIElementsPage extends UIElementsPageBase {

    @FindBy(xpath = "//android.view.ViewGroup/android.widget.ImageButton")
    private ExtendedWebElement navigateButton;

    @FindBy(id = "com.solvd.carinademoapplication:id/editText")
    private ExtendedWebElement editTextField;

    @FindBy(id = "com.solvd.carinademoapplication:id/checkBox2")
    private ExtendedWebElement copyCheckbox;

    public UIElementsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return copyCheckbox.isElementPresent() && editTextField.isElementPresent();
    }

    @Override
    public boolean isNavigateButtonPresent() {
        return navigateButton.isElementPresent();
    }

    @Override
    public SideMenuPageBase clickNavigateButton() {
        navigateButton.click();
        return initPage(getDriver(), SideMenuPageBase.class);
    }
}
