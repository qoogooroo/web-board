package com.web.common;

import org.apache.commons.codec.digest.DigestUtils;

public class SHA256Util {
	private static final String SALT = "Thfxm828282!@#$r1!r2@r3#p0o9i8";
	
	public static String encode(String str) {
		return DigestUtils.sha256Hex(str + SALT);
	}
	// cons 모든 유저의 salt 값이 동일해짐
	// advance : 유저가 등록될때마다 새로운 salt 값을 부여 (여기선 일단 요것까진 안해보기로..)
}
