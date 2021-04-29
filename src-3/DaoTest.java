import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Types;

import org.hibernate.engine.SessionFactoryImplementor;

import oracle.jdbc.OracleTypes;

public class DaoTest {
    
    String driver="oracle.jdbc.driver.OracleDriver";
    String url="jdbc:oracle:thin:@127.0.0.1:1521:ORCL";
    Connection conn=null;
    CallableStatement cs=null;//PreparedStatement,Statement
    ResultSet rs;
    
    public void getConn(){
        try {
            Class.forName(driver);
            conn = DriverManager.getConnection(url, "prodb", "123456");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void callProcForResult(){
        try {
            cs = conn.prepareCall("{call TOTAL_QUERY_PACK.QUERY_DBYWTJ(?,?,?,?)}");
            cs.registerOutParameter(3, Types.VARCHAR);
            cs.registerOutParameter(4, OracleTypes.CURSOR);
            cs.setString(1, "1991");
            cs.setString(2, "200-10-10");
            cs.execute();
            
            System.out.println("调用结果：" + cs.getString(3) + "\n====================================");
            ResultSet rs = (ResultSet)cs.getObject(4);
            ResultSetMetaData rsm = rs.getMetaData();
            int count = rsm.getColumnCount();
            while(rs!=null&& rs.next()){
            	for(int index=1;index<=count;index++){
            		System.out.print(rsm.getColumnName(index) + "=" + rs.getString(index) + "\t");
            	}
            	System.out.println();
            }
            rs.close();
            System.out.println("===========================================");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
    public void closeConn(){
        try {
            if (cs!=null) cs.close();
            if(conn!=null) conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        DaoTest dao =new DaoTest();
        
        dao.getConn(); //得到连接
        dao.callProcForResult(); //调用返回结果集的存储过程
        dao.closeConn(); //关闭连接
    }
}