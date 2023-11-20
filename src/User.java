import java.util.Random;
public class User {
	private String username;
	private String password;
	private Account account;

	private long userID;
	//generating random userID (should we check if the ID already exists?)
	public long generateUserID() {
		Random random = new Random();
		return random.nextLong();
	}
	//constructor
	public User(String userN, String passW, Account acc) {
		userID=generateUserID();
		this.username=userN;
		this.password=passW;
		this.account=acc;
	}

}