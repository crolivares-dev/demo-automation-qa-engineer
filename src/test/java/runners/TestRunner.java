package runners;

import org.junit.platform.suite.api.ConfigurationParameter;
import org.junit.platform.suite.api.IncludeEngines;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@IncludeEngines("cucumber")
@SelectClasspathResource("features")
@ConfigurationParameter(key = io.cucumber.core.options.Constants.GLUE_PROPERTY_NAME, value = "steps")
// Cambiamos el plugin por el adaptador de Extent Reports:
@ConfigurationParameter(key = io.cucumber.core.options.Constants.PLUGIN_PROPERTY_NAME,
        value = "pretty, com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:")
public class TestRunner {
}