package com.utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {

 private static ExtentReports extent;


 public static ExtentReports createInstance() {
     if (extent == null) {
         ExtentSparkReporter sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/test-output/ExtentReport.html");

         sparkReporter.config().setDocumentTitle("Paidline Automation Report");
         sparkReporter.config().setReportName("QA Regression Suite");
         sparkReporter.config().setTheme(Theme.STANDARD);

         extent = new ExtentReports();
         extent.attachReporter(sparkReporter);
         extent.setSystemInfo("Environment", "QA");
         extent.setSystemInfo("Tester", "Kartik Sharma");
     }
     return extent;
 }
}
