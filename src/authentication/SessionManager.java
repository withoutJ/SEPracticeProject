package authentication;
import user.*;
import java.util.ArrayList;
import java.util.List;

class SessionManager {
    private List<Session> sessionMappingList;

    SessionManager() {
        sessionMappingList = new ArrayList<Session>();
    }
    
    public void addSession(Session session) {
    	sessionMappingList.add(session);
    	}

    public int getSessionCount(){
        return sessionMappingList.size();
    }

    public void createSession(User user){
        sessionMappingList.add(new Session(user));
    }

    boolean removeSession(User user){
        for (Session session : sessionMappingList) {
            if (session.getUser().equals(user)) {
                if(session.getIsValid()==true){
                    session.setIsValid(false);
                    return true;
                }
                
            }
        }
        return false;
    }
}