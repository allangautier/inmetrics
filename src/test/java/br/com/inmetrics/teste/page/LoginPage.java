package br.com.inmetrics.teste.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(how = How.NAME, using = "username")
    private WebElement lblUserName;

    @FindBy(how = How.NAME, using = "pass")
    private WebElement lblPass;

    @FindBy(how = How.NAME, using = "confirmpass")
    private WebElement lblConfirmPass;

    @FindBy(how = How.CLASS_NAME, using = "login100-form-btn")
    private WebElement btnEntreCadastrar;

    @FindBy(how = How.XPATH, using = "//div/strong[contains(text(), ' ERRO! ')]/..")
    private WebElement lblErroLogin;

    @FindBy(how = How.LINK_TEXT, using = "Cadastre-se")
    private WebElement lnkCadastreSe;

    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void escreverNomeUsuario(String usuario){
        lblUserName.sendKeys(usuario);
    }

    public void escreverSenhaUsuario(String senha){
        lblPass.sendKeys(senha);
    }

    public void escreverConfirmacaoSenha(String confSenha){
        lblConfirmPass.sendKeys(confSenha);
    }

    public void clicarEntreCadastrar(){
        btnEntreCadastrar.click();
    }

    public String textoErroLogin(){
        return lblErroLogin.getText();
    }

    public void clicarLinkCadastreSe(){
        lnkCadastreSe.click();
    }

    public boolean mensagemErroCadastroUsuario(String mensagemErro, WebDriver driver){
        return driver.findElement(By.xpath("//div[contains(text(), '"+mensagemErro+"')]")).isDisplayed();
    }

}
