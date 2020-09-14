package br.com.inmetrics.teste.steps;

import br.com.inmetrics.teste.page.MenuPage;
import br.com.inmetrics.teste.page.funcionarios.FuncionariosPage;
import br.com.inmetrics.teste.page.LoginPage;
import br.com.inmetrics.teste.runner.Driver;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class LoginSteps extends Driver {

    WebDriver driver = getDriver();

    LoginPage loginPage = new LoginPage(driver);
    MenuPage menuPage = new MenuPage(driver);

    @Dado("que acesso o sistema inmetrics")
    public void que_acesso_o_sistema_inmetrics() {
        driver.get("http://www.inmrobo.tk/accounts/login/");
    }

    @Quando("inserir usuário {string}")
    public void inserir_usuário(String usuario) {
        loginPage.escreverNomeUsuario(usuario);
    }

    @Quando("inserir senha {string}")
    public void inserir_senha(String senha) {
        loginPage.escreverSenhaUsuario(senha);
    }

    @Quando("realizar login")
    public void realizar_login() {
        loginPage.clicarEntreCadastrar();
    }

    @Então("efetua login com sucesso")
    public void efetua_login_com_sucesso() {
        Assert.assertTrue(menuPage.visibilidadeLinkSair());
    }

    @Então("o sistema apresenta a mensagem de erro {string}")
    public void o_sistema_apresenta_a_mensagem_de_erro(String erroLogin) {
        Assert.assertTrue(loginPage.textoErroLogin().contains(erroLogin));
    }

    @Dado("que estou logado no sistema inmetrics")
    public void que_estou_logado_no_sistema_inmetrics(DataTable dataTable) {
        que_acesso_o_sistema_inmetrics();
        loginPage.escreverNomeUsuario(dataTable.cell(1, 0));
        loginPage.escreverSenhaUsuario(dataTable.cell(1, 1));
        loginPage.clicarEntreCadastrar();
    }

}
