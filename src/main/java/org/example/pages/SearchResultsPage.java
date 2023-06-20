package org.example.pages;

import org.example.base.BasePage;
import org.example.components.HeaderComponent;
import org.example.components.SearchResultItemComponent;
import org.example.model.Book;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.ArrayList;
import java.util.List;

public class SearchResultsPage extends BasePage {

    protected List<SearchResultItemComponent> searchResultItemComponentList;

    @FindBy(how = How.XPATH, using = "//span[@data-component-type='s-search-results']//div[@data-component-type='s-search-result']")
    private List<WebElement> searchResultItems;

    public SearchResultsPage(WebDriver driver) {
        super(driver);
        searchResultItemComponentList = new ArrayList<>();
        for (WebElement searchResultItem: searchResultItems) {
            searchResultItemComponentList.add(new SearchResultItemComponent(driver, searchResultItem));
        }
    }

    public List<Book> getBookList() {
        List<Book> bookList = new ArrayList<>();
        for (SearchResultItemComponent searchResultItemComponent: searchResultItemComponentList) {
            boolean isBestSeller = searchResultItemComponent.isBestSeller();
            String bookName = searchResultItemComponent.getBookName();
            String author = searchResultItemComponent.getAuthor();
            List<String> prices = searchResultItemComponent.getPrices();
            Book book = new Book(isBestSeller, bookName, author, prices);
            bookList.add(book);
        }
        return bookList;
    }
}
