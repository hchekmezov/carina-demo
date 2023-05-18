package com.mfp.mobile.gui.pages.ios.diary;

import com.mfp.mobile.gui.pages.common.diary.QuickAddPageBase;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = QuickAddPageBase.class)
public class QuickAddPage extends QuickAddPageBase {


    public QuickAddPage(WebDriver driver) {
        super(driver);
    }

    @Override
    public void typeFat(int value) {
        throw new NotImplementedException();
    }

    @Override
    public void typeCarbohydrates(int value) {
        throw new NotImplementedException();
    }

    @Override
    public void typeProtein(int value) {
        throw new NotImplementedException();
    }

    @Override
    public int getCaloriesIntValue() {
        throw new NotImplementedException();
    }

    @Override
    public boolean isOpened() {
        throw new NotImplementedException();
    }

    @Override
    public void typeNutrients(int fat, int carbohydrates, int protein) {
        throw new NotImplementedException();
    }
}
