package com.day18;

import java.util.StringTokenizer;

public class MessageParser {

	public static void main(String[] args) {
		String msg = "200#tomato#banana#오늘 스터디할까?"; 	//tomato님이 입장하였습니다.
		StringTokenizer st = new StringTokenizer(msg, "#"); //#을 구분자라고 생각하기
//		String protocol = st.nextToken();
//		String nickName = st.nextToken();
//		String nickName2 = st.nextToken();
//		String message = st.nextToken();
//		System.out.println(protocol);
//		System.out.println(nickName);
//		System.out.println(nickName2);
//		System.out.println(talk);
		//10~17 줄을 간단하게 코딩한것.
		while(st.hasMoreTokens()) {
			String imsi = st.nextToken();
			System.out.println(imsi);
		}
	}

}
