package com.jdk2010.base.security.login.controller;

import org.springframework.stereotype.Service;

@Service
public class CodeHolder {
	
	private final ThreadLocal<String> codeHolder = new ThreadLocal<String>();

	public void setCodeHolder(String code) {
		codeHolder.set(code);
	}

	public String getCodeHolder() {
		return codeHolder.get();
	}
}
