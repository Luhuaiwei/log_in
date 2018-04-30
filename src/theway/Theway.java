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
		System.out.println("即将输入用户名");
		String sql = "select password from user where username =?";
		PreparedStatement ps = con1.prepareCall(sql);
		ps.setString(1,username);
		ResultSet rs = ps.executeQuery();
		System.out.println("获取密码集合");
		while(rs.next()) {
			System.out.println("开始判断获取密码");
			System.out.println("数据库中获取的密码："+rs.getString(1));
			if(rs.getString(1).equals(password)) {
				rs.close();
				ps.close();
				con1.close();
				System.out.println("获取密码成功");
				return true;
			}
			else{
				System.out.println("用户输入的密码："+password);
				rs.close();
				ps.close();
				con1.close();
				System.out.println("获取密码失败");
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
