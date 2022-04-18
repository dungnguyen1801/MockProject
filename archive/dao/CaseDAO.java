package dao;

import context.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Book;
import model.Case;

public class CaseDAO {

    private Connection con;
    private ResultSet rs;
    private PreparedStatement ps;

    public boolean addNewBookToCase(int id, int book_id) throws SQLException {
        boolean result = false;
        try {
            con = new DBConnect().getConnection();
            String q = "INSERT INTO [dbo].[tb_contain]\n"
                    + "           ([book_case_id]\n"
                    + "           ,[book_id]\n"
                    + "           ,[create_date])\n"
                    + "     VALUES\n"
                    + "           (" + id + "\n"
                    + "           ," + book_id + "\n"
                    + "           , CAST( GETDATE() AS Date ))";
            ps = con.prepareStatement(q);
            result = ps.executeUpdate() == 1 ? true : false;
        } catch (Exception e) {
        } finally {
            con.close();
            ps.close();
            return result;
        }
    }

    public boolean deleteBookFromCase(int id, int book_id) throws SQLException {
        boolean result = false;
        try {
            con = new DBConnect().getConnection();
            String q = "DELETE FROM [dbo].[tb_contain]\n"
                    + "      WHERE [book_case_id] = " + id + " AND [book_id] = " + book_id;
            ps = con.prepareStatement(q);
            result = ps.executeUpdate() == 1 ? true : false;
        } catch (Exception e) {
            result = false;
        } finally {
            con.close();
            ps.close();
            return result;
        }
    }

    public boolean ClearBookCase(int id) throws SQLException {
        boolean result = false;
        try {
            con = new DBConnect().getConnection();
            String q = "DELETE FROM [dbo].[tb_contain]\n"
                    + "      WHERE [book_case_id] = " + id;
            ps = con.prepareStatement(q);
            result = ps.executeUpdate() == 1 ? true : false;
        } catch (Exception e) {
            result = false;
        } finally {
            con.close();
            ps.close();
            return result;
        }
    }

    public void getCase(int id, String name) throws SQLException {
        try {
            con = new DBConnect().getConnection();
            String q = "SELECT TOP(1) [book_case_id]\n"
                    + "      ,[book_case_name]\n"
                    + "  FROM [dbo].[tb_book_case]\n"
                    + "  WHERE [book_case_id] = " + id;
            ps = con.prepareStatement(q);
            rs = ps.executeQuery();
            boolean result = rs.next();
            if (!result) {
                q = "INSERT INTO [dbo].[tb_book_case]\n"
                        + "           ([book_case_id]\n"
                        + "           ,[book_case_name])\n"
                        + "     VALUES\n"
                        + "           (" + id + "\n"
                        + "           ," + name + ")";
//                System.out.println(q);
                ps = con.prepareStatement(q);
                ps.executeUpdate();

            }

        } catch (Exception e) {

        } finally {
            con.close();
            ps.close();
            rs.close();

        }
    }

    public ArrayList<Book> getListBookOnCase(int book_case_id) throws SQLException {
        ArrayList<Book> result = new ArrayList<>();
        try {
            con = new DBConnect().getConnection();
            String q = "SELECT [book_case_id]\n"
                    + "      ,[create_date]\n"
                    + "      ,[tb_book].[book_id]\n"
                    + "      ,[book_title]\n"
                    + "      ,[author]\n"
                    + "      ,[brief]\n"
                    + "      ,[publisher]\n"
                    + "      ,[content]\n"
                    + "      ,[category]\n"
                    + "  FROM  dbo.[tb_book] INNER JOIN [dbo].[tb_contain] ON [tb_contain].[book_id] = [tb_book].[book_id]\n"
                    + "  WHERE [tb_contain].[book_case_id] = " + book_case_id;
//            System.out.println(q);
            ps = con.prepareStatement(q);
            rs = ps.executeQuery();
            while (rs.next()) {
                result.add(new Book(rs.getInt(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7), rs.getString(8), rs.getString(9)));
            }
        } catch (Exception e) {
            result = null;
        } finally {
            con.close();
            ps.close();
            rs.close();
            return result;
        }

    }
}
