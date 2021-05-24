package Common;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class UIModule {
    public static WebDriver driver;

    public WebDriver initialiseDriver() throws Exception{


        System.setProperty("webdriver.chrome.driver","/Users/nehafatima/PlanItTest/src/main/resources/chromedriver");
        driver = new ChromeDriver();
        return driver;
    }
    public void navigateUrl(String url) throws Exception{
        driver.navigate().to(url);
    }
    public void click(By by) throws Exception{
        fluentWait(by,5).click();
    }

    public void enterText(By by,String text) throws Exception{
        fluentWait(by,5).clear();
        fluentWait(by,5).sendKeys(text);
    }

    public String getText(By by) throws Exception{
        return fluentWait(by,15).getText();
    }
    public String getValueAttribute(By by) throws Exception{
        return fluentWait(by,15).getAttribute("value");
    }

    public boolean verifyPageSourceContains(String text) throws Exception{
        if(driver.getPageSource().contains(text)) return true;
        else return false;
    }

    public WebElement fluentWait(By by,int time) throws Exception{
        WebElement currentElement=null;
        Wait<WebDriver> wait= null;
        try{
            wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(time))
                    .pollingEvery(Duration.ofMillis(200)).ignoring(NoSuchElementException.class).
                            ignoring(StaleElementReferenceException.class);
            currentElement = wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return currentElement;

        }catch (Exception e){
            System.out.println("Waiting for element to be displayed");
        }
        return currentElement;

    }

    public boolean checkElementDoesNotExist(By by) throws Exception{
        try{
            driver.findElement(by);
            return false;
        }catch (Exception e){
            return true;
        }
    }

    public void closeDriver(){
        driver.quit();
    }

    public int getIndexofQuantity() throws Exception{

        Thread.sleep(1000);
        List<WebElement> list= driver.findElements(By.tagName("th"));

        int quantityIndex=0;

        for(WebElement element: list){
            if(element.getText().equals("Quantity")){
                quantityIndex= list.indexOf(element) + 1;
            }
        }
        return quantityIndex;
    }

    public int getIndexofPrice() throws Exception{

        Thread.sleep(1000);
        List<WebElement> list= driver.findElements(By.tagName("th"));

        int quantityIndex=0;

        for(WebElement element: list){
            if(element.getText().equals("Price")){
                quantityIndex= list.indexOf(element) + 1;
            }
        }
        return quantityIndex;
    }

    public int getIndexofSubTotal() throws Exception{

        Thread.sleep(1000);
        List<WebElement> list= driver.findElements(By.tagName("th"));

        int quantityIndex=0;

        for(WebElement element: list){
            if(element.getText().equals("Subtotal")){
                quantityIndex= list.indexOf(element) + 1;
            }
        }
        return quantityIndex;
    }
}
