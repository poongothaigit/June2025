package com.CucumberSFWithPOMUpgrade.Utility;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

public class MasterthoughtReportGenerator {

	 public static void generateReport() {
		 try {
	            // Path to where the JSON files are generated
	            String jsonPath = "target/cucumber-reports/cucumber.json";

	            // Output directory for the HTML report
	            File reportOutputDir = new File("target/reports/html-reports");
	            reportOutputDir.mkdirs();
	            
	            // Project name shown in the report
	            Configuration config = new Configuration(reportOutputDir, "com.CucumberSFWithPOMUpgrade");

	            // Optional metadata
	            config.addClassifications("Platform", "Windows");
	            config.addClassifications("Browser", "Chrome");
	            config.addClassifications("Cucumber Version", "7.x");
	            config.addClassifications("Java Version", System.getProperty("java.version"));

	            // Add all Cucumber JSON files
	            List<String> jsonFiles = new ArrayList<>();
	            jsonFiles.add(jsonPath);

	            // Create report
	            ReportBuilder reportBuilder = new ReportBuilder(jsonFiles, config);
	            reportBuilder.generateReports();

	            System.out.println("Masterthought report generated successfully!");
	        } catch (Exception e) {
	            System.out.println("Failed to generate Masterthought report: " + e.getMessage());
	            e.printStackTrace();
	        }
	    }
}
