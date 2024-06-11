
package bank.management.system;

import java.sql.*;
public class Conn {
    Connection c;
    Statement s;
    public Conn()
    {
        try
        {
         
         c=DriverManager.getConnection("jdbc:mysql:///bank","root","raje@143");
         s=c.createStatement();
         
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
            
            
    }

    public Statement createStatement() {
        try {
            return c.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
        
        
}
