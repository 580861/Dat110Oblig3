package no.hvl.dat110.util;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Hash {

	private static BigInteger hashint;
	private static int mbit = 4;

	public static BigInteger hashOf(String entity) {

		// Task: Hash a given string using MD5 and return the result as a BigInteger.

		// we use MD5 with 128 bits digest

		// compute the hash of the input 'entity'

		// convert the hash into hex format

		// convert the hex into BigInteger

		// return the BigInteger

		try {
			MessageDigest m = MessageDigest.getInstance("MD5");
			byte[] entityBytes = m.digest(entity.getBytes());
			mbit = entityBytes.length;
			String hex = toHex(entityBytes);

			hashint = new BigInteger(hex, 16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return hashint;

	}

	public static BigInteger addressSize() {

		// Task: compute the address size of MD5

		// get the digest length

		// compute the number of bits = digest length * 8

		// compute the address size = 2 ^ number of bits

		// return the address size
		BigInteger addSize = new BigInteger("2");
		addSize = addSize.pow(bitSize());

		return addSize;

	}

	public static int bitSize() {

		int digestlen = 0;

		// find the digest length
		try {
			MessageDigest m = MessageDigest.getInstance("MD5");
			byte[] entityBytes = m.digest();
			mbit = entityBytes.length;
			String hex = toHex(entityBytes);

			hashint = new BigInteger(hex, 16);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		digestlen = mbit;

		return digestlen * 8;
	}

	public static String toHex(byte[] digest) {
		StringBuilder strbuilder = new StringBuilder();
		for (byte b : digest) {
			strbuilder.append(String.format("%02x", b & 0xff));
		}
		return strbuilder.toString();
	}

}
