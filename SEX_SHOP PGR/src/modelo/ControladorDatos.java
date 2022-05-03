package modelo;

import java.security.NoSuchAlgorithmException;

public interface ControladorDatos {

	
	//RECOGEMOS EL HASH
	public static String getHash(String txt, String hashType) {
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance(hashType);

			byte[] array = md.digest(txt.getBytes());
			StringBuffer sb = new StringBuffer();

			for (int i = 0; i < array.length; i++) {
				sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
			}
			return sb.toString();

		} catch (java.security.NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return null;
	}
	
	
	public static String md5(String txt) {
		return ControladorDatos.getHash(txt, "MD5");
		
	}
	
	public static String sha1(String txt) {
		return ControladorDatos.getHash(txt, "SHA1");
				
	}

}
