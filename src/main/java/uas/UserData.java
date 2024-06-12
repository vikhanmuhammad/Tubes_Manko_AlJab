package uas;

public class UserData {
    private int userid;
    private int password;
    public boolean isloggedin;
    
    public UserData(int userid, int password){
        this.userid = userid;
        this.password = password;
    }
    
    public void login() throws LoginFailed{
        assert String.valueOf(userid).length() == 4 && String.valueOf(password).length() == 4 :
                "User ID and Password must be 4 digits long";
        if (password + userid == 10000){
            isloggedin = true;
        } else {
            throw new LoginFailed("Login user "+userid+" gagal, telah gagal login "
            +LoginFailed.getfailedcounter(userid)+" kali", userid);
        }
    }
}