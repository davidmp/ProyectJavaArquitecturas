package pe.com.syscenterlife.utils;
/* @(#)STRCrypto.java
 * 
 * Copyright (c) 2006 Xenicia Systems, Inc., Lima-Per�. All Right Reserved.
 * Author: @ngel Sull�n Ma�alup�
 * Created: 21.SEP.2000
 * Last Modify: 30.SEP.2005
 *
 * Important:
 * Este software se proporciona sin garant�as de ning�n tipo de su funcionamiento
 * y en ning�n caso ser� el autor responsable de da�os o perjuicios que deriven
 * del mal uso o alteraci�n del programa.
 * 
 * Process:
 * En�r&pt@ un@ �@den@
 */
 
import java.security.*;
import javax.crypto.Cipher;
import javax.crypto.spec.DESedeKeySpec;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import java.security.spec.KeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Base64;




public class STRCrypto {
	
	KeySpec keySpec;
	
	public SecretKey getKeyString() {
		String keyString="ACED00057372001E636F6D2E73756E2E63727970746F2E70726F76696465722E4445534B65796B349C35DA1568980200015B00036B65797400025B427870757200025B42ACF317F8060854E00200007870000000086438D0196107EFF1";
		try{
			//byte[] keyBytes = keyString.getBytes("UTF8");
			byte[] keyBytes = keyString.getBytes(StandardCharsets.UTF_8);
			keySpec = new DESedeKeySpec( keyBytes );
			SecretKeyFactory keyFactory;
			keyFactory = SecretKeyFactory.getInstance( "DESede" );
			SecretKey key = keyFactory.generateSecret( keySpec );
			return key;
		}catch (Exception e) {
			System.out.println("could not read private key: "+e);
			return null;
		}
	}
	
	private static String bytesToString( byte[] bytes )	{
		StringBuffer stringBuffer = new StringBuffer();
		for (int i = 0; i < bytes.length; i++)
		{
			stringBuffer.append( (char) bytes[i] );
		}
		return stringBuffer.toString();
	}
	
	public String encrypt(String texto) throws Exception{
		try{
			Security.addProvider( new com.sun.crypto.provider.SunJCE() );
			Key key = getKeyString();
			Cipher cipher = Cipher.getInstance("DESede");
			cipher.init(Cipher.ENCRYPT_MODE, key);
	
			//BASE64Encoder encoder = new BASE64Encoder();
                        //String base64Encoded = Base64.getEncoder().encodeToString(bytes);
			byte[] cleartext = texto.getBytes("UTF8");
			byte[] ciphertext = cipher.doFinal(cleartext);
	
			//return encoder.encode(ciphertext).toString();
			return Base64.getEncoder().encodeToString(ciphertext);
		}catch (Exception e) {
			throw new Exception( e.getMessage() );
		}
	}

	public String decrypt(String texto) throws Exception{
		try{
			Security.addProvider( new com.sun.crypto.provider.SunJCE() );
			Key key = getKeyString();
			Cipher cipher = Cipher.getInstance("DESede");
			cipher.init(Cipher.DECRYPT_MODE, key);
			
                        //BASE64Decoder decoder = new BASE64Decoder();
                        //byte[] asBytes = Base64.getDecoder().decode(base64Encoded);
			//byte[] cleartext = decoder.decodeBuffer(texto);
			byte[] cleartext = Base64.getDecoder().decode(texto);
			byte[] ciphertext = cipher.doFinal(cleartext);
			
			return bytesToString(ciphertext);
		}catch (Exception e) {
			throw new Exception( e.getMessage() );
		}
	}

	/*public static void main(String[] args) {
		System.out.println("Sull crypto ********************************");
		STRCrypto cryp=new STRCrypto();
		try{
			
			System.out.println("ioteca_v2_db : "+cryp.encrypt("ioteca_v2_db?user=library&password=l1br@ry@"));
			System.out.println(""+cryp.decrypt("tPy5lSHtiss35Q5xRwjdY2SPOwnkfsNxOk2jtqexeOOTQwBsoWBzkSHrXlnBVGc2"));
			System.out.println(""+cryp.decrypt("LmAJembXM+g="));
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}*/
}
