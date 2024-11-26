package fitpeo1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class fitpeoo {

static WebDriver driver;
	
	public static void main(String[] args) throws Throwable {
		driver=new ChromeDriver();
		driver.get("https://www.fitpeo.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        
        
        driver.findElement(By.linkText("Revenue Calculator")).click();
        
        //Thread.sleep(1000);
        //JavascriptExecutor js=(JavascriptExecutor)driver;
		
        //js.executeScript("arguments[0].scrollIntoView()",driver.findElement(By.xpath("//h4[normalize-space()='Medicare Eligible Patients']")));
        //js.executeScript("window.scrollBy(0,1000)");
		
		//driver.findElement(By.xpath("//input[@aria-valuenow='820']")).sendKeys("820");

      

      //Scroll Down to the Slider section

      JavascriptExecutor js = (JavascriptExecutor)driver;

      Thread.sleep(5000);

      js.executeScript("window.scrollBy(0,300)");

      WebElement slider = driver.findElement(By.xpath("//span[contains(@data-index,'0')]"));

      //Adjust the Slider

      Actions move = new Actions(driver);

      move.dragAndDropBy(slider, 93, 0).perform(); //820

      Thread.sleep(5000);

      move.sendKeys(Keys.ARROW_RIGHT).perform();

      move.sendKeys(Keys.ARROW_RIGHT).perform();

      move.sendKeys(Keys.ARROW_RIGHT).perform();

      move.sendKeys(Keys.ARROW_RIGHT).perform();

      move.sendKeys(Keys.ENTER).perform();
      
//      JavascriptExecutor j=(JavascriptExecutor)driver;
//      j.executeScript("window.scrollBy(0,450)","");
//    Actions ac = new Actions(driver);
//    Thread.sleep(3000);
//    WebElement ele = driver.findElement(By.xpath("//span[contains(@class,'MuiSlider-thumb')]"));
//    ac.dragAndDropBy(ele, 94, 0).perform();
//    Thread.sleep(2000);
//    ac.sendKeys(Keys.ARROW_DOWN,Keys.ARROW_DOWN,Keys.ARROW_DOWN).perform();
//    Thread.sleep(2000);
      
    WebElement li = driver.findElement(By.xpath("//span[@class='MuiSlider-track css-10opxo5']"));
    js.executeScript("arguments[0].style.backgroundColor='red';", li );
   WebElement cl= driver.findElement(By.xpath("//span[contains(@class,'MuiSlider-thumb')]"));
    js.executeScript("arguments[0].style.backgroundColor='red';",cl);


      Thread.sleep(5000);

      driver.findElement(By.xpath("//input[@type='number']")).clear();

      Thread.sleep(5000);

      //Update the Text Field

      js.executeScript("document.querySelector(\"input[id=':r0:']\").value='560'");

      Thread.sleep(2000);

      String Expectedtext ="560";

      String Actualtext = driver.findElement(By.xpath("//input[@type='number']")).getAttribute("value");

      Thread.sleep(2000);

      //Validate Slider Value

      if(Expectedtext.equalsIgnoreCase(Actualtext))

      {

      System.out.println(Expectedtext+" "+Actualtext+" "+"value matching");

      }
      else {

    	  System.out.println(Expectedtext+" "+Actualtext+" "+"value is not matching");

    	  }

    	  Thread.sleep(2000);

    	  //Select CPT Codes

    	  driver.findElement(By.xpath("(//input[@type='checkbox'])[1]")).click();

    	  Thread.sleep(1000);

    	  driver.findElement(By.xpath("(//input[@type='checkbox'])[2]")).click();

    	  Thread.sleep(1000);

    	  driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).click();

    	  Thread.sleep(1000);

    	  driver.findElement(By.xpath("(//input[@type='checkbox'])[8]")).click();

    	  Thread.sleep(1000);

    	  //Validate Total Recurring Reimbursement

    	  String Expected = "110700";

String Actual = driver.findElement(By.xpath("(//p[position()=1])[5]")).getText();

System.out.println(Actual);

//Verify that the header displaying

if(Expectedtext.equalsIgnoreCase(Actualtext))

{

System.out.println(Expected+" "+Actual+" "+"value matching");

}

else {

System.out.println(Expected+" "+Actual+" "+"value is not matching");

}

Thread.sleep(2000);

driver.quit();


		
		

	}

}
