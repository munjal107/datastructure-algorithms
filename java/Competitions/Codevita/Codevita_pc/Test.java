//import java.util.*;

class Test{
	public static void main(String[] args) {
		String str="MUNJAL";
		char[] arr = str.toCharArray();
		String s1 = new String(arr);
		System.out.println(s1);
		int a=53;
		int c=0;
		while(a>0){
			if(a%2==1){
				c++;
			}
			a=a/2;
		}
		System.out.println(c);
	}
}