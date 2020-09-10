package docker;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import org.testng.Assert;

public class StartDocker  {

	

	public static void startfile() throws IOException, Exception{
		boolean flag=false;
	Runtime runtime =Runtime.getRuntime();
	runtime.exec("cmd /c start dockerUp.bat");
	
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
			if(str.contains("The node is registered to the hub and ready to use")){
			
				System.out.println("Text found");
				flag=true;
				break;
				
			}
			str=buffereader.readLine();
		}
		buffereader.close();
		if(flag){
			Assert.assertTrue(flag);
			runtime.exec("cmd /c start Scaleup.bat");
			Thread.sleep(15000);
		}
		
	}}
	
}
