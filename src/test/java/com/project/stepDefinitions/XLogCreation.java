package com.project.stepDefinitions;

import com.jcraft.jsch.JSchException;
import com.project.CreateBill;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import static com.saf.framework.MyTestNGBaseClass.allureReport;

public class XLogCreation {

    CreateBill createBill = new CreateBill();

    String filePath = "\\\\izmirnas\\vol1_filesrv\\Faturalama&Ucretlendirme_Konfig.Yonetimi\\HandsUP_Squad\\Jenkins\\E2E_Test_Cases\\";
    String user = "invprint";
    String host = "172.31.61.8";
    String password = "Phg6Ytr9999999";
    ArrayList<String> commands = new ArrayList<>();

    String fileName;
    String fileDir = "/d101/d01/invprint/data/xml_cbu/";

    @Given("Check xml file exist")
    public void check_xml_file_exist() {
        File dirPath = new File(filePath);
        fileName = createBill
                .checkFileExist(dirPath, true);
    }

    @Given("Set commands")
    public void set_commands() {
        String[] fileNameArray = fileName.split("_");
        if (fileNameArray.length == 0)
            allureReport("FAIL", "File name is empty", false);
        String sfxcbureset = "sfxcbu_reset.sh " + fileNameArray[1].substring(0, 6) + " " + fileNameArray[1].substring(6, 8);
        String sfxcbu = "sfxcbu.sh " + fileNameArray[1].substring(0, 6) + " " + fileNameArray[1].substring(6, 8) + " OFF ON";

        commands.add("mv /d101/d01/invprint/data/xml_cbu/*.xml /d101/d01/invprint/data/xml_cbu/Backup/");
        commands.add("rm -f /d101/d01/invprint/data/output/cbu/undetails/*");
        commands.add(sfxcbureset);
        commands.add(sfxcbu);
    }

    @When("Move old file to backup")
    public void move_old_file_to_backup() {
        createBill
                .moveOldFilesToBackup(user, host, password, commands.get(0));
    }

    @When("Remove old xlog files")
    public void remove_old_xlog_files() {
        createBill
                .removeOldXlogFiles(user, host, password, commands.get(1));
    }

    @When("Copying xml file to server")
    public void copying_xml_file_to_server() {
        createBill
                .copyingXmlFileToServer(user, host, password, filePath + fileName, fileDir);
    }

    @When("Run commands")
    public void run_commands() {
        createBill
                .runShellCommands(user, host, password, commands.get(2), 10)
                .runShellCommands(user, host, password, commands.get(3), 20);
    }

    @Then("Check xlog file")
    public void check_xlog_file() throws JSchException, IOException, InterruptedException {
        boolean isFileCreated = createBill
                .checkXlogFile(user, host, password);

        if (!isFileCreated)
            allureReport("FAIL", "Xlog file could not created", false);

        createBill
                .moveXMLDone(fileName)
                .moveXLogFile(user, host, password, filePath + "XLog");

    }
}
