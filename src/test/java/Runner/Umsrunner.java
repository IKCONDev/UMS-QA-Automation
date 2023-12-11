package Runner;


import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
features = {"Feature\\ums.feature"},
glue = {"Stepdef"},
dryRun = false,
plugin = {"pretty","html:target/cucu-report.html","json:target/cuc"}
//,"com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"}
//"org.simplestudio.cucumber.XlsFormatter"}
,monochrome = true
		,publish = true)

public class Umsrunner extends AbstractTestNGCucumberTests {
//	@SuppressWarnings("deprecation")
//	public static void main(String[] args) throws Throwable {
//        String[] arguments = {"-p", "html:C:\\Users\\VenkateshUdaru\\eclip\\UMSAPP\\target\\cuc-rep.html",
//        		"-g","Stepdef",
//        		"Feature\\ums.feature"};
//        cucumber.api.cli.Main.main(arguments);
//    }
	
}


//    public static void main(String[] args) throws Throwable 
//    {
//        Main.main(new String[]{"-g", "C:/work/workspaces/neon2_wks_new1/Cuketest4/src/com/cuke"
//, "C:/work/workspaces/neon2_wks_new1/Cuketest4/src/com/cuke/cukefeature.feature"});
//    }


