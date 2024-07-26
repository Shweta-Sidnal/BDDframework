package TestRunner;

import io.cucumber.testng.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestRunner {
    TestNGCucumberRunner testNGcucumberRunner;

    @Test(dataProvider ="login")
    public void testlogin(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper){
        testNGcucumberRunner.runScenario(pickleWrapper.getPickle());

    }
    @DataProvider
    public Object[][] login(){
        testNGcucumberRunner = new TestNGCucumberRunner(login.class);
        return testNGcucumberRunner.provideScenarios();

    }
}

@CucumberOptions(features = "src/test/FeatureFiles/login.feature",
glue = "StepDefinitions",
        plugin = {"pretty", "html:target/cucumber-html-reports", "io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm",
        })
class login extends AbstractTestNGCucumberTests{

}
