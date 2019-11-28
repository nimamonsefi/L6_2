/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.*;
/**
 *
 * @author nimamonsefi
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        try{
            Scanner scanner=new Scanner(System.in);
            
            int i;
            
            Class.forName("oracle.jdbc.driver.OracleDriver");

            Connection connection=DriverManager.getConnection("jdbc:oracle:thin:@Nima:1521:xe"
                                ,"nimamonsefi","password");
            for(i=1;i<11;i++){
                PreparedStatement preparedStatement=connection
                        .prepareStatement("insert into tb2 (code,name,fathername,mellicode,position"
                                + ",age,income,servicerecord) values (?,?,?,?,?,?,?,?)");                
                System.out.print("\nEnter Your Code : ");
                preparedStatement.setString(1,scanner.next());
                
                System.out.print("Enter Your Name : ");
                preparedStatement.setString(2,scanner.next());
                
                System.out.print("Enter Your Father's Name : ");
                preparedStatement.setString(3,scanner.next());
                
                System.out.print("Enter Your Melli Code : ");
                preparedStatement.setString(4,scanner.next());
                
                System.out.print("\nEnter Your Positon : ");
                preparedStatement.setString(5,scanner.next());
                
                System.out.print("\nEnter Your Age : ");
                preparedStatement.setInt(6,scanner.nextInt());
                
                System.out.print("\nEnter Your Income : ");
                preparedStatement.setDouble(7,scanner.nextDouble());
                
                System.out.print("\nEnter Your Service Record : ");
                preparedStatement.setInt(8,scanner.nextInt());
                
                preparedStatement.executeUpdate();
            }
            
        }catch(ClassNotFoundException|SQLException e){
            System.out.println(e.getMessage());
        }
    }
    
}
