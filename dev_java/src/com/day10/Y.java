package com.day10;

public class Y {

	public static void main(String[] args) {
		int i = 2;
		int j = i++; 
		
		if((i == --j) && (i++ == j)) { 
			//& 일 경우 i++로 인해 i=4, &&일때는 실행안해서 i = 3
			//&하나일때는 뒤에도 따져주지만 &&일때 앞에서 t/f가 결정된다면 뒤에경우는 따지지 않는다.(시간절약)
			//실행문 진행
			i += j; //i = i + j;
		}
		System.out.println("i = " + i);
	}

}
