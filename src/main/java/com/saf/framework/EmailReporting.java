package com.saf.framework;

import java.awt.Desktop;
import java.io.File;

public class EmailReporting {
	
	public static void sendMail() {
		
		try {

	            Desktop dk = null;
	            dk = Desktop.getDesktop();
	            
	            File f = new File("mail.vbs");
	            //Process process = Runtime.getRuntime().exec("cmd.exe /C attrib -s -h -r "+ f.getAbsolutePath());
	            dk.open(f);
	            Thread.sleep(5000);
	            
	            //File toBeRemoved = new File("mail.vbs");
	            /*if(toBeRemoved.exists()){
	                            toBeRemoved.delete();
	            }
	            */
			} catch (Exception ex) {
            
				ex.printStackTrace();
			            
			}

	}
}
