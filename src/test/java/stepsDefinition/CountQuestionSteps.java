package stepsDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.LessonPage;
import pages.LessonWorkSheetPage;
import pages.NagwaMainPage;
import pages.SearchResultsPage;
import utilites.ExcelUtility;

import java.util.concurrent.TimeUnit;

public class CountQuestionSteps {
    public WebDriver driver;
    private NagwaMainPage nagwaMainPage ;
    private SearchResultsPage searchResultsPage;
    private LessonPage lessonPage;
    private LessonWorkSheetPage lessonWorkSheetPage;
    ExcelUtility excel = new ExcelUtility("TestData.xlsx");

    @Before
    public void setup() {
        //initialization and setup
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20,TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
    @BeforeStep
    public void callPages(){
        nagwaMainPage = new NagwaMainPage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        lessonPage = new LessonPage(driver);
        lessonWorkSheetPage = new LessonWorkSheetPage(driver);
    }


    @Given("User opened Nagwa website")
    public void user_opened_nagwa_website() {
        // open Nagwa website
        driver.get("https://www.nagwa.com/");
    }
    @When("user choose the language")
    public void user_choose_the_language() {
        //Read the language from external excel file
        String language = excel.getCellDataString("InOutData",1,0);
        //click on the selected language button
        nagwaMainPage.selectLanguage(language);

    }
    @And("user search for lesson")
    public void user_search_for_lesson() {
        // Read the lesson we need to search for from external excel file
        String lessonToSearchFor= excel.getCellDataString("InOutData",1,1);
        // search for the lesson
        nagwaMainPage.insertLessonInSearchText("Animals");

    }
    @And("user select the second lesson")
    public void user_select_the_second_lesson() {
        //open the second result
        searchResultsPage.openSecondLesson();

    }
    @And("user click the preview of the worksheet of that lesson")
    public void user_click_the_preview_of_the_worksheet_of_that_lesson() {
        //open the preview in worksheet
        lessonPage.openQuestionPreview();

    }
    @Then("print the number of question that the user found")
    public void print_the_number_of_question_that_the_user_found(){
        //get the number of the question
        Integer qs =lessonWorkSheetPage.getNumberOfQuestions();
        //write the result in external excel sheet
        excel.setCellData("InOutData",2,1,qs.toString());
        //print the result on the console
        System.out.println(qs);


    }

    @After
    public void close() {

        // Close the browser
        driver.quit();
    }

}
