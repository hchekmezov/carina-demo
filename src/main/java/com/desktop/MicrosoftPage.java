package com.desktop;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.annotations.Localized;
import com.qaprosoft.carina.core.gui.AbstractPage;
import com.zebrunner.carina.utils.R;

import com.zebrunner.carina.utils.resources.L10N;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

import javax.ws.rs.core.Context;
import java.util.ArrayList;
import java.util.List;

public class MicrosoftPage extends AbstractPage {

    // for github actions

    public MicrosoftPage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(String.format("https://www.microsoft.com/%s", R.CONFIG.get("locale")
                .toLowerCase().replace('_', '-')));
    }

    @FindBy(id = "locale-picker-link")
    private ExtendedWebElement localeLink;

    @Localized
    @FindBy(xpath = "//*[@class='c-heading-4' and text()='{L10N:MicrosoftPage.educationDiv}']")
    private ExtendedWebElement educationDiv;

    @Localized
    @FindBy(xpath = "//*[@class='c-heading-4' and text()='{L10N:MicrosoftPage.educationDiv}']" +
            "//following-sibling::ul/li")
    private List<ExtendedWebElement> educationLinks;

    public LocalePage openLocalePage(WebDriver driver) {
        localeLink.click();
        return new LocalePage(driver);
    }

    public void hoverEducationDiv(){
        educationDiv.hover();
    }

    public void hoverHeaders(){
        for (ExtendedWebElement educationLink: educationLinks) {
            educationLink.hover();
        }
    }

    public String getEducationDivText() {
        return educationDiv.getText();
    }

    public List<String> getEducationLinksText() {
        List<String> text = new ArrayList<>();
        for (ExtendedWebElement educationLink: educationLinks) {
                text.add(educationLink.getText());
        }
        return text;
    }


}
