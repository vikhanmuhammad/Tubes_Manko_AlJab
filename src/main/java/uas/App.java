package uas;


import java.util.Scanner;
/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Scanner input = new Scanner(System.in);
        boolean isLoggedin = false;
        UserData user = new UserData(0,0);
        
        while(!isLoggedin){
            System.out.println("Enter user ID: ");
            int userid = input.nextInt();
            System.out.println("Enter password: ");
            int password = input.nextInt();
            
            try{
                user = new UserData(userid, password);
                user.login();
                isLoggedin = user.isloggedin;
                System.out.println("Login berhasil!");
            } catch (LoginFailed e){
                System.out.printf("Login user %d gagal, telah gagal login %d kali\n",
                        e.getuserid(), e.getfailedcounter(e.getuserid()));
            }
        }
        
    }
}
