import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;

public class Index {
    WebDriver wd;

    @BeforeMethod
    public void start(){
        wd = new ChromeDriver();
        wd.get("file:///C:/Users/Michael%20Blitshtein/Downloads/index.html");
        wd.manage().window().maximize();


    }



    @Test
    public void itemsTests(){
        // find Item1 & click() ===> assert that "div-alert" contains message  "Clicked by Item 1"
       WebElement item1 =  wd.findElement(By.cssSelector("[href='#item1']"));
       item1.click();
       WebElement divAlert = wd.findElement(By.cssSelector("#alert"));
       String text = divAlert.getText();
       Assert.assertTrue(text.contains("Clicked by Item 1"));

        // find Item3 & click() ===> assert that "div-alert" contains message  "Clicked by Item 3"
        WebElement item3 = wd.findElement(By.cssSelector("[href='#item3']"));
        item3.click();
        text = divAlert.getText();
        Assert.assertTrue(text.contains("Clicked by Item 3"));
    }

    @Test
    public void formTests(){
        // fill name & fill surename & click send
        WebElement name = wd.findElement(By.cssSelector("[name='name']"));
        name.click();
        name.clear();
        name.sendKeys("John");

        WebElement surename = wd.findElement(By.cssSelector("[name='surename']"));
        surename.click();
        surename.clear();
        surename.sendKeys("Hopkins");


        WebElement sendButton = wd.findElement(By.cssSelector(".btn"));
        sendButton.click();

        // Assert that "div-alert" contains text with name + surename
        WebElement divAlert = wd.findElement(By.cssSelector("#alert"));
        String text1 = divAlert.getText();
        Assert.assertTrue(text1.contains(name.getText()+surename.getText()));

    }



    @Test
    public void tableTest(){
         //проверь правда ли в таблице 4 строки

        List<WebElement> rows = wd.findElements(By.cssSelector("tr"));
        Assert.assertEquals(rows.size(),4);

        //правда ли, что последняя строка содержит Mexico

        WebElement lastRow = wd.findElement(By.cssSelector("tr:last-child"));
        String text = lastRow.getText();
        System.out.println(text);   //"Poland Chine Mexico"
        Assert.assertTrue(text.contains("Mexico"));

        //правда ли, что последняя ячейка содержит Mexico
        WebElement lastCell = wd.findElement(By.cssSelector("tr:last-child td:last-child"));
        String str = lastCell.getText();
        Assert.assertTrue(str.contains("Mexico"));

    }

}
