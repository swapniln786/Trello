package LearnTestNG;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class StoreAndUseDataInSameClassForTest {
	
	@Test(dataProvider = "storeDataHere")
	public void facebookSignup(String firstName,String lastName,String emailAddress,String password,String day,String month,String year,String gender) {
		System.out.println("My firstname is "+firstName);
		System.out.println("My lastname is "+ lastName);
		System.out.println("My email address is "+ emailAddress);
		System.out.println("My password is "+ password);
		System.out.println("My DOB is "+day+"/"+month+"/"+year);
		System.out.println("My gender is "+ gender);
	}
	//Rules for storing data in th class
	//create a non static method
	//with return type as 2d array and give advanced annotation as @DataProvider
	@DataProvider
public Object[][] storeDataHere() {
	Object[][] obj= new Object[2][8];
	obj[0][0]="Sai";
	obj[0][1]="Pallavi";
	obj[0][2]="saipallavi@gmail.com";
	obj[0][3]="saipallavi@1234";
	obj[0][4]="9";
	obj[0][5]="May";
	obj[0][6]="1992";
	obj[0][7]="Female";
	obj[1][0]="Vikram";
	obj[1][1]="Batra";
	obj[1][2]="kargilHero@gmail.com";
	obj[1][3]="kargil@1234";
	obj[1][4]="9";
	obj[1][5]="Sep";
	obj[1][6]="1974";
	obj[1][7]="Male";
	return obj;
}
}
