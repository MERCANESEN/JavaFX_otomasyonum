package mySQL.database;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

public class Veritabanı {
static Connection conn=null;

public static Connection Baglan() {
	try {
		conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1/otomasyon","root","");
		return conn;
	}
	catch(Exception e) {
		System.out.println(e.getMessage().toString());
		return null;
		
	}
		
	
}
public void Kapat() {
	try {
		conn.close();
	}
	catch(Exception e) {
		System.out.println(e.getMessage().toString());
	}
}

public static String MD5Sifrele(String icerik) {
	try {
		
		MessageDigest md= MessageDigest.getInstance("MD5");
		byte[] sifrelenmis= md.digest(icerik.getBytes());
		
		BigInteger no= new BigInteger(1, sifrelenmis);
		
		String hashIcerik=no.toString(16);
		while(hashIcerik.length()<32) {
			hashIcerik="0"+ hashIcerik;
			
		}
		
	return hashIcerik;
		
	}
	catch(NoSuchAlgorithmException e) {
		throw new RuntimeException(e);
		
	}	

}

}
