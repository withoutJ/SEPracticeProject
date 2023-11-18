public class AuthenticationService {

	private UserDatabase dbContext;
	private SessionManager sessionManager;

	/**
	 * 
	 * @param userName
	 * @param password
	 */
	public User login(string userName, string password) {
		// TODO - implement AuthenticationService.login
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param sessionId
	 */
	public sessionId logout(integer sessionId) {
		// TODO - implement AuthenticationService.logout
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param userName
	 * @param password
	 */
	public User register(string userName, string password) {
		// TODO - implement AuthenticationService.register
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param userName
	 */
	public User findUser(string userName) {
		// TODO - implement AuthenticationService.findUser
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param user
	 * @param givenPassword
	 */
	public boolean validatePassword(User user, string givenPassword) {
		// TODO - implement AuthenticationService.validatePassword
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param dbContext
	 * @param sessionManager
	 */
	public AuthenticationService(UserDatabase dbContext, SessionManager sessionManager) {
		// TODO - implement AuthenticationService.AuthenticationService
		throw new UnsupportedOperationException();
	}

}