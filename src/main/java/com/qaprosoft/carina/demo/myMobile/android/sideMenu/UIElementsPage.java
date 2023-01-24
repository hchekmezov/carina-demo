package com.qaprosoft.carina.demo.myMobile.android.sideMenu;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.demo.myMobile.android.enums.Sex;
import com.qaprosoft.carina.demo.myMobile.common.sideMenu.UIElementsPageBase;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.mobile.IMobileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = UIElementsPageBase.class)
public class UIElementsPage extends UIElementsPageBase implements IMobileUtils {

    @FindBy(id = "com.solvd.carinademoapplication:id/content_frame")
    private ExtendedWebElement bottomContentFrame;

    @FindBy(id = "com.solvd.carinademoapplication:id/textView")
    private ExtendedWebElement topAccountName;

    @FindBy(id = "com.solvd.carinademoapplication:id/textView2")
    private ExtendedWebElement botAccountName;

    @FindBy(id = "com.solvd.carinademoapplication:id/editText2")
    private ExtendedWebElement emailField;

    @FindBy(id = "com.solvd.carinademoapplication:id/switch1")
    private ExtendedWebElement enableSwitch;

    @FindBy(id = "com.solvd.carinademoapplication:id/radioButton")
    private ExtendedWebElement radioMale;

    @FindBy(id = "com.solvd.carinademoapplication:id/radioButton3")
    private ExtendedWebElement radioFemale;

    @FindBy(id = "com.solvd.carinademoapplication:id/radioButton5")
    private ExtendedWebElement radioOther;

    public UIElementsPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public boolean isOpened() {
        return topAccountName.isElementPresent() && botAccountName.isElementPresent();
    }

    @Override
    public boolean isEnableSwitchPresent() {
        swipe(enableSwitch, bottomContentFrame, Direction.UP, 2, 1000);
        return enableSwitch.isElementPresent();
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
    public boolean isSexRadioButtonChecked(Sex sex) {
        if (sex.equals(Sex.OTHER)) {
            return radioOther.isChecked();
        } else if (sex.equals(Sex.FEMALE)) {
            return radioFemale.isChecked();
        } else {
            return radioMale.isChecked();
        }
    }

    @Override
    public boolean isSexRadioButtonPresent(Sex sex) {
        if (sex.equals(Sex.OTHER)) {
            return radioOther.isElementPresent();
        } else if (sex.equals(Sex.FEMALE)) {
            return radioFemale.isElementPresent();
        } else {
            return radioMale.isElementPresent();
        }
    }

    @Override
    public void checkSexRadioButton(Sex sex) {
        if (sex.equals(Sex.OTHER)) {
            radioOther.check();
        } else if (sex.equals(Sex.FEMALE)) {
            radioFemale.check();
        } else {
            radioMale.check();
        }
    }
}
