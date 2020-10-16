package org.openqa.selenium.example;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;



public class Selenium2Example  {
    public static void main(String[] args) {
        // Create a new instance of the Firefox driver
        // Notice that the remainder of the code relies on the interface,
        // not the implementation.
    	
    	StringBuilder sb=new StringBuilder();
    	DesiredCapabilities caps = new DesiredCapabilities();
    	caps.setJavascriptEnabled(true);                
    	caps.setCapability("takesScreenshot", true);  
    	caps.setCapability(
    	                        PhantomJSDriverService. "C:\\Phantom\\phantomjs.exe");
    	
       // WebDriver driver = new PhantomJSDriver(caps);//revisar ya que es navegador oculto sirve de mucho
        
        System.setProperty("webdriver.chrome.driver", "C:\\ChromeDrive\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        // And now use this to visit Google
        //driver.get("https://www.compraspublicas.gob.ec/ProcesoContratacion/compras/IV/ReporteInvitaciones.cpe?solicitud=kDIV1q7TCdRtP5ZvmB63JbxnEhM5MnjBW7feC8dqM2I,");
        //driver.get("https://www.compraspublicas.gob.ec/ProcesoContratacion/compras/PC/informacionProcesoContratacion2.cpe?idSoliCompra=NJseHH4MkGXDeJsCv3vHurGWc7Vq2MSLw7Bu5mvzrsM,");
        //driver.get("https://www.compraspublicas.gob.ec/ProcesoContratacion/compras/PC/informacionProcesoContratacion2.cpe?idSoliCompra=AWbe5oXwnXr09LEzMFpP_TVTt_t6A0aTwsDFLWLlJfY,");
        //driver.get("https://www.compraspublicas.gob.ec/ProcesoContratacion/compras/IV/ReporteInvitaciones.cpe?solicitud=UVW_T3pKYwdr_gOsbyGpn3vaPZi8fJiIqruuoEt7lkM,");
        //driver.get("https://www.compraspublicas.gob.ec/ProcesoContratacion/compras/IV/ReporteInvitaciones.cpe?solicitud=t2x2Rfx8kMCh7XzeD5ove6TV4zONH3Y31UqCh7CyS-A,");
        driver.get("https://www.compraspublicas.gob.ec/ProcesoContratacion/compras/IV/ReporteInvitaciones.cpe?solicitud=7IEEudMO5Ec3hDhBLtFr70PTA4udu0ApzaigigrbkMA,");
        // Alternatively the same thing can be done like this
        // driver.navigate().to("http://www.google.com");
        //modificando javascript 
        
        try {
			Thread.sleep(40000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        
        int u=1285;
        for(int y=0;y<u;y++)
        {
        	
        	WebElement mytable = driver.findElement(By.xpath("//*[@id=\"formPaginas\"]/table"));
        	//To locate rows of table. 
        	List < WebElement > rows_table = mytable.findElements(By.tagName("tr"));
        	//To calculate no of rows In table.
        	int rows_count = rows_table.size();
        	//Loop will execute till the last row of table.
        	for (int row = 0; row < rows_count; row++) {
        	    //To locate columns(cells) of that specific row.
        	    List < WebElement > Columns_row = rows_table.get(row).findElements(By.tagName("td"));
        	    //To calculate no of columns (cells). In that specific row.
        	    int columns_count = Columns_row.size();
        	    System.out.println("Number of cells In Row " + row + " are " + columns_count);
        	    
        	    sb.append("Number of cells In Row " + row + " are " + columns_count+"\n");
        	    
        	    //Loop will execute till the last cell of that specific row.
        	    for (int column = 0; column < columns_count; column++) {
        	        // To retrieve text from that specific cell.
        	        String celtext = Columns_row.get(column).getText();
        	        System.out.println("Cell Value of row number " + row + " and column number " + column + " Is " + celtext);
        	        sb.append("Cell Value of row number " + row + " and column number " + column + " Is " + celtext+"\n");
        	    }
        	    System.out.println("-------------------------------------------------- ");
        	    sb.append("-------------------------------------------------- \n");
        	
        	}
        	    
        	    
        	    try {

				Thread.sleep(1000);
				try
				{
				driver.findElement(By.linkText("Siguiente")).click();
				}
				catch(Exception e)
				{
					Writer writer = null;
					try {
			            writer = new BufferedWriter(new OutputStreamWriter(
			                  new FileOutputStream("C:\\Hack\\31032019\\ReporteHackException.txt"), "utf-8"));
			            writer.write(sb.toString());
			        } catch (IOException ex) {
			            // Report
			        } finally {
			           try {writer.close();} catch (Exception ex) {/*ignore*/}
			        }
					System.out.println("EN ERROR");
					
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	
        }
        
        Writer writer = null;

        try {
            writer = new BufferedWriter(new OutputStreamWriter(
                  new FileOutputStream("C:\\Hack\\31032019\\ReporteHack.txt"), "utf-8"));
            writer.write(sb.toString());
        } catch (IOException ex) {
            // Report
        } finally {
           try {writer.close();} catch (Exception ex) {/*ignore*/}
        }
        
        

        /*// Find the text input element by its name
        WebElement element = driver.findElement(By.name("q"));

        // Enter something to search for
        element.sendKeys("Cheese!");

        // Now submit the form. WebDriver will find the form for us from the element
        element.submit();

        // Check the title of the page
        System.out.println("Page title is: " + driver.getTitle());

        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        (new WebDriverWait(driver, 10)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith("cheese!");
            }
        });

        // Should see: "cheese! - Google Search"
        System.out.println("Page title is: " + driver.getTitle());*/

        //Close the browser
        //driver.quit();
    }
    
}
