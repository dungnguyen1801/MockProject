/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBConnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import model.Book;
import model.User;

public class BookDAO {

    private Connection con;
    private ResultSet rs;
    private PreparedStatement ps;

    public ArrayList<Book> getListBook() throws SQLException {
        ArrayList<Book> result = new ArrayList<>();
        try {
            con = new DBConnect().getConnection();
            String q = "SELECT [book_id]\n"
                    + "      ,[book_title]\n"
                    + "      ,[author]\n"
                    + "      ,[brief]\n"
                    + "      ,[publisher]\n"
                    + "      ,[content]\n"
                    + "      ,[category]\n"
                    + "  FROM [reading_book_db].[dbo].[tb_book]";
//            System.out.println(q);
            ps = con.prepareStatement(q);
            rs = ps.executeQuery();
            while (rs.next()) {
                result.add(new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
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

    public boolean addNewBook(Book book) throws SQLException {
        boolean result = false;
        try {
            con = new DBConnect().getConnection();
            String q = "INSERT INTO [dbo].[tb_book]\n"
                    + "           ([book_id]\n"
                    + "           ,[book_title]\n"
                    + "           ,[author]\n"
                    + "           ,[brief]\n"
                    + "           ,[publisher]\n"
                    + "           ,[content]\n"
                    + "           ,[category])\n"
                    + "     VALUES\n"
                    + "           (" + book.getId() + "\n"
                    + "           ,'" + book.getTitle() + "'\n"
                    + "           ,'" + book.getAuthor() + "'\n"
                    + "           ,'" + book.getBrief() + "'\n"
                    + "           ,'" + book.getPublisher() + "'\n"
                    + "           ,'" + book.getContent() + "'\n"
                    + "           ,'" + book.getCategory() + "')";
            ps = con.prepareStatement(q);
            result = ps.executeUpdate() == 1 ? true : false;
        } catch (Exception e) {
        } finally {
            con.close();
            ps.close();
            return result;
        }
    }

    public boolean editBookContent(int id, String content) throws SQLException {
        boolean result = false;
        try {
            con = new DBConnect().getConnection();
            String q = "UPDATE [dbo].[tb_book]\n"
                    + "   SET [content] = '" + content + "'\n"
                    + " WHERE  [book_id] = " + id;
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

    public boolean deleteBook(int id) throws SQLException {
        boolean result = false;
        try {
            con = new DBConnect().getConnection();
            String q = "DELETE FROM [dbo].[tb_book]\n"
                    + "      WHERE [book_id] = " + id;
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

    public Book getBook(int id) throws SQLException {
        Book result = null;
        try {
            con = new DBConnect().getConnection();
            String q = "SELECT TOP(1) [book_id]\n"
                    + "      ,[book_title]\n"
                    + "      ,[author]\n"
                    + "      ,[brief]\n"
                    + "      ,[publisher]\n"
                    + "      ,[content]\n"
                    + "      ,[category]\n"
                    + "  FROM [reading_book_db].[dbo].[tb_book]"
                    + "WHERE [book_id] = " + id;
//            System.out.println(q);
            ps = con.prepareStatement(q);
            rs = ps.executeQuery();
            if (rs.next()) {
                result = new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7));
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

    public ArrayList<Book> getBookByName(String name) throws SQLException {
        ArrayList<Book> result = new ArrayList<>();
        try {
            con = new DBConnect().getConnection();
            String q = "SELECT [book_id]\n"
                    + "      ,[book_title]\n"
                    + "      ,[author]\n"
                    + "      ,[brief]\n"
                    + "      ,[publisher]\n"
                    + "      ,[content]\n"
                    + "      ,[category]\n"
                    + "  FROM [reading_book_db].[dbo].[tb_book] WHERE [book_title] like '%"+name+"%'";
//            System.out.println(q);
            ps = con.prepareStatement(q);
            rs = ps.executeQuery();
            while (rs.next()) {
                result.add(new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
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

    public ArrayList<Book> getBookByAuthor(String author) throws SQLException {
        ArrayList<Book> result = new ArrayList<>();
        try {
            con = new DBConnect().getConnection();
            String q = "SELECT [book_id]\n"
                    + "      ,[book_title]\n"
                    + "      ,[author]\n"
                    + "      ,[brief]\n"
                    + "      ,[publisher]\n"
                    + "      ,[content]\n"
                    + "      ,[category]\n"
                    + "  FROM [reading_book_db].[dbo].[tb_book] "
                    + "WHERE [author] like '%"+author+"%'";
//            System.out.println(q);
            ps = con.prepareStatement(q);
            rs = ps.executeQuery();
            while (rs.next()) {
                result.add(new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
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

    public ArrayList<Book> getBookByCategory(String category) throws SQLException {
        ArrayList<Book> result = new ArrayList<>();
        try {
            con = new DBConnect().getConnection();
            String q = "SELECT [book_id]\n"
                    + "      ,[book_title]\n"
                    + "      ,[author]\n"
                    + "      ,[brief]\n"
                    + "      ,[publisher]\n"
                    + "      ,[content]\n"
                    + "      ,[category]\n"
                    + "  FROM [reading_book_db].[dbo].[tb_book]"
                    + "WHERE [category] like '%"+category+"%'";
//            System.out.println(q);
            ps = con.prepareStatement(q);
            rs = ps.executeQuery();
            while (rs.next()) {
                result.add(new Book(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getString(6), rs.getString(7)));
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

}
