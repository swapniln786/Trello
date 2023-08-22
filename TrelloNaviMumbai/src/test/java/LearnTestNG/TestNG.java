package LearnTestNG;

import org.testng.annotations.Test;

public class TestNG {
	
	@Test(dataProvider = "storeDataHere",dataProviderClass = DataClass.class)
public void facebookSignup(String firstName,String lastName,String emailAddress,String password,String day,String month,String year,String gender) {
	System.out.println("My firstname is "+firstName);
	System.out.println("My lastname is "+ lastName);
	System.out.println("My email address is "+ emailAddress);
	System.out.println("My password is "+ password);
	System.out.println("My DOB is "+day+"/"+month+"/"+year);
	System.out.println("My gender is "+ gender);
}
}
