import java.util.ArrayList;
import java.util.List;

public class SessionManager {
    private static SessionManager instance;
    private List<Session> sessionMappingList;

    private SessionManager() {
        sessionMappingList = new ArrayList<Session>();
    }

    public static SessionManager getInstance() {
        if (instance == null) {
           instance = new SessionManager();
        }
        return instance;
    }

    public void createSession(UserStub user){
        sessionMappingList.add(new Session(user));
    }

    public boolean removeSession(UserStub user){
        for (Session session : sessionMappingList) {
            if (session.getUser().equals(user)) {
                session.setIsValid(false);
                return true;
            }
        }
        return false;
    }
}