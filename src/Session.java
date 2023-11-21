import java.util.UUID;

public class Session {
    UserStub user;
    UUID sessionId;
    Boolean isValid;

    public Session(UserStub user){
        this.user=user;
        this.isValid=true;
        this.sessionId=generateSessionId();
    }

    private UUID generateSessionId(){
        return UUID.randomUUID();
    }

    public Boolean getIsValid(){
        return this.isValid;
    }

    public void setIsValid(Boolean bool){
        this.isValid=bool;
    }

    public UserStub getUser(){
        return this.user;
    }
}


