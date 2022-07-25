package com.mvc.step1;

public class Pattern {

	public static void main(String[] args) {
		String uri 		= "/pay/payManager.gym";
		String uri2 	= "/dev_web/pay/payManager.gym";
		String context 	= "";
		String context2 = "dev_web/";
		String command 	= uri.substring(context.length()+1); //1부터 그 뒤에가 잘린다
		// . 을 기준으로 뒤에는 자를 거임
		int end = command.lastIndexOf(".");
		command = command.substring(0, end);
		String upmu[] = null;
		// upmu에다가 /을 기준으로 잘라서 문자열 배열에 넣어주세요.
		upmu = command.split("/");
		// pay: 업무이름 - CRUD공통사항
		// 메소드이름 - 다르게 처리
		for(String imsi: upmu) {
			System.out.println(imsi); // pay, payManager가 출력될 것임
		}
	}

}
