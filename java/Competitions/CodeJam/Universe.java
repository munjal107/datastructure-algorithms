import java.util.*;

class Universe {
	static int global=0,imp=0;
	static boolean getResult(int strength,String prog,int hacks,int i){
		int damage=0;int power=1;
		for(int j=0;j<prog.length();j++){
			if(prog.charAt(j)=='S'){
				damage=damage+power;
			}
			else {
				power=2*power;
			}
		}
		if(damage<=strength && global==0){
			System.out.println("Case #"+i+": "+hacks);
			global=1;
			imp=1;
			return true;
		}
		else {
			return false;
		}
	}

	static void result(int strength,String prog,int i,int hacks){
		boolean done=getResult(strength,prog,hacks,i);
		
		if(!done){
			for(int j=prog.length()-1;j>0;j--){
				if(prog.charAt(j)=='S' && prog.charAt(j-1)=='C'){
					char[] c= prog.toCharArray();
					c[j]='C';
					c[j-1]='S';
					hacks=hacks+1;
					prog=new String(c);
					done=getResult(strength,prog,hacks,i);
					if(done){
						return ;//hacks;
					}
					else{
						result(strength,prog,i,hacks);
					}		
				}	
			}
			if(imp==0){
			System.out.println("Case #"+i+": IMPOSSIBLE");
			imp=1;
			}
		}
		else{
			return;
		}
		
	}

	public static void main(String[] args) {
		int test;
		Scanner sc = new Scanner(System.in);
		test = sc.nextInt();
		int shield;
		String str;
		for(int i=0;i<test;i++){
			shield=sc.nextInt();
			str=sc.nextLine();
			global=0;imp=0;
			
			str=str.trim();
			result(shield,str,(i+1),0);
		}
	}

}