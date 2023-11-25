package authentication;
import user.*;
import java.util.ArrayList;
import java.util.List;

class SessionManager {
    private List<Session> sessionMappingList;

    SessionManager() {
        sessionMappingList = new ArrayList<Session>();
    }

    void createSession(User user){
        sessionMappingList.add(new Session(user));
    }

    boolean removeSession(User user){
        for (Session session : sessionMappingList) {
            if (session.getUser().equals(user)) {
                session.setIsValid(false);
                return true;
            }
        }
        return false;
    }
}