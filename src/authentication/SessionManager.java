package authentication;
import user.*;
import java.util.ArrayList;
import java.util.List;

class SessionManager {
    //private static SessionManager instance;
    private List<Session> sessionMappingList;

    SessionManager() {
        sessionMappingList = new ArrayList<Session>();
    }

    // public static SessionManager getInstance() {
    //     if (instance == null) {
    //        instance = new SessionManager();
    //     }
    //     return instance;
    // }

    public void createSession(User user){
        sessionMappingList.add(new Session(user));
    }

    public boolean removeSession(User user){
        for (Session session : sessionMappingList) {
            if (session.getUser().equals(user)) {
                session.setIsValid(false);
                return true;
            }
        }
        return false;
    }
}