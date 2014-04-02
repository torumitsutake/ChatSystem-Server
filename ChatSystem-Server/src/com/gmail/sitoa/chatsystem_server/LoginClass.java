package com.gmail.sitoa.chatsystem_server;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class LoginClass {
	static Connection con ;
	public  void connectdb(String databasename) throws ClassNotFoundException, SQLException{
		Class.forName(org.apache.derby.jdbc.EmbeddedDriver.class.getCanonicalName());
		System.out.println("ドライバ読み込み OK!");
		Properties prop = new Properties();
		prop.put("user", "toru");
		prop.put("password", "toru1997");
		prop.put("create", "true");

        con = DriverManager.getConnection("jdbc:derby:"+databasename,prop);
        System.out.println("接続ＯＫ");

	}
	 public  void disconnectDB(){
         if( con != null ) {
                 //普通の接続のクローズ処理
                 try {   con.close();    }
                 catch(SQLException e){  e.printStackTrace();    }
                 con = null;

                 //DB全体を停止する処理
                 try {
                         DriverManager.getConnection("jdbc:derby:;shutdown=true");
                 } catch(SQLException e) {
                         //しっかりと終了できた場合、XJ015という例外が発せられるのでそれを確認する。
                         if( e.getSQLState().equals("XJ015") ) {
                                 System.out.println("DBのシャットダウンが完了しました。");
                         } else {
                                 //XJ015以外は普通の例外なので、とりあえずprintStacTraceする。
                                 e.printStackTrace();
                         }
                 }
         }
         System.out.println("開放処理終了");
 }
	 public void setquery(String cmd) throws SQLException{
		 Statement data = null;
			data = con.createStatement();
			try {
				data.execute(cmd);
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
	 }
	 public ResultSet  responsquery(String cmd) throws SQLException{
		 Statement data = null;
			ResultSet res = null;
			data = con.createStatement();
			try {
				res = data.executeQuery(cmd);
			} catch (SQLException e) {
				// TODO 自動生成された catch ブロック
				e.printStackTrace();
			}
			return res;
	 }
}
