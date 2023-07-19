package com.mfp.mobile.gui.pages.common;

import com.qaprosoft.carina.core.foundation.webdriver.IDriverPool;
import com.qaprosoft.carina.core.gui.AbstractUIObject;
import com.zebrunner.carina.utils.factory.ICustomTypePageFactory;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;

public abstract class ConfirmationMessagePanelBase extends AbstractUIObject implements ICustomTypePageFactory {

    public ConfirmationMessagePanelBase(WebDriver driver, SearchContext searchContext) {
        super(driver, searchContext);
    }

    public abstract boolean isPresent();

    public abstract LogInPageBase clickOkButton();

}
