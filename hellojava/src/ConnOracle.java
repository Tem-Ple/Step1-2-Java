import java.sql.*;

public class ConnOracle {
    public static final String DBDRIVER="oracle.jdbc.driver.OracleDriver";
    public static final String DBURL="jdbc:oracle:thin:@172.17.0.2:1521:orclcdb";
    public static final String DBUSER="system";//用户名
    public static final String DBPASSWORD="oracle";

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName(DBDRIVER);
        ResultSet rs=null;
        PreparedStatement pstmt=null;
        Connection conn = DriverManager.getConnection(DBURL,DBUSER,DBPASSWORD);

        String sql="SELECT * FROM v$pdbs";
        pstmt=conn.prepareStatement(sql);
        rs=pstmt.executeQuery();
        while(rs.next()){
            String id=rs.getString("con_id");
            String name=rs.getString("name");
            System.out.print("con_id："+id+"; ");
            System.out.println("con_name："+name+"; ");
        }
    }
}
