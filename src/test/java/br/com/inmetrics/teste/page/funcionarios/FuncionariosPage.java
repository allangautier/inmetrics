package br.com.inmetrics.teste.page.funcionarios;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FuncionariosPage {

    @FindBy(how = How.XPATH, using = "//div/strong[contains(text(), ' SUCESSO! ')]/..")
    private WebElement txtMensagemSucesso;

    @FindBy(how = How.XPATH, using = "//input[@type='search']")
    private WebElement lblPesquisar;

    @FindBy(how = How.XPATH, using = "//button/span[@class='fa fa-pencil']")
    private WebElement btnEditar;

    @FindBy(how = How.ID, using = "delete-btn")
    private WebElement btnDelete;

    public FuncionariosPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public String mensagemCadastroSucesso(){
        return txtMensagemSucesso.getText();
    }

    public boolean visibilidadeNomeListaFuncionarios(String funcionario, WebDriver driver){
        return driver.findElement(By.xpath("//td[contains(text(), '"+funcionario+"')]")).isDisplayed();
    }

    public boolean visibilidadeInformacaoLista(String mensagem, WebDriver driver){
        return driver.findElement(By.xpath("//td[contains(text(), '"+mensagem+"')]")).isDisplayed();
    }

    public void escreverNomePesquisa(String nomePesquisa){
        lblPesquisar.sendKeys(nomePesquisa);
    }

    public void clicarEditar(){
        btnEditar.click();
    }

    public void clicarDelete(){
        btnDelete.click();
    }

    public boolean visibilidadeCargoPacienteCadastrado(WebDriver driver, String funcionario, String cargo){
        return driver.findElement(By.xpath("//tr/td[contains(text(), '"+funcionario+"')]/../td[contains(text(), '"+cargo+"')]")).isDisplayed();
    }

}
