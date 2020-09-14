package br.com.inmetrics.teste.steps;

import br.com.inmetrics.teste.page.LoginPage;
import br.com.inmetrics.teste.runner.Driver;
import br.com.inmetrics.teste.support.InmetricsUtil;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CadastrarUsuarioSteps extends Driver {

    WebDriver driver = getDriver();
    String usuarioGerado;
    String senhaGerada;

    LoginPage loginPage = new LoginPage(driver);

    @Dado("que estou na tela de cadastro de usuário do sistema inmetrics")
    public void que_estou_na_tela_de_cadastro_de_usuário_do_sistema_inmetrics() {
        driver.get("http://www.inmrobo.tk/accounts/login/");

        loginPage.clicarLinkCadastreSe();
    }

    @Quando("gerar nome de usuário")
    public void gerar_nome_de_usuário() {
        usuarioGerado = "inmetricsUser"+ InmetricsUtil.dataAtualSemFormato();
        loginPage.escreverNomeUsuario(usuarioGerado);
    }

    @Quando("gerar senha do usuário")
    public void gerar_senha_do_usuário() {
        senhaGerada = "inmetricsPass"+InmetricsUtil.dataAtualSemFormato();
        loginPage.escreverSenhaUsuario(senhaGerada);
    }

    @Quando("cadastrar usuário com confirmação de senha {string}")
    public void cadastrar_usuário_com_confirmação_de_senha(String confirmSenha) {
        loginPage.escreverConfirmacaoSenha(confirmSenha);
        loginPage.clicarEntreCadastrar();
    }

    @Quando("cadastrar usuário com confirmação de senha gerada")
    public void cadastrar_usuário_com_confirmação_de_senha_gerada() {
        loginPage.escreverConfirmacaoSenha(senhaGerada);
        loginPage.clicarEntreCadastrar();
    }

    @Quando("efetuar login com credenciais geradas")
    public void efetuar_login_com_credenciais_geradas() {
        loginPage.escreverNomeUsuario(usuarioGerado);
        loginPage.escreverSenhaUsuario(senhaGerada);
        loginPage.clicarEntreCadastrar();
    }

    @Então("o sistema informa mensagem de erro de cadastro {string}")
    public void o_sistema_informa_mensagem_de_erro_de_cadastro(String mensagemErro) {
        Assert.assertTrue(loginPage.mensagemErroCadastroUsuario(mensagemErro, driver));
    }

}
