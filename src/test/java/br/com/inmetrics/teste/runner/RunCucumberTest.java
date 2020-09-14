package br.com.inmetrics.teste.runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"src/test/resources/features"}, glue = {"br.com.inmetrics.teste.steps"})
public class RunCucumberTest {

}