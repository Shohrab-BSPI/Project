package applicationDBMS;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try{
            Class.forName("org.postgresql.Driver");     //for postgresql jdbc driver class

            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/payment_getway","postgres","sh0hr@b");
            //Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/student_info","postgres","sh0hr@b");

            var query = "select * from tbl_user;";
            var stmt = con.prepareStatement(query);
            var resultSet = stmt.executeQuery();

//            try{
//                Class.forName("com.mysql.jdbc.Driver");
//                connection = DriverManager.getConnection(url,username,password);
//                var query = "select * from bookshop.booktable;";
//                var pstmt = connection.prepareStatement(query);
//                var resultSet = pstmt.executeQuery();
//
//                while(resultSet.next()){
//                    System.out.println(resultSet.getInt(1)+" | "+
//                            resultSet.getString(2)+" | "+
//                            resultSet.getInt(3)+" | "+
//                            resultSet.getString(4)+" |");
//                }
//
//            }catch(ClassNotFoundException | SQLException ce){
//                ce.printStackTrace();
//            }

            
            //for printing value from database.
            while(resultSet.next()){
                System.out.println(resultSet.getString(1)+" | "+
                        resultSet.getString(2)+" | "+
                        resultSet.getString(3)+" | "+
                        resultSet.getString(4)+" |");
            }

        }catch(ClassNotFoundException | SQLException ce){
            ce.printStackTrace();
        }

    }
}
