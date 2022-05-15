package models;

import data.beans.*;
import java.sql.*;

public class UserModel {
    private Database db;

    public UserModel() throws ClassNotFoundException, SQLException{
        db = new Database();
    }

    public UserBean getUserByCredentials(String Username, String password) throws SQLException{

        UserBean userBean;
        ResultSet set = db.execQuery("SELECT * FROM users WHERE username=\""+ Username+"\" AND pwd=\""+password+"\";");
        
        if(!set.next()){
            return null;
        }

        userBean = new UserBean();

        do{
            String username = set.getString("username");
            String name = set.getString("nome");
            String surname = set.getString("cognome");
            userBean.setUsername(username);
            userBean.setCognome(surname);
            userBean.setNome(name);
        }while(set.next());
        
        return userBean;
    }

    public void RegisterUser(String username, String password, String firstname, String lastname){
        
        try {
            db.InsertQuery("INSERT INTO users(username, pwd, nome, cognome) VALUES ('"+username +"', '"+password+"', '"+firstname+"', '"+lastname+"')");
        } catch (Exception e) {
            System.out.println(e.getLocalizedMessage());
        }
    }
}
