/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author dell
 */
public class TestConnection {
    private final Connection con;
    public TestConnection() throws ClassNotFoundException,SQLException{
        Class.forName("com.mysql.cj.jdbc.Driver");
        this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/thongtin","root","");
//        if(con !=null){
//            JOptionPane.showMessageDialog(null, "Ban da dang nhap thanh cong");
//        }
        
    }
    public ResultSet GetData(String tbName) throws SQLException{
        ResultSet kq =null;
        Statement statement = this.con.createStatement();
        String sql ="select*from dangnhap";
        kq = statement.executeQuery(sql);
        return kq;
    }
    
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        TestConnection ts = new TestConnection();
       ResultSet rs = ts.GetData("dangnhap");
       while(rs.next()){
           
           System.out.println("id: "+rs.getString(1));
           System.out.println("name: "+rs.getString(2));
       }
    }
    
}
