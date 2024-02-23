package com.Vivek.Utils;

import java.io.File;
import java.io.IOException;

public class AllureReportGenerator {

    public static void main(String[] args) {
        String resultsDirectory = "/allure-results";

        String projectDirectory = System.getProperty("user.dir");

        generateAllureReport(projectDirectory, resultsDirectory);
    }

    private static void generateAllureReport(String projectDirectory, String resultsDirectory) {
        try {
            String command = "allure";
            String serveCommand = "serve";
            String resultsPath = new File(projectDirectory, resultsDirectory).getPath();

            ProcessBuilder processBuilder = new ProcessBuilder(command, serveCommand, resultsPath);

            processBuilder.directory(new File(projectDirectory, "allure-results"));

            Process process = processBuilder.start();


            int exitCode = process.waitFor();

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
