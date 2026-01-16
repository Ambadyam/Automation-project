package pagepackage;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URI;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LLBeanpageclass {

    ChromeDriver driver;

    @FindBy(xpath = "/html/body/div[1]/header/nav/div[1]/div[2]/div/div[3]/div[1]/div/div/div/form/input[1]")
    WebElement search;

    @FindBy(xpath = "/html/body/div[1]/header/nav/div[1]/div[2]/div/div[3]/div[1]/div/div/div/form/button[2]")
    WebElement searchbutton;

    @FindBy(xpath = "//*[@id=\"1\"]")
    WebElement mensclick;

    @FindBy(xpath = "//*[@id=\"plpSortOrder\"]")
    WebElement sortby;

    @FindBy(xpath="//a[contains(@href,'llbean.com')]")
    WebElement logo;
    
    @FindBy(xpath = "/html/body/div[1]/header/nav/div[1]/div[1]/div/div/div/div[2]/div[1]/div/div/a/span")
    WebElement login;
    
    @FindBy(xpath = "/html/body/div[1]/header/nav/div[1]/div[2]/div/div[3]/div[1]/div/div/div/form/input[1]")
    WebElement search1;
    
    @FindBy(name = "search-button")
    WebElement button;
    
    

    public LLBeanpageclass(ChromeDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);   
    }
    

    public void searchproduct() {
    	search.click();
    	search.sendKeys("Shirt");
    	searchbutton.click();

    	String resultUrl = driver.getCurrentUrl();

    	if (resultUrl.toLowerCase().contains("shirt")) {
    	    System.out.println("Search for 'Shirt' is successful");
    	} else {
    	    System.out.println("Search for 'Shirt' failed");
    	}

    	driver.navigate().back();

    }
    //-----------------DATA DRIVEN---------------------------------
    public void dataDrivenpg() throws IOException, InterruptedException {

        FileInputStream file = new FileInputStream("C:\\Users\\kkm21\\Downloads\\Testing\\selenium libraries\\Apachepoi\\exceldata.xlsx");

        XSSFWorkbook wb = new XSSFWorkbook(file);
        XSSFSheet sh = wb.getSheet("Sheet1"); 

        int rowcount = sh.getLastRowNum();
        System.out.println(rowcount);

        for (int i = 1; i <= rowcount; i++) {

            String username = sh.getRow(i).getCell(0).getStringCellValue(); // username
            String password = sh.getRow(i).getCell(1).getStringCellValue(); // password
            
            login.click();
            driver.findElement(By.id("login-form-email")).clear();
            driver.findElement(By.id("login-form-email")).sendKeys(username);

            driver.findElement(By.id("login-form-password")).clear();
            driver.findElement(By.id("login-form-password")).sendKeys(password);

            driver.findElement(By.xpath("//*[@id=\"login\"]/form/div[4]/button")).click();
            Thread.sleep(2000);
            System.out.println("data driven succesful");
           driver.navigate().back();
           
        }

      
    }
   

   
    	
    
  //-------------------MOUSE OVER-------------------------------
    public void mouseOver() throws InterruptedException {
		WebElement mouse=driver.findElement(By.xpath("//*[@id=\"3\"]"));
		WebElement kids=driver.findElement(By.xpath("//*[@id=\"sg-navbar-collapse\"]/div/div/nav/div[2]/ul[1]/li[4]/div[1]/div/div[2]/div/div[2]/div/div[4]/a/div"));
		Actions act=new Actions(driver);
		act.moveToElement(mouse).perform();
		Thread.sleep(1000);
		kids.click();
		driver.navigate().back();
		String url=driver.getCurrentUrl();
		if(url.contains("kids")) {
			System.out.println("mouseover the item ");
		}else {
			System.out.println("mouseover is not selected the item");
		}
    }
//------------------------DROP DOWN--------------------------------
    public void field() {
        mensclick.click();
        Select sc = new Select(sortby);
        sc.selectByVisibleText("Newest");

        String selectedValue = sc.getFirstSelectedOption().getText();
        if (selectedValue.equals("Newest")) {
            System.out.println("text is selected");
        } else {
            System.out.println("text is not selected");
        }
        driver.navigate().back();
    }
    //-------------URL VERIFICATION----------------------------------

    public void Urlverification() {
        String actualUrl = driver.getCurrentUrl();
        String expected = "";
        if(actualUrl.contains(expected)) {
        	
        	System.out.println("url verified");
        	
        }else {
        	System.out.println("url not verified");
        }
       
    }
 
   
    	
    
//----------------RESPONSE CODE------------------------
    public void responseCode() throws Throwable, IOException {
        String baseURL = "https://global.llbean.com/";
        URI ob = new URI(baseURL);
        HttpURLConnection con = (HttpURLConnection) ob.toURL().openConnection();

        int responseCode = con.getResponseCode();
        System.out.println("Response Code: " + responseCode);

        if (responseCode == 200) {
            System.out.println("URL is working properly");
        } else {
            System.out.println("URL is NOT working, returned code: " + responseCode);
        }
    }

//----------------TITLE VERIFICATION---------------------
    public void titleverification() {
        String expectttile="L.L.Bean international";
        String title=driver.getTitle();
        if(expectttile.equals(title)) {
            System.out.println("title verified pass");
        } else {
            System.out.println("title verified failed");
        }
    }
//---------------LOGO VERIFICATION----------------------
    public void logoVerification() {
        if(logo.isDisplayed()) {
            System.out.println("logo is present");
        } else {
            System.out.println("logo is not present");
        }
    }
    

    public void end() {
        driver.quit();
    }
}
