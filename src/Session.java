public class Session {

	private long expirationTime;
	private User user;
	private int sessionId;
	private boolean isValid;

	/**
	 * 
	 * @param expirationTime
	 * @param user
	 * @param sessionId
	 */
	public Session(string expirationTime, User user, int sessionId) {
		// TODO - implement Session.Session
		throw new UnsupportedOperationException();
	}

	public int getSessionId() {
		return this.sessionId;
	}

	public boolean getIsValid() {
		return this.isValid;
	}

	/**
	 * 
	 * @param isValid
	 */
	public void setIsValid(boolean isValid) {
		this.isValid = isValid;
	}

	public long getExpirationTime() {
		return this.expirationTime;
	}

}