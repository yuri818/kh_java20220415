
public class K {
	public static int switchIt(int x) { //x=4
	int j = 1;
	switch(x){
	case 1 :
		 j++; //j=2
	case 2 :
		 j++;//j=3
	case 3 : 
		  j++; //j=4
	case 4 : //여기
		  j++;//j=5
		  break;
	case 5 : 
		  j++;//j=3
	default : 
		  j++;//j=4
	  }
	return j+x;
	}
	public static void main(String[] args) {
		System.out.println(switchIt(4)); 
	}

}
