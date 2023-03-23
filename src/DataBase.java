import java.sql.*;

public abstract class DataBase {
    public static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    public static final String URLS = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
    public static final String USER = "HR";     //사용자명-본인의 것으로 변경해주세요
    public static final String PWD = "HR";      //비빌번호-본인의 것으로 변경해주세요
    private boolean isD = true;
    private boolean isS = true;

    public DataBase() {
        init(); //드라이버 로딩 1/6
    }//

    private void init() {
        try {
            Class.forName(DRIVER);
            log("1/6 Driver Loading Success!!!");
        } catch (ClassNotFoundException e) {
            log("1/6 Driver Loading Fail!!!");
        } //
    }

    //------------JDBC 2/6, 6/6
    //DB Connection JDBC 2/6
    public Connection getConnection() throws SQLException {
        Connection conn = null;
        conn = DriverManager.getConnection(URLS, USER, PWD);

        log("2/6 Connection Success!!!");
        return conn;
    }

    //DB Close JDBC 6/6
    public void close(Connection conn, Statement stmt, ResultSet rs) {
        if(rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                System.out.println("SQL Error : 40");
            }
        }//

        if(stmt != null) {
            try {
                conn.close();
                log("6/6 Close Success!!!");
            } catch (SQLException e) {
                log("6/6 Close Fail: ", e);
            }
        }
    }

    //-----------log
    //정상 로그

    public void log(String msg) {
        if(isD) {
            System.out.println(this.getClass() + " : " + msg);
        }
    }

    //예외용 로그
    public void log(String msg, Exception e) {
        if(isD) {
            System.out.println(this.getClass() + " : " + msg);
            System.out.println("============> " + e);
        }
    }
}