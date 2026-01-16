package testpackage;

import java.io.IOException;


import org.testng.annotations.Test;

import basepackage.LLBeanbaseclass;
import pagepackage.LLBeanpageclass;

public class LLBeantestpackage extends LLBeanbaseclass  {
	
	@Test
	public void testing() throws IOException, Throwable {
		LLBeanpageclass pg=new LLBeanpageclass(driver);
		
		pg.searchproduct();
		System.out.println("------------------------------------------");
		pg.mouseOver();
		System.out.println("------------------------------------------");
		pg.field();
		System.out.println("------------------------------------------");
		pg.Urlverification();
		System.out.println("------------------------------------------");
		pg.responseCode();
		System.out.println("------------------------------------------");
		pg.titleverification();
		System.out.println("------------------------------------------");
		pg.logoVerification();
		System.out.println("------------------------------------------");
		pg.dataDrivenpg();
		
		pg.end();
	}

}
