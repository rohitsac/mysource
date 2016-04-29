package jdbc;

import java.sql.*;
import java.util.Scanner;

import jdbc.JDBCUtil;

public class Lab13 {
	public static void main(String[] args) {
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet re = null;
		try{
			con = JDBCUtil.getMySqlConnection();
			Scanner sc = new Scanner(System.in);
			System.out.println("enter query ");
			String sql = sc.nextLine();
			ps = con.prepareStatement(sql);
			boolean b = ps.execute();
			
			if(b){
				re = ps.getResultSet();
				if(re.next()){
					do{
						int sid = re.getInt(1);
						String nm = re.getString(2);
						String em = re.getString(3);
						long ph = re.getLong(4);
						System.out.println(sid+"\t"+nm+"\t"+em+"\t"+ph);
					}while(re.next());
				}else{
					int x = ps.getUpdateCount();
					System.out.println("result : "+x);
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			JDBCUtil.cleanUp(re, ps, con);
		}
	}
}
