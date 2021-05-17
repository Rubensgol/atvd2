package Util;
import java.security.MessageDigest;

public class Incriptacao
{
	public static String transforma(String senha)
		{
			
			byte[] result=null;
			MessageDigest alo=null;
			try 
			{
			 alo= MessageDigest.getInstance("SHA-1");
				
			result	 = alo.digest(senha.getBytes("UTF-8"));
			
			} catch (Exception e)
			{

			}
		   
			 StringBuilder hexString = new StringBuilder();
	         for (byte b : result) {
	           hexString.append(String.format("%02X", 0xFF & b));
	         }
	         String senhahex = hexString.toString();
	         return senhahex;
		      
		}			
	
}
