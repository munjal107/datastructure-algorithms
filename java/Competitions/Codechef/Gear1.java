/*You are given N gears numbered 1 through N. For each valid i, gear i has Ai teeth. In the beginning, no gear is connected to any other. Your task is to process M queries and simulate the gears' mechanism. There are three types of queries:

Type 1: Change the number of teeth of gear X to C.
Type 2: Connect two gears X and Y.
Type 3: Find the speed of rotation of gear Y if gear X rotates with speed V.
It is known that if gear i is directly connected to gear j and gear i rotates with speed V, then gear j will rotate with speed −VAi/Aj, where the sign of rotation speed denotes the direction of rotation (so minus here denotes rotation in the opposite direction). You may also notice that gears can be blocked in some cases. This happens when some gear would have to rotate in different directions. If a gear is connected to any blocked gear, it is also blocked. For example, if three gears are connected to each other, this configuration can not rotate at all, and if we connect a fourth gear to these three, it will also be blocked and not rotate.

Input
The first line of the input contains two space-separated integers N and M.
The second line contains N space-separated integers A1,A2,…,AN.
The following M lines describe queries. Each of these lines begins with an integer T denoting the type of the current query.
If T=1, it is followed by a space and two space-separated integers X and C.
If T=2, it is followed by a space and two space-separated integers X and Y.
If T=3, it is followed by a space and three space-separated integers X, Y and V.
Output
For each query of type 3, print a single line containing two integers separated by a slash '/' — the numerator and denominator of the rotation speed of the given gear expressed as an irreducible fraction (even if this speed is an integer), or 0 if the gear does not rotate at all.

Constraints
1≤N≤105
1≤M≤2⋅105
6≤Ai≤106 for each valid i
1≤X,Y≤N
1≤C,V≤106
Subtasks
Subtask #1 (30 points):

N≤2,000
M≤5,000
Subtask #2 (70 points): original constraints

Example Input
4 10
6 8 10 13
3 1 2 2
2 1 2
3 1 2 3
2 2 3
1 1 7
3 1 3 10
2 3 1
3 1 3 2
2 1 4
3 1 4 6
Example Output
0
-9/4
7/1
0
0
Explanation
For the first query of type 3, there are no connections between gears, so the answer is 0.

For the second query of type 3, we can calculate the rotation speed using the formula −3⋅68=−94.

For the third query of type 3, we can use the formula twice, so the speed of the second gear is −10⋅78=−354, and the speed of the third gear is −(−354)810=71.

For the last query of type 3, all gears are blocked*/


import java.util.*;
class Gear1 {
	public static void get()
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n=sc.nextInt();
		int m = sc.nextInt();
		int a[] = new int[n];
		int count[]=new int[n];
		for(int i=0;i<n;i++){
			a[i]=sc.nextInt();
			count[i]=0;
		}
		int t,x,y,c,v;
		for(int i=0;i<m;i++){
			t=sc.nextInt();
			if(t==1){
				x=sc.nextInt();
				c=sc.nextInt();
				x--;	/// becoz array starts from 0
				a[x]=c;
			}
			if(t==2){
				
			}
			if(t==3){

			}
		}

	}
}



