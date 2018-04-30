package theway;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import base.sql.MySQLBase;

public class Theway {
	public static void regist(String name,String password) throws Exception  {
		MySQLBase mbs = new MySQLBase();
		Connection con1 = mbs.linking();
		
		String sql = "insert into user(username,password)values(?,?)";
		PreparedStatement ps = con1.prepareCall(sql);
		ps.setString(1,name);
		ps.setString(2, password);
		ps.execute();
		
		ps.close();
		con1.close();
	}
	public static boolean login(String username,String password) throws Exception  {
		MySQLBase mbs = new MySQLBase();
		Connection con1 = mbs.linking();
		System.out.println("���������û���");
		String sql = "select password from user where username =?";
		PreparedStatement ps = con1.prepareCall(sql);
		ps.setString(1,username);
		ResultSet rs = ps.executeQuery();
		System.out.println("��ȡ���뼯��");
		while(rs.next()) {
			System.out.println("��ʼ�жϻ�ȡ����");
			System.out.println("���ݿ��л�ȡ�����룺"+rs.getString(1));
			if(rs.getString(1).equals(password)) {
				rs.close();
				ps.close();
				con1.close();
				System.out.println("��ȡ����ɹ�");
				return true;
			}
			else{
				System.out.println("�û���������룺"+password);
				rs.close();
				ps.close();
				con1.close();
				System.out.println("��ȡ����ʧ��");
				return false;
			}
		}
		return true;

	}
	public static ResultSet getall(String name) throws Exception {
		MySQLBase mbs = new MySQLBase();
		Connection con1 = mbs.linking();
		String sql = "select * from user where username = ?";		
		PreparedStatement ps = con1.prepareCall(sql);
		ps.setString(1,name);
		
		ResultSet rs = ps.executeQuery();
		return rs;
	}
}
