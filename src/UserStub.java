public class UserStub {
    int userID;
    String userName;
    String password;

    public UserStub(String userName,String password){
        this.userName=userName;
        this.password=password;
    }

    public String getUserName(){
        return this.userName;
    }

    public String getPassword(){
        return this.password;
    }
}
