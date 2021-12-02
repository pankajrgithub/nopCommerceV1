package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions
              (
            		 
            		  features= ".//Features/Customer.feature",
            		  glue="stepDefiniations",
            		  dryRun=false,
            		  monochrome=true, //unnecessary contain will be remove from console 
            		  plugin= {"pretty",
            				  "html:test-output.html"
            				  }
           		//  tags= {"@regression"}  //to run separate test cases as per tag
		        )





public class TestRun {

}
