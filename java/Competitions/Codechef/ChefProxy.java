//https://www.codechef.com/problems/PROXYC

import java.io.*;

class ChefProxy  {
	public static void main(String[] args) throws IOException {
		
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        	int t = Integer.parseInt(br.readLine());

			for(int j=0;j<t;j++){

				int d = Integer.parseInt(br.readLine());
				
				String s = br.readLine();

				//solve(d,s);
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

		for(int i=0;i<d;i++){
			
			if(i==0){
				if(c[0]=='A')
					count++;
				if(c[1]=='A')
					count++;
				if(c[d-1]=='A')
					count++;
				if(c[d-2]=='A')
					count++;
				if(chkCount(count,reqCount)){
					System.out.println(reqCount);
					break;
				}
			}
		
			if(i>1 && i<d-2 && c[i]=='A' && (c[i-1]=='P'||c[i-2]=='P')  && (c[i+1]=='P' || c[i+2]=='P')){
				count++;
				if(chkCount(count,reqCount)){
					System.out.println(reqCount);
					break;
				}
			}
			

		}
		if(!chkCount(count,reqCount)){
			System.out.println("-1");
			
		}
				
			}

	
		

	}

	public static boolean chkCount(int count,int reqCount){
		return (count>=reqCount)?true:false;
	}
}

/*


6
9
PAAPPAPPP
9
PAAPPAPPP
9
PAAPPAPPP
9
PAAPPAPPP
9
PAAPPAPPP
9
PAAPPAPPP

*/