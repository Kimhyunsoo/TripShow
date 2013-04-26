package kr.ac.mju.capstone.tripshow.crypto;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import kr.ac.mju.capstone.tripshow.constants.TSConstants;

public class CryptoManager {
	public static Key generateKey(String algorithm, byte[] keyData) {
		SecretKeySpec keySpec = new SecretKeySpec(keyData, algorithm);
		return keySpec;
	}

	public static String Encrypt(String src) throws Exception {
		Key key = generateKey("AES", toBytes(TSConstants.CRYPTO_SEED_KEY, 16));
		String transformation = "AES";
		Cipher cipher = Cipher.getInstance(transformation);
		cipher.init(Cipher.ENCRYPT_MODE, key);
		byte[] plain = src.getBytes();
		byte[] encrypt = cipher.doFinal(plain);
		return toHexString(encrypt);
	}

	public static String Decrypt(String hex) throws Exception {
		Key key = generateKey("AES", toBytes(TSConstants.CRYPTO_SEED_KEY, 16));
		String transformation = "AES";
		Cipher cipher = Cipher.getInstance(transformation);
		cipher.init(Cipher.DECRYPT_MODE, key);
		byte[] encrypt = toBytesFromHexString(hex);
		byte[] decrypt = cipher.doFinal(encrypt);
		return new String(decrypt);
	}

	public static byte[] toBytes(String digits, int radix)
			throws IllegalArgumentException, NumberFormatException {
		if (digits == null) {
			return null;
		}
		if (radix != 16 && radix != 10 && radix != 8) {
			throw new IllegalArgumentException("For input radix: \"" + radix
					+ "\"");
		}
		int divLen = (radix == 16) ? 2 : 3;
		int length = digits.length();
		if (length % divLen == 1) {
			throw new IllegalArgumentException("For input string: \"" + digits
					+ "\"");
		}
		length = length / divLen;
		byte[] bytes = new byte[length];
		for (int i = 0; i < length; i++) {
			int index = i * divLen;
			bytes[i] = (byte) (Short.parseShort(
					digits.substring(index, index + divLen), radix));
		}
		return bytes;
	}

	public static byte[] toBytesFromHexString(String digits)
			throws IllegalArgumentException, NumberFormatException {
		if (digits == null) {
			return null;
		}
		int length = digits.length();
		if (length % 2 == 1) {
			throw new IllegalArgumentException("For input string: \"" + digits
					+ "\"");
		}
		length = length / 2;
		byte[] bytes = new byte[length];
		for (int i = 0; i < length; i++) {
			int index = i * 2;
			bytes[i] = (byte) (Short.parseShort(
					digits.substring(index, index + 2), 16));
		}
		return bytes;
	}

	public static String toHexString(byte[] bytes) {
		if (bytes == null) {
			return null;
		}

		StringBuffer result = new StringBuffer();
		for (byte b : bytes) {
			result.append(Integer.toString((b & 0xF0) >> 4, 16));
			result.append(Integer.toString(b & 0x0F, 16));
		}
		return result.toString();
	}
}
