import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;


public class Login {

    WebDriver wd;
    @BeforeMethod
    public void preCondition(){
        // open browser
        wd = new ChromeDriver();
        // open site
        wd.get("https://telranedu.web.app");
    }

    @Test
    public void findElementsOnPage() {
        // by tagName
        WebElement element = wd.findElement(By.tagName("div"));
        List<WebElement> divs = wd.findElements(By.tagName("div"));

        // By id
        WebElement el1 = wd.findElement(By.id("root"));
        // By class
        WebElement el2 = wd.findElement(By.className("container"));
        // By name
        //wd.findElement(By.name("name"));

        // By link text a href
        wd.findElement(By.linkText("HOME"));
        wd.findElement(By.linkText("ABOUT"));
        wd.findElement(By.partialLinkText("HO"));

    }

    @Test
    public void loginSuccess(){
        // open form
        // wd find item + click

        WebElement itemLogin = wd.findElement(By.linkText("LOGIN"));
        itemLogin.click();

        // fill form
        // find email + click + clear + type
        WebElement email = wd.findElement(By.name("email"));
        email.click();
        email.clear();
        email.sendKeys("michael87b@gmail.com");

        // find password + click +clear + type
        WebElement password = wd.findElement(By.name("password"));
        password.click();
        password.clear();
        password.sendKeys("Michael123!$");

        // submit  form
        // find button login + click
        List<WebElement> buttons = wd.findElements(By.tagName("button"));
        WebElement buttonLogin = buttons.get(0);
        buttonLogin.click();

        Assert.assertEquals("","");
        // ac ==exp
    }

    @Test
    public void registrationSuccess(){
        WebElement login = wd.findElement(By.linkText("LOGIN"));
        login.click();

        WebElement email = wd.findElement(By.name("email"));
        email.click();
        email.clear();
        email.sendKeys("michael87b+2@gmail.com");

        WebElement password = wd.findElement(By.name("password"));
        password.click();
        password.clear();
        password.sendKeys("Michael123!$");

        List<WebElement> buttons1 = wd.findElements(By.tagName("button"));
        WebElement buttonReg = buttons1.get(1);
        buttonReg.click();



    }
    @Test
    public void ccslocatrstest(){

        // нужно перейти на страницу логина, так как на главной странице мало элементов для поиска и тренировки
        // переход на страницу логина тут:
        wd.findElement(By.linkText("LOGIN")).click();

        // теперь мы на странице логина и тут будем тренироваться

        // На странице логин найти несколько элементов по их  tagname
        wd.findElement(By.tagName("div"));

        wd.findElement(By.cssSelector("div"));
        wd.findElement(By.cssSelector("input"));
        wd.findElement(By.cssSelector("button"));


        // ON Login PAGE find some elements by class
        wd.findElement(By.cssSelector(".container"));
        wd.findElement(By.cssSelector(".navbar-component_nav__1X_4m"));
        wd.findElement(By.cssSelector(".login_login__3EHKB"));


        // На странице логин найти несколько элементов по их  attribute
        wd.findElement(By.cssSelector("[type='submit']"));
        wd.findElement(By.cssSelector("[placeholder='Password']"));
        wd.findElement(By.cssSelector("[name='email']"));
        wd.findElement(By.cssSelector("[href='/home']"));

        //На странице логин найти  элемент с  атрибутом placeholder, значение которого начинается на "Pass"
        wd.findElement(By.cssSelector("[placeholder ^='Pass']"));
        //На странице логин найти  элемент с  атрибутом placeholder, значение которого  начинается на  "ass"
        wd.findElement(By.cssSelector("[placeholder *='ass']"));   //maybe You mean 'contains'?
        //На странице логин найти  элемент с  атрибутом placeholder, значение которого заканчивается на "ord"
        wd.findElement(By.cssSelector("[placeholder $='ord']"));



        // Объединение !!
        //найти элемент div, у которого есть id со значением "root"  и класс со значением container
        wd.findElement(By.cssSelector("div#root.container"));
        wd.findElement(By.cssSelector("div[id='root'][class='container']"));

        // найти элемент а, у которого есть атрибут href со значением /login
        wd.findElement(By.cssSelector("a[href='/login']"));
        // найти элемент input, у которого есть атрибут name cо значением email
        wd.findElement(By.cssSelector("input[name='email']"));
        // найти элемент button, у которого есть атрибут name cо значением login
        wd.findElement(By.cssSelector("button[name='login']"));

        // Поиск по дочерним элементам (* задание со звездоской)
        // Найти кнопку регистрации, как последнего ребенка элемента form
        wd.findElement(By.cssSelector("form:last-child"));

    }
    @AfterMethod
    public void postCondition(){
        // close browser
        // wd.quit();
    }
}