package com.project.stepDefinitions;

import com.project.CreateBill;
import io.cucumber.java.en.*;

import java.io.File;

import static com.saf.framework.AutomationConstants.filePath;

public class PDFCreation {

    public static String doc1devFilePath = "C:\\doc1dev\\NBD\\";
    String fileName;

    CreateBill createBill = new CreateBill();

    @Given("Check xlog file exist")
    public void check_xlog_file_exist() {
        File path = new File(filePath + "XLOG");
        fileName = createBill
                .checkFileExistStartsWith(path, true, "2022", "XLog");
    }

    @When("Remove data folder")
    public void remove_data_folder() {
        File path = new File(doc1devFilePath + "data");
        createBill
                .deleteFilesWithExtension(path, ".xlog");
    }

    @When("Remove dataC folder")
    public void remove_dataC_folder() {
        File path = new File(doc1devFilePath + "dataC");
        createBill
                .deleteDirectory(path);
    }

    @When("Remove pdf folder")
    public void remove_pdf_folder() {
        File path = new File(doc1devFilePath + "pdf");
        createBill
                .deleteDirectory(path);
    }

    @When("Move xlog file")
    public void move_xlog_file() {
        createBill
                .moveFile(filePath + "XLOG\\" + fileName, doc1devFilePath + "data", "XLog");
    }

    @When("Run bat file")
    public void run_bat_file() {
        createBill
                .runBat(doc1devFilePath, "manipule_C.bat", "FINISHED");
    }

    @Then("Check pdf file")
    public void check_pdf_file() {
        fileName = fileName.substring(0, fileName.lastIndexOf('.'));
        File path = new File(doc1devFilePath + "pdf");
        fileName = createBill
                .checkFileWithExtension(path, true, fileName, ".pdf");

        createBill
                .moveFile(doc1devFilePath + "pdf\\" + fileName, filePath + "Fatura_PDF\\", "PDF");

    }
}
