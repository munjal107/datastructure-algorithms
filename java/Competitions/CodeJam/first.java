import java.util.*;

class first{
	static void cll(int[][] a,int i){
			for(int j=0;j<5;j++){
				a[i][j]=10;
		}
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[][] a=new int[2][];
		for(int i=0;i<2;i++){
			a[i]=new int[5];
			for(int j=0;j<5;j++){
				a[i][j]=j;
			}
		}
		for(int i=0;i<2;i++){
			System.out.println(a[i].length);
			for(int j=0;j<5;j++){
			System.out.print(a[i][j]);

			}
			System.out.println();
		}

		cll(a,1);
		System.out.println();
		for(int i=0;i<2;i++){
			for(int j=0;j<5;j++){
			System.out.print(a[i][j]);

			}
			System.out.println();
		}
		/*boolean done=false;
		if(!false){
			System.out.println("HELLO");
		}
		int i;
		int j;
		String str;
		str=sc.nextLine();
		System.out.println(str);
		char[] c= str.toCharArray();
		c[0]='q';
		str=new String(c);
		System.out.println(str);

		i=sc.nextInt();
		j=sc.nextInt();
		System.out.println(i + " "+j);

		/*String str;
		int j;
		String str1;
		i = sc.nextInt();
		str = sc.nextLine().trim();
		
		j = sc.nextInt();
		str1 = sc.nextLine().trim();

		System.out.println("\n"+j+ " "+str1);
		System.out.println(str1.charAt(0));
		System.out.println(str1.length());

		System.out.println(i + " "+str);
	*/
	}
}