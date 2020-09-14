package br.com.inmetrics.teste.steps.funcionarios;

import br.com.inmetrics.teste.page.funcionarios.CadastrarFuncionarioPage;
import br.com.inmetrics.teste.runner.Driver;
import br.com.inmetrics.teste.support.InmetricsUtil;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class CadastrarFuncionarioSteps extends Driver {

    WebDriver driver = getDriver();
    static String nomeFuncionario;

    CadastrarFuncionarioPage cadastrarFuncionarioPage = new CadastrarFuncionarioPage(driver);

    @Quando("incluir as informações de cadastro")
    public void incluir_as_informações_de_cadastro(DataTable dataTable) throws InterruptedException {
        if (dataTable.cell(1, 0).equals("automatico")) {
            nomeFuncionario = "Allan Amorim "+ InmetricsUtil.dataAtualSemFormato();
            cadastrarFuncionarioPage.escreverNome(nomeFuncionario);
        }else {
            cadastrarFuncionarioPage.escreverNome(dataTable.cell(1, 0));
        }

        if (dataTable.cell(1, 1).equals("automatico")) {
            cadastrarFuncionarioPage.escreverCpf(InmetricsUtil.geraCPF(), driver);
        }else {
            cadastrarFuncionarioPage.escreverCpf(dataTable.cell(1, 1));
        }

        cadastrarFuncionarioPage.selecionarSexo(dataTable.cell(1, 2), driver);

        if (dataTable.cell(1, 3).equals("dataAtual")) {
            cadastrarFuncionarioPage.escreverDataAdmissao(InmetricsUtil.dataAtual("dd/MM/yyyy"));
        }else {
            cadastrarFuncionarioPage.escreverDataAdmissao(dataTable.cell(1, 3));
        }

        cadastrarFuncionarioPage.escreverCargo(dataTable.cell(1, 4));
        cadastrarFuncionarioPage.escreverSalario(dataTable.cell(1, 5));
        cadastrarFuncionarioPage.selecionarTipoContratacao(dataTable.cell(1, 6));
    }

    @Quando("enviar formulário de cadastro de funcionário")
    public void enviar_formulário_de_cadastro_de_funcionário() {
        cadastrarFuncionarioPage.clicarBotaoEnviar();
    }

    @Quando("inserir cpf {string}")
    public void inserir_cpf(String cpf){
        cadastrarFuncionarioPage.escreverCpf(cpf);
        cadastrarFuncionarioPage.clicarBotaoEnviar();
    }

    @Então("o sistema apresenta alerta de erro {string}")
    public void o_sistema_apresenta_alerta_de_erro(String alerta){
        Assert.assertTrue(driver.switchTo().alert().getText().contains(alerta));
    }

}
