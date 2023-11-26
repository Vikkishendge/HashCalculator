package hashing;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HashingAlgorithms {
	public static String md5(StringBuilder name) throws NoSuchAlgorithmException {
		String hashtext;
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] mass = md.digest(name.toString().getBytes());

		// convert byte array into biginteger representation
		BigInteger num = new BigInteger(1, mass);

		hashtext = num.toString();
		while (hashtext.length() < 32) {
			hashtext = "0" + hashtext;
		}
		return hashtext;
	}

	public static String md2(StringBuilder name) throws NoSuchAlgorithmException {
		String hashtext;
		MessageDigest md = MessageDigest.getInstance("MD2");
		byte[] mass = md.digest(name.toString().getBytes());

		// convert byte array into biginteger representation
		BigInteger num = new BigInteger(1, mass);

		hashtext = num.toString();
		while (hashtext.length() < 32) // 32 byte
		{
			hashtext = "0" + hashtext;
		}
		return hashtext;
	}

	public static String sha256(StringBuilder name) throws NoSuchAlgorithmException {
		String hashtext;
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		byte[] mass = md.digest(name.toString().getBytes());

		// convert byte array into biginteger representation
		BigInteger num = new BigInteger(1, mass);

		hashtext = num.toString();
		while (hashtext.length() < 64) // 64 byte
		{
			hashtext = "0" + hashtext;
		}
		return hashtext;
	}

	public static String sha512(StringBuilder name) throws NoSuchAlgorithmException {
		String hashtext;
		MessageDigest md = MessageDigest.getInstance("SHA-512");
		byte[] mass = md.digest(name.toString().getBytes());

		// convert byte array into biginteger representation
		BigInteger num = new BigInteger(1, mass);

		hashtext = num.toString();
		while (hashtext.length() < 128) // 128 byte
		{
			hashtext = "0" + hashtext;
		}
		return hashtext;
	}

	public static String sha224(StringBuilder name) throws NoSuchAlgorithmException {
		String hashtext;
		MessageDigest md = MessageDigest.getInstance("SHA-224");
		byte[] mass = md.digest(name.toString().getBytes());

		// convert byte array into biginteger representation
		BigInteger num = new BigInteger(1, mass);

		hashtext = num.toString();
		while (hashtext.length() < 32) // 32 byte
		{
			hashtext = "0" + hashtext;
		}
		return hashtext;
	}

	public static String sha1(StringBuilder name) throws NoSuchAlgorithmException {
		String hashtext;
		MessageDigest md = MessageDigest.getInstance("SHA-1");
		byte[] mass = md.digest(name.toString().getBytes());

		// convert byte array into biginteger representation
		BigInteger num = new BigInteger(1, mass);

		hashtext = num.toString();
		while (hashtext.length() < 32) // 32 byte
		{
			hashtext = "0" + hashtext;
		}
		return hashtext;
	}
}
