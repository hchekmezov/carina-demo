package com.qaprosoft.carina.demo.myMobile.common.sideMenu;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.myMobile.android.enums.ZoomButton;
import org.openqa.selenium.WebDriver;

public abstract class MapPageBase extends AbstractPage {
    public MapPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isOpened();

    public abstract boolean isZoomButtonPresent(ZoomButton zoomButton);

}
