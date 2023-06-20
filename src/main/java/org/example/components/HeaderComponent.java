package org.example.components;

import org.example.base.BaseComponent;
import org.example.pages.SearchResultsPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class HeaderComponent extends BaseComponent {

    private static final String CATEGORY_XPATH = "//option[text()='%s']";

    @FindBy(how = How.XPATH, using = "//select")
    private WebElement searchCategoryElem;

    @FindBy(how = How.XPATH, using = "//input[@id='twotabsearchtextbox']")
    private WebElement searchInput;

    @FindBy(how = How.XPATH, using = "//input[@id='nav-search-submit-button']")
    private WebElement searchBtn;

    public HeaderComponent(WebDriver driver, WebElement node) {
        super(driver, node);
    }

    public void selectCategory(String category) {
        //waitForElementToAppear(searchCategoryElem);
        searchCategoryElem.click();
        driver.findElement(By.xpath(String.format(CATEGORY_XPATH, category))).click();
    }

    public void search(String searchText) {
        //waitForElementToAppear(searchInput);
        searchInput.sendKeys(searchText);
        searchBtn.click();
    }

    public SearchResultsPage searchItemWithCategory(String categoryValue, String searchText) {
        selectCategory(categoryValue);
        search(searchText);
        return new SearchResultsPage(driver);
    }
}
