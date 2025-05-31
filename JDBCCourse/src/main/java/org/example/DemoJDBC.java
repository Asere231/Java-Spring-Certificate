package org.example;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class DemoJDBC {
    public static void main(String[] args) {

        /*
            Steps:

           Import library
           Load and register Driver
           Create Connection
           Create Statement
           Execute Statement
           Process the Result
           Close Connection
         */

        Properties props = new Properties();
        String url = "";
        String username = "";
        String password = "";

        try (InputStream input = DemoJDBC.class.getClassLoader().getResourceAsStream("db.properties")) {
            if (input == null) {
                throw new RuntimeException("Can't find db.properties");
            }

            props.load(input);
            url = props.getProperty("db.url");
            username = props.getProperty("db.username");
            password = props.getProperty("db.password");

        } catch (Exception e) {
            throw new RuntimeException("Failed to load DB properties", e);
        }

//        String query = "select * from student";

//      Now we will try PreparedStatement
        String query = "insert into student values (?,?,?)";

        int sid = 5;
        String sname = "Jasmine";
        int marks = 52;


//        Step 2 (Optional): Load and register
//        try {
//            Class.forName("org.postgresql.Driver");
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
//        }


        try {
//          Step 3: Create Connection
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Connection Established");

//          Step 4: Create Statement
            PreparedStatement ps = connection.prepareStatement(query);
            ps.setInt(1, sid);
            ps.setString(2, sname);
            ps.setInt(3, marks);

//            Statement statement = connection.createStatement();

//          Step 5: Execute Statement
            ps.execute();
//            ResultSet rs = statement.executeQuery(query);


//          Step 6: Process the Result
//          In this case is very simple, we are just checking if we got any values from the DB
//          If we did, we'll get 'true', else, 'false'
//            System.out.println(rs.next());

//          In this case we need to say rs.next(); because when we get the ResultSet from executing
//          the query, the pointer is before the first element,so we need to move forward to the
//          the actual first element. If we don't do this we will get an error
//            rs.next();
//            String name = rs.getString("sname");
//            System.out.println("Student name is: " + name);

//            while (rs.next()) {
//                System.out.print(rs.getInt(1) + " - ");
//                System.out.print(rs.getString(2) + " - ");
//                System.out.println(rs.getInt(3));
//            }

//          Step 7: Close Connection
            connection.close();
            System.out.println("connection closed");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }





    }
}