import java.util.Scanner;

class BrideHunting {
    public static void main(String[] args) {
        //BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Scanner sc = new Scanner(System.in);
        int n =sc.nextInt();
        int m = sc.nextInt();
        int in[][] = new int[n+2][m+2];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                in[i][j]=sc.nextInt();
            }
        }
        solve(n,m,in);
    }
    static void solve(int n,int m,int[][] in){
       // boolean chk = true;
        int count[][] = new int[n+2][m+2];
        int max=0;
        if(in[1][1]!=1){
            System.out.print("No suitable girl found");
            return;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(i==1 && j==1)
                    continue;
                if(in[i][j]==1){
                    //chk=false;
                    for(int k=i-1;k<=i+1;k++){
                        for(int l=j-1;l<=j+1;l++){
                            if( (k==1 && l==1) || (k==i && l==j) )
                                continue;
                            if(in[k][l]==1)
                                count[i][j]++;

                        }
                    }
                }
                max = (max>count[i][j])?max:count[i][j];
            }
        }
        //System.out.println(max);
        if(max==0){
            System.out.print("No suitable girl found");
            return;
        }
        long dist=0;
        int num=0;
        long dmin=Integer.MAX_VALUE;
        StringBuilder sb = new StringBuilder("");
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(count[i][j]==max){
                    //System.out.println(max);
                    dist = getDist(i,j);
                    //System.out.println(dist);
                    dmin = (dmin>dist)?dist:dmin;
                }
            }
        }
        int ans=0;
        //System.out.println(dmin);
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(count[i][j]==max && getDist(i,j)==dmin){
                    ans++;
                    if(ans>1){
                        System.out.print("Polygamy not allowed");
                        return;
                    }
                    sb.append(i+":"+j+":"+count[i][j]);
                }
            }
        }
        System.out.print(sb.toString());
    }
    static long getDist(int a,int b){
        a=(a-1)*(a-1);
        b=(b-1)*(b-1);
        return (long) Math.sqrt(a+b);
       //return (int)(a+b-2);
    }
}


/*  Test Case

2 9
1 0 1 1 0 1 1 1 1
0 0 0 1 0 1 0 0 1

Output:
1:7:3

6 6
1 0 0 0 0 0
0 0 0 0 0 0
0 0 1 1 1 0
0 0 1 1 1 0
0 0 1 1 1 0
0 0 0 0 0 0

 */
/* Bride Hunting
Sam is an eligible bachelor. He decides to settle down in life and start a family. He goes bride hunting.

He wants to marry a girl who has at least one of the 8 qualities mentioned below:-

1) The girl should be rich.

2) The girl should be an Engineer/Doctor.

3) The girl should be beautiful.

4) The girl should be of height 5.3".

5) The girl should be working in an MNC.

6) The girl should be extrovert.

7) The girl should not have spectacles.

8) The girl should be kind and honest.

He is in search of a bride who has some or all the 8 qualities mentioned above. On bride hunting, he may find more than one contenders to be his wife.

In that case, he wants to choose a girl whose house is closest to his house. Find a bride for Sam who has maximum qualities. If in case, there are more than one contenders who are at equal distance from Sam’'s house; then

print "“Polygamy not allowed”".

In case there is no suitable girl who fits the criteria then print “"No suitable girl found"”

Given a Matrix N*M, Sam's house is at (1, 1). It is denoted by 1. In the same matrix, the location of a marriageable Girl is also denoted by 1. Hence 1 at location (1, 1) should not be considered as location of a marriageable Girl’s location.

The qualities of that girl, as per Sam’'s criteria, have to be decoded from the number of non-zero neighbours (max 8-way) she has. Similar to condition above, 1 at location (1, 1) should not be considered as the quality of a Girl. See Example section to get a better understanding.

Find Sam, a suitable Bride and print the row and column of the bride, and find out the number of qualities that the Bride possesses.

NOTE: - Distance is calculated in number of hops in any direction i.e. (Left, Right, Up, Down and Diagonal)

Constraints
2 <= N,M <= 10^2

Input Format
First Line contains the row (N) and column (M) of the houses.

Next N lines contain the data about girls and their qualities.

Output
It will contain the row and column of the bride, and the number of qualities that Bride possess separated by a colon (i.e. :).


Explanation
Example 1

Input:

2 9

1 0 1 1 0 1 1 1 1

0 0 0 1 0 1 0 0 1

Output:

1:7:3

Explanation:

The girl and qualities are present at (1,3),(1,4),(1,6),(1,7),(1,8),(1,9),(2,4),(2,6),(2,9).

The girl present at (1,3) has 2 qualities (i.e. (1,4)and (2,4)).

The girl present at (1,4) has 2 qualities.

The Bride present at (1,6) has 2 qualities.

The Bride present at (1,7) has 3 qualities.

The Bride present at (1,8) has 3 qualities.

The Bride present at (1,9) has 2 qualities.

The Bride present at (2,4) has 2 qualities.

The Bride present at (2,6) has 2 qualities.

The Bride present at (2,9) has 2 qualities.

As we see, there are two contenders who have maximum qualities, one is at (1,7) and another at (1,8).

The girl who is closest to Sam's house is at (1,7). Hence, she is the bride.

Hence, the output will be 1:7:3.

Example 2

Input:

6 6

1 0 0 0 0 0

0 0 0 0 0 0

0 0 1 1 1 0

0 0 1 1 1 0

0 0 1 1 1 0

0 0 0 0 0 0

Output:

4:4:8

Explanation:

The bride and qualities are present at (3,3),(3,4),(3,5),(4,3),(4,4),(4,5),(5,3),(5,4),(5,5)

The Bride present at (3,3) has 3 qualities (i.e. (3,4),(4,3) and (4,4)).

The Bride present at (3,4) has 5 qualities.

The Bride present at (3,5) has 3 qualities.

The Bride present at (4,3) has 5 qualities.

The Bride present at (4,4) has 8 qualities.

The Bride present at (4,5) has 5 qualities.

The Bride present at (5,3) has 3 qualities.

The Bride present at (5,4) has 5 qualities.

The Bride present at (5,5) has 3 qualities.

As we see, the girl present in (4,4) has maximum number of Qualities. Hence, she is the bride.

Hence, the output will be 4:4:8.
*/