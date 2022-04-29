package com.day9;
 class A1 {
 public A1(String msg) {
 System.out.println(msg);
 }
 }
 class B1 extends A1 {
 public B1(String msg) {}
 }
 public class OCJP_q4 {
	 static class B1 extends A1 {
		 public B1(String msg) {
			 System.out.println(msg + " from inner");
		 }
 
	 }
 
	 public static void main(String args[]) {
		 A1 a = new B1("hello");
	 }
 
}