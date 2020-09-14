package br.com.inmetrics.teste.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class MenuPage {

    @FindBy(how = How.XPATH, using = "//a[contains(text(), 'Sair')]")
    private WebElement lnkSair;

    public boolean visibilidadeLinkSair(){
        return lnkSair.isDisplayed();
    }

    public void clicarSair(){
        lnkSair.click();
    }

    public MenuPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void clicarLinksMenu(WebDriver driver, String menu){
        driver.findElement(By.xpath("//a[contains(text(), '"+menu+"')]")).click();
    }

}
