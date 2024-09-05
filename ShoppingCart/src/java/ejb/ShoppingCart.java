package ejb;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Remove;
import javax.ejb.Stateful;
@Stateful
public class ShoppingCart {
 List<String> contents;
 String customerName;
 private Connection conn = null;
 private ResultSet rs;
 private Statement stmt = null;
 private String query = null;
 
public void initialize(String person) {
 if (person != null) {
 customerName = person;
 try {
 Class.forName("com.mysql.jdbc.Driver").newInstance();
 conn = DriverManager.getConnection("jdbc:mysql://localhost/test", "root", "root");
 } catch(ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
 System.err.println("Sorry failed to connect to the Database." + e.getMessage());
 }
 }
 contents = new ArrayList<>();
 }
 public void addBook(String title) {
 try {
 stmt = conn.createStatement();
 query = "INSERT INTO cart VALUES('" + customerName + "','" + title + "')";
 stmt.executeUpdate(query);
 } catch(SQLException e) {
 System.err.println("Sorry failed to insert values from the database table. " + e.getMessage());
 }
 }
public void removeBook(String title) {
 try {
 stmt = conn.createStatement();
 query = "DELETE FROM cart WHERE UserName='" + customerName + "' AND ItemName='" + title + "'";
 stmt.executeUpdate(query);
 } catch(SQLException e) {
 System.err.println("Sorry failed to delete values from the database table. " + e.getMessage());
 }
 }
 public List<String> getContents() {
 try {
 stmt = conn.createStatement();
 query = "SELECT * FROM cart WHERE UserName='" + customerName + "'";
 rs = stmt.executeQuery(query);
 while(rs.next()) {
 contents.add(rs.getString("ItemName"));
 }
 } catch(SQLException e) {
 System.err.println("Sorry failed to select values from the database table. " + e.getMessage());
 }
 return contents;
 }
 @Remove()
 public void remove() {
 contents = null;
 }
}
