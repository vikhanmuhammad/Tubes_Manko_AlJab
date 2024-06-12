package uas;

import java.util.HashMap;


public class LoginFailed extends Exception{
    private static HashMap<Integer, Integer> failedcount = new HashMap<>();
    private int userid;
    
    public LoginFailed(String msg, int user){
        super(msg);
        this.userid = user;
        if(failedcount.containsKey(user)){
            failedcount.put(user, failedcount.get(user) + 1);
        } else {
            failedcount.put(user, 1);
        }
    }
    
    public int getuserid(){
        return userid;
    }
    
    public static int getfailedcounter(int user){
        if(failedcount.containsKey(user)){
            return failedcount.get(user);
        } else {
            return 0;
        }
    }
}