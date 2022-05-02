package com.day10;

public class H {

	public static void main(String[] args) {
		int i = 0 , j = 1;
		if((i++ == 0) | (j++ == 2)) { //i=1,j=2 //0==0 or 1==2
			i = 42;
		} //만약 ||라면 i=42,j=1
		System.out.println("i="+ i + ",j= " + j);
	}

}
