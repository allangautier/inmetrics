package br.com.inmetrics.teste.steps;

import br.com.inmetrics.teste.page.MenuPage;
import br.com.inmetrics.teste.runner.Driver;
import io.cucumber.java.pt.Dado;
import org.openqa.selenium.WebDriver;

public class MenuSteps extends Driver {

    WebDriver driver = getDriver();

    MenuPage menuPage = new MenuPage(driver);

    @Dado("acessar a tela {string}")
    public void acessar_a_tela(String menu) {
        menuPage.clicarLinksMenu(driver, menu);
    }

}
