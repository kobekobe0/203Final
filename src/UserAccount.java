
public class UserAccount {
	String name;
	String password;
	int money;
	//class of ticket, array variable
	
	UserAccount(String name, String password, int money)
    {
        this.name = name;
        this.password = password;
        this.money = money;
    }
	
	 public void display()
	    {
	        System.out.println("Student id is: " + password + " "+ "and Student name is: "+ name);
	    }
}
