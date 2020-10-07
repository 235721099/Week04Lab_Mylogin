
package domain;

/**
 *
 * @author 730676
 */
public class AccountService {
    public static User login(String username, String password){
        if((username.equals("adam") || username.equals("betty")) && password.equals("password")){
            return new User(username, null);
        }else{
            return null;
        }
            
    }
}
