package base.sql;
import java.sql.Connection;
import java.sql.DriverManager;
/**
 * ���÷���linking()<P/>
 * �������Ӷ���Connection con1<P/>
 * ����ʱҪ�����쳣
 */
public class MySQLBase {
	public Connection linking() throws Exception {
		long start = System.currentTimeMillis();
		Class.forName("com.mysql.jdbc.Driver");
		System.out.println("JDBC-ODBC���ӳɹ�");
		Connection con1 = DriverManager.getConnection
					("jdbc:mysql://localhost:3306/facedb?useSSL=false", "root", "123456");
		long end = System.currentTimeMillis();
		System.out.println("�ɹ��������ݿ�");
		System.out.println("�������Ӻ�ʱ��"+(end - start)+"ms");
		return con1;
	}
}
