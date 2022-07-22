package com.mvc.step1;

public class ActionForward {
	// 변수를 private로 설정해 캡슐레이션
	private String 	path 		= null;
	// true: sendRedirect, false: forward로 페이지 이동처리
	private boolean isRedirect 	= false;
	
	// getter와 setter
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public boolean isRedirect() {
		return isRedirect;
	}
	public void setRedirect(boolean isRedirect) {
		this.isRedirect = isRedirect;
	} 
	
}
