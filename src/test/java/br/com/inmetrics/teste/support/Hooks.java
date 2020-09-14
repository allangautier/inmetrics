package br.com.inmetrics.teste.support;

import br.com.inmetrics.teste.runner.Driver;
import io.cucumber.java.After;

public class Hooks extends Driver {

    @After
    public void afterScenario(){
        driver.quit();
    }

}