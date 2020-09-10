package docker;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class StopDocker {

	
	
	public static void stopfile() throws IOException, Exception{
		boolean flag=false;
	Runtime runtime =Runtime.getRuntime();
	runtime.exec("cmd /c start dockerDown.bat");
	
	String file="output.txt";
	Calendar cal=Calendar.getInstance();
	cal.add(Calendar.SECOND, 50);
	long stop= cal.getTimeInMillis();
	Thread.sleep(30000);
	while(System.currentTimeMillis()<stop){
		if(flag){
			
			break;
		}
		
		BufferedReader buffereader=new BufferedReader(new FileReader(file));
		String str=buffereader.readLine();
		while(str!=null){
			if(str.contains("Selenium-hub exited")){
			
				System.out.println("Text found");
				flag=true;
				break;
				
			}
			str=buffereader.readLine();
		}
		buffereader.close();
		if(flag){
			Assert.assertTrue(flag);
			Thread.sleep(15000);
		}
		
		
		
	}
	File f=new File("output.txt");
	if(f.delete()){
		System.out.println("Deleted a file successfully");
	}
	}
	
}
