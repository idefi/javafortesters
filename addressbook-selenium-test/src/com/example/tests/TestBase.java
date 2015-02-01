package com.example.tests;

import com.example.fw.ApplicationManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import java.util.*;

public class TestBase {

	protected ApplicationManager app;

	@BeforeTest
	public void setUp() throws Exception {
		app = new ApplicationManager();
	  }

	@AfterTest  
	public void tearDown() throws Exception {
		app.stop();
	  }

	@DataProvider
	public Iterator<Object[]> randomValidGroupGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i=0; i<5; i++ ){
			GroupData group = new GroupData()
					.withName(generateRandomString())
					.withHeader(generateRandomString())
					.withFooter(generateRandomString());
			list.add(new Object[]{group});
		}
		return list.iterator();
	}

	@DataProvider
	public Iterator<Object[]> randomValidContactGenerator() {
		List<Object[]> list = new ArrayList<Object[]>();
		for (int i=0; i<3; i++ ){
			ContactData contact = new ContactData()
				.withFirstname(generateRandomString())
				.withLastname(generateRandomString())
				.withAddress(generateRandomString())
				.withHome(generateRandomString())
				.withMobile(generateRandomString())
				.withWork(generateRandomString())
				.withEmail(generateRandomString())
				.withEmail2(generateRandomString())
				.withBday(generateRandomInt(1, 31))
				.withBmonth(generateRandomMonth())
				.withByear(generateRandomInt(1900, 2015))
				//.withNew_group("1")
				.withAddress2(generateRandomString())
				.withPhone2(generateRandomString());
			list.add(new Object[]{contact});
		}
		return list.iterator();
	}

	public String generateRandomString(){
		Random rnd = new Random();
		if (rnd.nextInt(3) == 0 ) {
			return ""; }
		else {
			return "test" + rnd.nextInt();
		}
	}

	public static String generateRandomInt(int min, int max) {
		Random rnd = new Random();
			return String.valueOf(rnd.nextInt((max - min) + 1) + min);
	}

	public String generateRandomMonth() {
		Random rnd = new Random();
		List<String> monthNames = Arrays.asList("-", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December");
		return monthNames.get(rnd.nextInt(monthNames.size()));
	}
}