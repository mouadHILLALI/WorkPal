package service;
import repository.admin.AdminRepositroyImpl;
public class AdminServices {
    public Boolean addUser(String username, String password , String email) {
        try {
            if (username.equals("") || password.equals("") || email.equals("")) {
                return false;
            }
            AdminRepositroyImpl admin = new AdminRepositroyImpl();
            Boolean flag = admin.addUser(username, password, email);

            if (flag) {
                return true;
            }else {
                return false;
            }
        } catch (RuntimeException e) {
            throw e;
        }
    }
}
