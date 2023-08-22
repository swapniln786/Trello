package LearnTestNG;

import org.testng.annotations.Test;

public class DependsOnGroups {
	@Test(groups = "functional")
public void testCase1() {
	System.out.println("testCase1");
}
@Test(groups = "functional")
public void testCase2() {
	int[] a= {1,2,3};
	System.out.println(a[3]);
	System.out.println("testCase2");
	
}
@Test(groups = "integration",dependsOnGroups = "functional")
public void testCase3() {
	System.out.println("testCase3");
}
}
