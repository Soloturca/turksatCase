package com.project.createBill;

import com.project.stepdefs.CreateBill;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.File;

public class billCreation {

    CreateBill create_xlog_test = new CreateBill();

    String filePath = "\\\\izmirnas\\vol1_filesrv\\Faturalama&Ucretlendirme_Konfig.Yonetimi\\HandsUP_Squad\\Jenkins\\E2E_Test_Cases\\";
    String user = "invprint";
    String host = "172.31.61.8";
    String password = "Phg6Ytr9999999";

    @Given("Check file exist")
    public void check_file_exist() {
        File dirPath = new File(filePath);
        create_xlog_test
                .checkFileExist(dirPath, true);
    }

    @When("Connect to server")
    public void connect_to_server() {
        create_xlog_test
                .connectServer(user, host, password,"");
        create_xlog_test
                .checkFileExist(new File("/d101/d01/invprint/data/xml_cbu/"), false);
    }

    @When("Move old file to backup")
    public void move_old_file_to_backup() {
    }

    @When("Connect to run server")
    public void connect_to_run_server() {
    }

    @When("Run sh files")
    public void run_sh_files() {
    }

    @Then("Move xlog file")
    public void move_xlog_file() {
    }
}
