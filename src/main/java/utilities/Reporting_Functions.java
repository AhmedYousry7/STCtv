package utilities;

import org.aspectj.util.FileUtil;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.compress.compressors.FileNameUtil;
import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Reporting_Functions {
    public ExtentSparkReporter createTestCaseReport(String reportFileName, String title, String name){
        ExtentSparkReporter spark = new ExtentSparkReporter(reportFileName);
        spark.config().setTheme(Theme.DARK);
        spark.config().setDocumentTitle(title);
        spark.config().setReportName(name);
        return spark;
    }

    public ExtentReports report(String reportFileName){

        String timeStamp = new SimpleDateFormat("yyyyMMddmmss").format(Calendar.getInstance().getTime());
        ExtentReports extent = new ExtentReports();
        extent.attachReporter(createTestCaseReport(reportFileName+""+timeStamp+".html","Title","Name"));
        return extent;
    }

    public String takeScreenShot(WebDriver driver) throws IOException {
        String timeStamp = new SimpleDateFormat("yyyyMMddmmss").format(Calendar.getInstance().getTime());
        String path = timeStamp +"_image.png";
        File source = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtil.copyFile(source,new File(path));
        return "/"+path;
    }
}
