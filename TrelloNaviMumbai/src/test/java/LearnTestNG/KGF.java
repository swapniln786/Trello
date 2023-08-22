package LearnTestNG;

import org.testng.annotations.Test;

public class KGF {
	@Test(priority = 2)
public void garuda() {
	System.out.println("garuda controlled the kgf");
}
	@Test(priority =3,invocationCount = 7 )
public void rocky() {
	System.out.println("rocky controlled the kgf");
}
	@Test(priority = 1)
public void suryaVardhan() {
	System.out.println("suryavardhan controlled the kgf");
}
	@Test(priority = 4)
public void mumbaiShetty() {
	System.out.println("mumbaiShetty controlled the kgf");
}
	@Test(enabled = false)
public void vanaram() {
	System.out.println("vanaram controlled the kgf");
}
	@Test(priority = 5)
public void rajendraDesai() {
	System.out.println("rajendraDesai controlled the kgf");
}
@Test(priority = 7)	
public void ramikaSen() {
	System.out.println("ramikaSen controlled the kgf");
}
@Test(priority = 6)
public void adheera() {
	System.out.println("adheera controlled the kgf");
}
}
