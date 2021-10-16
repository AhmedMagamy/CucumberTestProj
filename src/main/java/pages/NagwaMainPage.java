package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NagwaMainPage {
    private WebDriver driver;
    By searchBtn = By.xpath("//button[@type='button']");
    By searchField =By.id("txt_search_query");


    public NagwaMainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void selectLanguage (String lang){
        WebElement langButton = driver.findElement(By.xpath("//a[normalize-space()='"+lang+"']"));
        //wait for the button of the language to be visible
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(langButton));
        //click on the button
        langButton.click();

    }

    public void insertLessonInSearchText(String lesson){
        WebElement searchBtnElem = driver.findElement(searchBtn);
        //wait for the search button to be visible
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(searchBtnElem));
        //click on the button
        searchBtnElem.click();
        WebElement searchFieldElem = driver.findElement(searchField);
        //wait for the search field to be visible
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOf(searchFieldElem));
        //set the text field with search result
        searchFieldElem.sendKeys(lesson);
        //click enter
        searchFieldElem.sendKeys(Keys.ENTER);

    }
}
