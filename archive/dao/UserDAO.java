package dao;

import context.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import model.User;

public class UserDAO {

    private Connection con;
    private ResultSet rs;
    private PreparedStatement ps;

    public User getUserAccount(String acc, String pass) throws SQLException {
        User result = null;
        try {
            con = new DBConnect().getConnection();
            String q = "SELECT [id]\n"
                    + "      ,[user_name]\n"
                    + "      ,[role_id]\n"
                    + "  FROM [dbo].[tb_user]\n"
                    + "  Where [user_name] like '" + acc + "' and [password] like '" + pass + "'";
            System.out.println(q);
            ps = con.prepareStatement(q);
            rs = ps.executeQuery();
            if (rs.next()) {
                result = new User(acc, "", rs.getInt(3), rs.getInt(1));
            }
//            result = ps.execute();

        } catch (Exception e) {
            result = null;
        } finally {
            con.close();
            ps.close();
            rs.close();
            return result;
        }

    }

    public boolean addNewUser(String username, String password) throws SQLException {
        boolean result = false;
        try {
            con = new DBConnect().getConnection();
            String q = "INSERT INTO [dbo].[tb_user]\n"
                    + "           ,[user_name]\n"
                    + "           ,[password]\n"
                    + "           ,[role_id])\n"
                    + "     VALUES\n"
                    + "           ("+username+"\n"
                    + "           ,"+password+"\n"
                    + "           ,2)";
            ps = con.prepareStatement(q);
            result = ps.execute();
        } catch (Exception e) {
        } finally {
            con.close();
            ps.close();
            return result;
        }
    }
}
