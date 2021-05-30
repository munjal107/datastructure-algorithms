//https://www.codechef.com/problems/PROXYC

//import java.io.*;
import java.util.*;
class ChefProxy1  {
	public static void main(String[] args)  {
		
		String s;
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		System.out.println(t);

			

			for(int j=0;j<t;j++){
				t--;
				int d = sc.nextInt();
				sc.nextLine();
				s = sc.nextLine();
				System.out.println(d+"   "+s);
				char[] c = s.toCharArray();
		int p=0,a=0;
		
		for(char cmp:c){
			if(cmp == 'P')
				p++;
			else
				a++;
		}
		int per = p*100/d;
		int minCount = (int) Math.ceil(0.75*d);
		int reqCount =  minCount-p;
		int count =0;

		if(!chkCount(count,reqCount)){
			System.out.println("-1");
			
		}
			}

		}
		
	public static boolean chkCount(int count,int reqCount){
		return (count>=reqCount)?true:false;
	}
}