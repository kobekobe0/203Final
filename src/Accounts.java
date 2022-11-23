
public class Accounts {
	 static UserAccount accounts[] = new UserAccount[50];
	 
	 //add tickets array here
	 public static void addAccount(String name, String password, int money) {
		 UserAccount account = new UserAccount(name, password, money);
		 accounts[0] = account;
		 int arrayTracker = 0;
		 while(accounts[arrayTracker] != null) {
			 arrayTracker++;
		 }
		 accounts[arrayTracker] = account;
	 }
	 
	 public static Boolean findAccount(String name, String password) {
		 //pwede rin i set nalang dito yung currentuser class
		 //then mag rereturn ng boolean if tama ba yung credentials
		 //if tama, next page, if hindi, edi hindi
		 int arrayTracker = 0;
		 while(accounts[arrayTracker] != null) {
			 if(accounts[arrayTracker].name.equals(name) && accounts[arrayTracker].password.equals(password)) {
				 return true;
			 };
			 arrayTracker++;
		 }
		 return false;
	 }
	 
	 public static UserAccount getAccount(String name, String password) {
		 int arrayTracker = 0;
		 UserAccount returnValue = null;
		 while(accounts[arrayTracker] != null) {
			 if(accounts[arrayTracker].name.equals(name) && accounts[arrayTracker].password.equals(password)) {
				 returnValue = accounts[arrayTracker];
				 break;
			 };
			 arrayTracker++;
		 }
		 return returnValue;
		 
	 }
	 
	 public static void printAccount(int size) {
		for(int i = 0; i < size; i++) {
			System.out.println("Name: " + accounts[i].name);
		}	 
		 
	 }

}
	