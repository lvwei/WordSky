package com.eece496.webapp.serviceimpl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.inject.Named;

import com.eece496.webapp.pojo.User;
import com.eece496.webapp.service.Sha1HashService;

@Named
public class Sha1HashServiceImpl implements Sha1HashService {
	
	private static final String HASH_SALT = "EECE496Project";

	@Override
	public void hashPassword(User user) {
		if(!user.isPasswordHashed()){
			String hashedPassword;
			try {
				hashedPassword = this.sha1(user.getPassword());
				user.setHashedPassword(hashedPassword);
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	@Override
	public String sha1(String input) throws NoSuchAlgorithmException {
		String str = input + HASH_SALT;
		MessageDigest mDigest = MessageDigest.getInstance("SHA1");
		byte[] result = mDigest.digest(str.getBytes());
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < result.length; i++) {
			sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16)
					.substring(1));
		}
		return sb.toString();
	}

}
