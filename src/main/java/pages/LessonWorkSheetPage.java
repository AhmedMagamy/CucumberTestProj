package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class LessonWorkSheetPage {
    private WebDriver driver;
    By questions = By.xpath("//div[@class=\"instance \"]");



    public LessonWorkSheetPage(WebDriver driver) {
        this.driver = driver;
    }

    public int getNumberOfQuestions(){
        //scroll to the end of the page to make sure the dom is full loaded
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
        //get list of all question
        List <WebElement> questionsElems = driver.findElements(questions);
        //return the number of the question in the list
        return questionsElems.size();

    }
}
