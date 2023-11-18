public class DataStorage {

	private SQLConnection connection;
	private static DataStorage database = new DataStorage();

	private DataStorage() {
		// TODO - implement DataStorage.DataStorage
		throw new UnsupportedOperationException();
	}

	public static DataStorage getInstance() {
		// TODO - implement DataStorage.getInstance
		throw new UnsupportedOperationException();
	}

	/**
	 * 
	 * @param userID
	 * @param password
	 */
	public SQLConnection login(String userID, String password) {
		// TODO - implement DataStorage.login
		throw new UnsupportedOperationException();
	}

	public void endConnection() {
		// TODO - implement DataStorage.endConnection
		throw new UnsupportedOperationException();
	}

	public void fileStorage() {
		// TODO - implement DataStorage.fileStorage
		throw new UnsupportedOperationException();
	}

}