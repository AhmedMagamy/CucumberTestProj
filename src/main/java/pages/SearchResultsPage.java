package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchResultsPage {
    private WebDriver driver;
    By secondSearchResult =By.xpath("(//ul[@class='list']/li/div/a)[2]");

    public SearchResultsPage(WebDriver driver) {
        this.driver = driver;
    }
    public void openSecondLesson(){
        //open the second lesson
        driver.findElement(secondSearchResult).click();
    }

}
