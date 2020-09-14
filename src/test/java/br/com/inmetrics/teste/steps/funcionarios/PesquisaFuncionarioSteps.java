package br.com.inmetrics.teste.steps.funcionarios;

import br.com.inmetrics.teste.page.funcionarios.CadastrarFuncionarioPage;
import br.com.inmetrics.teste.page.funcionarios.FuncionariosPage;
import br.com.inmetrics.teste.runner.Driver;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class PesquisaFuncionarioSteps extends Driver {

    WebDriver driver = getDriver();

    FuncionariosPage funcionariosPage = new FuncionariosPage(driver);
    CadastrarFuncionarioPage cadastrarFuncionarioPage = new CadastrarFuncionarioPage(driver);

    @Então("o funcionário é cadastrado com sucesso")
    public void o_funcionário_é_cadastrado_com_sucesso(){
        Assert.assertTrue(funcionariosPage.mensagemCadastroSucesso().contains("SUCESSO! Usuário cadastrado com sucesso"));
    }

    @Então("o cadastro é atualizado com sucesso")
    public void o_cadastro_é_atualizado_com_sucesso(){
        Assert.assertTrue(funcionariosPage.mensagemCadastroSucesso().contains("SUCESSO! Informações atualizadas com sucesso"));
    }

    @Então("o funcionário será removido da lista com sucesso")
    public void o_funcionário_será_removido_da_lista_com_sucesso(){
        Assert.assertTrue(funcionariosPage.mensagemCadastroSucesso().contains("SUCESSO! Funcionário removido com sucesso"));
    }

    @Então("o funcionário entra na lista de funcionários do sistema")
    public void o_funcionário_entra_na_lista_de_funcionários_do_sistema() throws InterruptedException {
        Assert.assertTrue(funcionariosPage.visibilidadeNomeListaFuncionarios(CadastrarFuncionarioSteps.nomeFuncionario, driver));
    }

    @Quando("pesquisar por funcionário cadastrado")
    public void pesquisar_por_funcionário_cadastrado() {
        funcionariosPage.escreverNomePesquisa(CadastrarFuncionarioSteps.nomeFuncionario);
    }

    @Quando("abrir cadastro do funcionário")
    public void abrir_cadastro_do_funcionário() {
        funcionariosPage.clicarEditar();
    }

    @Quando("excluir o funcionário")
    public void excluir_o_funcionário() {
        funcionariosPage.clicarDelete();
    }

    @Quando("alterar cargo do funcionário para {string}")
    public void alterar_cargo_do_funcionário_para(String cargo) {
        cadastrarFuncionarioPage.limparCargo();
        cadastrarFuncionarioPage.escreverCargo(cargo);
    }

    @Então("o funcionário aparece na lista de funcionários")
    public void o_funcionário_aparece_na_lista_de_funcionários() {
        Assert.assertTrue(funcionariosPage.visibilidadeNomeListaFuncionarios(CadastrarFuncionarioSteps.nomeFuncionario, driver));
    }

    @Então("o sistema informa na lista {string}")
    public void o_sistema_informa_na_lista(String mensagem) {
        Assert.assertTrue(funcionariosPage.visibilidadeInformacaoLista(mensagem, driver));
    }

    @Então("o cargo do funcionário mostra na lista como {string}")
    public void o_cargo_do_funcionário_mostra_na_lista_como(String cargo) {
        Assert.assertTrue(funcionariosPage.visibilidadeCargoPacienteCadastrado(driver, CadastrarFuncionarioSteps.nomeFuncionario, cargo));
    }

}
