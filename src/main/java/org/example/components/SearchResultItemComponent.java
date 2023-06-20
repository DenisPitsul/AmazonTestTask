package org.example.components;

import org.example.base.BaseComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

public class SearchResultItemComponent extends BaseComponent {

    @FindBy(how = How.XPATH, using = ".//span[text()='Best Seller']")
    private List<WebElement> bestSellerElemList;

    @FindBy(how = How.XPATH, using = ".//h2//span")
    private WebElement nameElem;

    @FindBy(how = How.XPATH, using = ".//span[contains(text(), 'by')]//following-sibling::*[1]")
    private WebElement authorElem;

    @FindBy(how = How.XPATH, using = ".//span[@class='a-price']")
    private List<WebElement> priceElemList;

    public SearchResultItemComponent(WebDriver driver, WebElement node) {
        super(driver, node);
    }

    public boolean isBestSeller() {
        return bestSellerElemList.size() != 0;
    }

    public String getBookName() {
        return nameElem.getText();
    }

    public String getAuthor() {
        return authorElem.getText();
    }

    public List<String> getPrices() {
        List<String> prices = new ArrayList<>();
        for (WebElement priceElem: priceElemList) {
            String[] priceArray = priceElem.getText().split("\n");
            String dollar = priceArray[0];
            String cent = priceArray[1];
            String price = dollar + "." + cent;
            prices.add(price);
        }
        return prices;
    }
}
