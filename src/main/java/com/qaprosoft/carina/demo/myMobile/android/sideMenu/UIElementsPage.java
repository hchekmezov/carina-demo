package com.qaprosoft.carina.demo.myMobile.android.sideMenu;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.myMobile.common.sideMenu.UIElementsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = UIElementsPageBase.class)
public class UIElementsPage extends UIElementsPageBase implements IMobileUtils {

    @FindBy(xpath = "//android.view.ViewGroup/android.widget.FrameLayout")
    private ExtendedWebElement bottomContentFrame;

    @FindBy(id = "com.solvd.carinademoapplication:id/textView")
    private ExtendedWebElement topAccountName;

    @FindBy(id = "com.solvd.carinademoapplication:id/textView2")
    private ExtendedWebElement botAccountName;

    @FindBy(id = "com.solvd.carinademoapplication:id/editText2")
    private ExtendedWebElement emailField;

    @FindBy(id = "com.solvd.carinademoapplication:id/switch1")
    private ExtendedWebElement enableSwitch;

    public UIElementsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return topAccountName.isElementPresent() && botAccountName.isElementPresent();
    }

    @Override
    public boolean isEnableSwitchPresent() {
        swipe(enableSwitch, bottomContentFrame, Direction.UP, 5, 1000);
        return enableSwitch.isElementPresent();
    }

    @Override
    public boolean isEnableSwitchChecked() {
        return enableSwitch.isChecked();
    }

    @Override
    public boolean isEmailFieldPresent() {
        return emailField.isElementPresent();
    }

    @Override
    public boolean isBottomContentFramePresent() {
        return bottomContentFrame.isElementPresent();
    }

    @Override
    public void checkEnableSwitch() {
        enableSwitch.check();
    }
}
