package com.Vivek.Utils;

import java.io.IOException;

public class AllureReportGenerator {

    public static void main(String[] args) {
        // Provide the path to the directory containing Allure result data
        String resultsDirectory = "/allure-results";

        // Get the project's base directory
        String projectDirectory = System.getProperty("user.dir");

        // Generate Allure report
        generateAllureReport(projectDirectory, resultsDirectory);
    }

    private static void generateAllureReport(String projectDirectory, String resultsDirectory) {
        try {
            // Build the command to execute "allure serve" with the specified results directory
            String command = "allure serve " + resultsDirectory;

            // Execute the command in the terminal, setting the working directory
            Process process = Runtime.getRuntime().exec(command, null, new java.io.File(projectDirectory));

            // Wait for the process to complete
            int exitCode = process.waitFor();

            // Check if the command was executed successfully
            if (exitCode == 0) {
                System.out.println("Allure report generated successfully.");
            } else {
                System.err.println("Error generating Allure report. Exit code: " + exitCode);
            }

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
