package br.com.inmetrics.teste.page.funcionarios;

import br.com.inmetrics.teste.support.InmetricsUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CadastrarFuncionarioPage {

    @FindBy(how = How.ID, using = "inputNome")
    private WebElement lblNomeFuncionario;

    @FindBy(how = How.ID, using = "cpf")
    private WebElement lblCpf;

    @FindBy(how = How.ID, using = "slctSexo")
    private WebElement cboSexo;

    @FindBy(how = How.ID, using = "inputAdmissao")
    private WebElement lblAdmissao;

    @FindBy(how = How.ID, using = "inputCargo")
    private WebElement lblCargo;

    @FindBy(how = How.ID, using = "dinheiro")
    private WebElement lblSalario;

    @FindBy(how = How.ID, using = "clt")
    private WebElement rdiContratacaoClt;

    @FindBy(how = How.ID, using = "pj")
    private WebElement rdiContratacaoPj;

    @FindBy(how = How.CLASS_NAME, using = "cadastrar-form-btn")
    private WebElement btnEnviar;

    public CadastrarFuncionarioPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void escreverNome(String nome){
        lblNomeFuncionario.sendKeys(nome);
    }

    public void escreverCpf(String cpf, WebDriver driver) {
        lblCpf.click();
        lblCpf.sendKeys(cpf);
        lblCpf.sendKeys(Keys.TAB);
        while (InmetricsUtil.isAlertPresent(driver)){
            if (driver.switchTo().alert().getText().contains("CPF Invalido!")){
                driver.switchTo().alert().accept();
                lblCpf.sendKeys(InmetricsUtil.geraCPF());
                lblCpf.sendKeys(Keys.TAB);
            }
        }
    }

    public void escreverCpf(String cpf) {
        lblCpf.click();
        lblCpf.sendKeys(cpf);
    }

    public void selecionarSexo(String sexo, WebDriver driver){
        Select drpSexo = new Select(driver.findElement(By.id("slctSexo")));
        drpSexo.selectByVisibleText(sexo);
    }

    public void escreverDataAdmissao(String dataAdmisao){
        lblAdmissao.click();
        lblAdmissao.sendKeys(InmetricsUtil.dataAtual("dd/MM/yyyy"));
    }

    public void limparCargo(){
        lblCargo.clear();
    }

    public void escreverCargo(String cargo){
        lblCargo.sendKeys(cargo);
    }

    public void escreverSalario(String salario){
        lblSalario.click();
        lblSalario.sendKeys(salario);
    }

    public void selecionarTipoContratacao(String tipoContratacao){
        if (tipoContratacao.equals("CLT")){
            rdiContratacaoClt.click();
        }else if (tipoContratacao.equals("PJ")){
            rdiContratacaoPj.click();
        }
    }

    public void clicarBotaoEnviar(){
        btnEnviar.click();
    }

}
