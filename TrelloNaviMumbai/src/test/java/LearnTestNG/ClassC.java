package LearnTestNG;

import org.testng.annotations.Test;

public class ClassC extends ClassPreAndPostConditions {
	@Test(groups = "system")
	public void testH() {
		System.out.println("testH");
	}
	@Test(groups = {"functional","integration"})
public void testI() {
		System.out.println("testI");
	}
	@Test(groups = "integration")
public void testJ() {
	System.out.println("testJ");
}
}
