package LearnTestNG;

import org.testng.annotations.Test;

public class DependsOnMethods {
	@Test(dependsOnMethods = "signUp")
public void login() {
	System.out.println("login");
}
	@Test
public void signUp() {
	System.out.println("signUp");
}
	@Test(dependsOnMethods = {"signUp","login","sendFriendRequest","uplodProfilePic"})
public void likePhoto() {
	System.out.println("likePhoto");
}
	@Test(dependsOnMethods = {"signUp","login","uplodProfilePic"})
public void sendFriendRequest() {
	System.out.println("sendFriendRequest");
}
	@Test(dependsOnMethods ={"signUp","login","sendFriendRequest"} )
public void deleteFriendRequest() {
	System.out.println("deleteFriendRequest");
}
@Test(dependsOnMethods = {"signUp","login","sendFriendRequest","uplodProfilePic"})
public void postComment() {
	System.out.println("postComment");
}
@Test(dependsOnMethods ={"signUp","login"} )
public void uplodProfilePic() {
	System.out.println("uplodProfilePic");
}

}
