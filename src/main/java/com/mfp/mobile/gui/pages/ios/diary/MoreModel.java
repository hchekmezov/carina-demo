package com.mfp.mobile.gui.pages.ios.diary;

import com.mfp.mobile.gui.pages.common.diary.MoreModelBase;
import com.mfp.mobile.gui.pages.common.diary.MoreModelElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.exception.NotImplementedException;
import com.zebrunner.carina.utils.factory.DeviceType;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

@DeviceType(pageType = DeviceType.Type.IOS_PHONE, parentClass = MoreModelBase.class)
public class MoreModel extends MoreModelBase implements ICustomTypePageFactory {

    public MoreModel(WebDriver driver) {
        super(driver);
    }

    public MoreModel(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    @Override
    public AbstractPage openPage(MoreModelElement element) {
        throw new NotImplementedException();
    }

    @Override
    public boolean isOpened() {
        throw new NotImplementedException();
    }
}
