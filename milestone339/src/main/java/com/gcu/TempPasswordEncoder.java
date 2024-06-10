package com.gcu;

import org.springframework.security.crypto.password.PasswordEncoder;

/*
 * Project Name: CST-339 Milestone Project
 * Version: 1.5
 * Module name: Temporary Password Encoder
 * Module version: 1.0
 * Authors: Gabriel Cepleanu
 * Synopsis: This class provides a non-functional password encoder to enable authentication.
 * This class does NOT encode passwords and is simply used as a parameter to enable authentication.
 * True password encoding will be added in a future version.
 */

public class TempPasswordEncoder implements PasswordEncoder {

	@Override
	public String encode(CharSequence rawPassword) {
		return rawPassword.toString();
	}

	@Override
	public boolean matches(CharSequence rawPassword, String encodedPassword) {
		return rawPassword.toString().equals(encodedPassword);
	}

}
