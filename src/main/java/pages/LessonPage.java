package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LessonPage {

    private WebDriver driver;
    By previewQuestionsBox =By.xpath("//div[@class='question-preview']//a");

    public LessonPage(WebDriver driver) {
        this.driver = driver;
    }
    public void openQuestionPreview(){
        WebElement previewQuestionsBoxElem = driver.findElement(previewQuestionsBox);
        //scroll to the preview box
        String scrollScrip ="arguments[0].scrollIntoView();";
        ((JavascriptExecutor)driver).executeScript(scrollScrip,previewQuestionsBoxElem);
        //click on the preview box
        previewQuestionsBoxElem.click();

    }
}
