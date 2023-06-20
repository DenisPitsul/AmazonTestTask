package org.example.pages;

import org.example.base.BasePage;
import org.example.model.Book;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class ProductDetailPage extends BasePage {

    @FindBy(how = How.XPATH, using = "//span[@id='productTitle']")
    private WebElement productNameElem;

    @FindBy(how = How.XPATH, using = "//span[contains(@class, 'author')]/a")
    private WebElement authorElem;

    @FindBy(how = How.XPATH, using = "//*[text()='#1 Best Seller']")
    private List<WebElement> bestSellerElemList;

    public ProductDetailPage(WebDriver driver) {
        super(driver);
    }

    public boolean isBestSeller() {
        return bestSellerElemList.size() != 0;
    }

    public String getBookName() {
        return productNameElem.getText();
    }

    public String getAuthor() {
        return authorElem.getText();
    }

    public Book getBook() {
        return new Book(isBestSeller(), getBookName(), getAuthor());
    }
}
