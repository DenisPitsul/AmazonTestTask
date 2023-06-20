import org.example.model.Book;
import org.example.pages.HomePage;
import org.example.pages.ProductDetailPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SearchTest extends BaseTestRunnerUI {

    public static final String CATEGORY = "Books";
    public static final String SEARCH_TEXT = "Java";

    @Test
    public void searchBooksTest() {
        driver.get("https://www.amazon.com/Head-First-Java-Kathy-Sierra/dp/0596009208/ref=sr_1_2?dchild=1&keywords=Java&qid=1610356790&s=books&sr=1-2");
        Book book = new ProductDetailPage(driver)
                .getBook();

        driver.get("https://www.amazon.com/");
        List<Book> bookList = new HomePage(driver)
                .getHeader()
                .searchItemWithCategory(CATEGORY, SEARCH_TEXT)
                .getBookList();

        boolean isBookFound = false;
        for (Book bookItem: bookList) {
            if (bookItem.getName().equals(book.getName())) {
                isBookFound = true;
                break;
            }
        }

        Assert.assertTrue(isBookFound, book.getName() + " was not found on search results page.");
    }
}
