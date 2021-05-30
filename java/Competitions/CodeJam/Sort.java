import java.util.*;

class Sort{

	static void result(int[][] a,int i){
		boolean done=false;
		while(!done){
			done=true;
			for(int k=0;k<a[i].length-2;k++){
				if(a[i][k]>a[i][k+2]){
					done=false;
					int	temp=a[i][k];
					a[i][k]=a[i][k+2];
					a[i][k+2]=temp;
				}
			}
		}
	}

	public static void main(String[] args) {
		int test;
		Scanner sc = new Scanner(System.in);
		test=sc.nextInt();
		int[] n =new int[test];
		int[][] a=new int[test][];
		for(int i=0;i<test;i++){
			n[i]=sc.nextInt();
			a[i] =new int[n[i]];

			for(int j=0;j<n[i];j++){
				a[i][j]=sc.nextInt();
			}

		}
		for(int i=0;i<test;i++){
			result(a,i);
			
			int y=0;

			for(int j=0;j<a[i].length-1;j++){
				if(a[i][j]>a[i][j+1]){
					System.out.println("Case #"+(i+1)+": "+j);
					y=1;
					break;
				}
			}
			if(y!=1){
				System.out.println("Case #"+(i+1)+": OK");
			}
		}
		

	}	
}