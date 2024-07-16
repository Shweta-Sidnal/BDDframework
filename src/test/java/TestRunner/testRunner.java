package TestRunner;

import io.cucumber.testng.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class testRunner {
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
glue = "StepDefinitions")
class login extends AbstractTestNGCucumberTests{

}
