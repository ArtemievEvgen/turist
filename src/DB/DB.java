package DB;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DB {
    private Connection cn;
    private Statement st;
    private ResultSet rs;

    public DB(String url, String nameDB, String login, String pass) throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            cn = DriverManager.getConnection(url + nameDB, login, pass);
            st = cn.createStatement();
        } catch (ClassNotFoundException e) {
            System.out.println("\nОшибка при загрузке драйвера " + e);
        }

    }

    public void update(String sql) throws SQLException {
        st.executeUpdate(sql);
    }

    public ResultSet query(String sql) throws SQLException {
        rs = st.executeQuery(sql);
        return rs;
    }

    public void showTable(ResultSet rs) throws SQLException {
        ResultSetMetaData rsmd = rs.getMetaData();

        for(int i = 1; i <= rsmd.getColumnCount(); i++) {
            System.out.print(rsmd.getColumnName(i) + "\t");
        }

        while(rs.next() == true) {
            System.out.println();
            for(int i = 1; i <= rsmd.getColumnCount(); i++) {
                System.out.print(rs.getString(i) + "\t");
            }
        }
    }


    public void close() throws SQLException {
        st.close();
        cn.close();
    }

    public Connection getCn() {
        return cn;
    }
}
