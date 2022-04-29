package modelo;

import java.security.NoSuchAlgorithmException;

public interface ControladorDatos {

	
	public static String getHash(String txt, String hashType) {
		try {
			java.security.MessageDigest md = java.security.MessageDigest.getInstance(hashType);

			byte[] array = md.digest(txt.getBytes());
			StringBuffer sb = new StringBuffer();

			for (int i = 0; i < array.length; i++) {
				sb.append(Integer.toHexString((array[i] & 0xFF) | 0x100).substring(1, 3));
			}
			return sb.toString();

		} catch (java.security.NoSuchProviderException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		return null;
	}

}
