import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class MovieSequence {
    static int[][] sum = new int[4][4];
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] movie = br.readLine().split(" ");
        String[] cat = br.readLine().split(" ");
        String[] pro = br.readLine().split(" ");
        StringBuilder out = new StringBuilder("");
        int[] profit = new int[pro.length];
        for(int i=0;i<pro.length;i++)
            profit[i]=Integer.parseInt(pro[i]);
        int aud = Integer.parseInt(br.readLine());
        int[] age = new int[aud];
        String[] ag = br.readLine().split(" ");
        for(int i=0;i<aud;i++)
            age[i]=Integer.parseInt(ag[i]);
        for(int i=0;i<4;i++){
            if(cat[i].equals("A")){
                getA(profit,age,i);
            }
            else if(cat[i].equals("B")){
                getB(profit,age,i);
            }
            else if(cat[i].equals("C")){
                getC(profit,age,i);
            }
            else if(cat[i].equals("D")){
                getD(profit,age,i);
            }
        }

        int max=0,total=0;
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(j!=i){
                    for(int k=0;k<4;k++){
                        if(k!=i && k!=j){
                            for(int l=0;l<4;l++){
                                if(l!=i && l!=j && l!=k){
                                    total = sum[0][i]+sum[1][j]+sum[2][k]+sum[3][l];
                                    max = (total>max)?total:max;
                                }

                            }
                        }
                    }
                }
            }
        }
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                if(j!=i){
                    for(int k=0;k<4;k++){
                        if(k!=i && k!=j){
                            for(int l=0;l<4;l++){
                                if(l!=i && l!=j && l!=k){
                                    total = sum[0][i]+sum[1][j]+sum[2][k]+sum[3][l];
                                    if(total==max){
                                        for(int m=0;m<4;m++){
                                            if(m==i)
                                                out.append(0);
                                            else if(m==j)
                                                out.append(1);
                                            else if(m==k)
                                                out.append(2);
                                            else
                                                out.append(3);
                                        }
                                        out.append(" ");
                                    }
                                }

                            }
                        }
                    }
                }
            }
        }
        String result[] = out.toString().split(" ");
        int[] arr = new int[result.length];
        /* for(int i=0;i<result.length;i++)
            arr[i]=Integer.parseInt(result[i]);
        Arrays.sort(arr);*/
        Arrays.sort(result);

        String st="";
        for(int i=0;i<result.length;i++) {
            for (int j = 0; j < 4; j++) {
                st = Character.toString(result[i].charAt(j));
                System.out.print(movie[Integer.parseInt(st)] + " ");
            }
            System.out.println();
        }
            System.out.print("Maximum Profit: "+max);
    }
    static void getA(int[] profit,int[] age,int i){

        for(int j=0;j<age.length;j++){
            int n = age[j];
            if(isA(n)){
                if(isMor(n)){
                    sum[i][0]+=profit[i];
                }
                if(isAfter(n)){
                    sum[i][1]+=profit[i];
                }
                if(isEve(n)){
                    sum[i][2]+=profit[i];
                }
                if(isNight(n)){
                    sum[i][3]+=profit[i];
                }
            }

        }
    }
    static void getB(int[] profit,int[] age,int i){


        for(int j=0;j<age.length;j++){
            int n = age[j];
            if(isB(n)){
                if(isMor(n)){
                    sum[i][0]+=profit[i];
                }
                if(isAfter(n)){
                    sum[i][1]+=profit[i];
                }
                if(isEve(n)){
                    sum[i][2]+=profit[i];
                }
                if(isNight(n)){
                    sum[i][3]+=profit[i];
                }
            }

        }
    }
    static void getC(int[] profit,int[] age,int i){


        for(int j=0;j<age.length;j++){
            int n = age[j];
            if(isC(n)){
                if(isMor(n)){
                    sum[i][0]+=profit[i];
                }
                if(isAfter(n)){
                    sum[i][1]+=profit[i];
                }
                if(isEve(n)){
                    sum[i][2]+=profit[i];
                }
                if(isNight(n)){
                    sum[i][3]+=profit[i];
                }
            }

        }
    }
    static void getD(int[] profit,int[] age,int i){


        for(int j=0;j<age.length;j++){
            int n = age[j];
            if(isD(n)){
                if(isMor(n)){
                    sum[i][0]+=profit[i];
                }
                if(isAfter(n)){
                    sum[i][1]+=profit[i];
                }
                if(isEve(n)){
                    sum[i][2]+=profit[i];
                }
                if(isNight(n)){
                    sum[i][3]+=profit[i];
                }
            }

        }
    }
    static boolean isMor(int age){
        return (age>=3 && age<=20)?false:true;
    }
    static boolean isAfter(int age){
        return (age>=21 && age<=40)?false:true;
    }
    static boolean isEve(int age){
        return (age>=41 && age<=49)?false:true;
    }
    static boolean isNight(int age){
        return (age>=50 && age<=70)?false:true;
    }
    static boolean isA(int age){
        return (age>=24 && age<=50)?true:false;
    }
    static boolean isB(int age){
        return (age>=15 && age<=25)?true:false;
    }
    static boolean isC(int age){
        return (age>=3 && age<=18)?true:false;
    }
    static boolean isD(int age){
        return (age>=45 && age<=70)?true:false;
    }
}
/*test cases


Movie1 Movie2 Movie3 Movie4
A B D C
10 20 15 5
11
23 43 6 7 1 0 45 4 6 7 24

**/
/*Movie Sequence
We all like to watch movies in a theatre. Help the theatre owner to find out the sequence of movies he should play to get maximum profit.

Data provided is as follows

1. 4 Movie Names.

2. Movies have age (in years) restriction.

· 'A' grade : Age Limit : 24-50 (24 and 50 included)

· 'B' grade : Age Limit : 15-25 (15 and 25 included)

· 'C' grade : Age Limit : 3-18 (3 and 18 included)

· 'D' grade : Age Limit : 45-70 (45 and 70 included)

3. Profit of each movie ticket. Profit varies with movie.

4. There are 4 movie slots in a day, viz. { Morning, Afternoon, Evening, Night}

5. Age of all the audiences who would like to watch movie.

The theatre owner abides by following business intelligence rules accumulated over years through past experiences. These rules suggest the slots in which different categories of people will not be able to watch movie.

· People between age 3-20 (both included) will have school in the morning, so will not be able to attend morning show.

· People between age 21-40 (both included) will be at their jobs in the afternoon so will not be able to attend afternoon show.

· People between age 41-49 (both included) will not be able to watch movie in Evening show.

· People between age 50-70 (both included) will not be able to watch movie in Night show.

Given data and business intelligence rules, find the sequence of movie in respective slots so that theatre owner gets maximum profit with the constraint that one movie can be played only once in a day.

If there is only one movie sequence that earns the maximum profit then print the sequence and the maximum profit.

Ex.
 Movie1 Movie3 Movie4 Movie2
 Maximum Profit: 110
 If multiple movie sequences earn same amount of maximum profit, print the sequences in sorted order as per movie names provided in the Input.
 Also print maximum profit.

Movie sequences should be according to slots viz. {Morning Afternoon Evening Night} Ex.
 Movie1 Movie3 Movie2 Movie4
 Movie1 Movie3 Movie4 Movie2
 Movie1 Movie4 Movie2 Movie3
 Movie2 Movie3 Movie4 Movie1
 Movie3 Movie4 Movie2 Movie1
 Maximum Profit: 110

Constraints
1. One movie can be played only once in a day.

2. Movies will not have space in them.

3. 0<=Age<=100.

Input Format
1. First line contains 4 names of movies delimited by space

2. Second Line contains grade of each movie corresponding to the order in first line

3. Third Line contains profit in rupees on each movie ticket

4. Fourth Line contains number of audiences.

5. Fifth Line contains age in years of all audiences. Age is always positive integer. Number of audiences will be between 1 and 30.

Output
1. The movie sequence to be played in respective slots to get maximum profit in such a way that one movie can be played only once.

2. Maximum Profit.


Explanation
Example 1

Input

Movie1 Movie2 Movie3 Movie4
 A B D C
 10 20 15 5
 11
 23 43 6 7 1 0 45 4 6 7 24

Output


 Movie1 Movie3 Movie2 Movie4
 Movie1 Movie3 Movie4 Movie2
 Movie1 Movie4 Movie2 Movie3
 Movie2 Movie3 Movie4 Movie1
 Movie3 Movie4 Movie2 Movie1
 Maximum Profit: 110

Explanation

Decide the movie to be played in different slots such that theatre owner gets maximum profit and one movie can be played only once in a day.

1. Distribute the Audience to respective Movies as per grade age restrictions. Ex. Audience for Movie1: 23,43,45 (Movie1 is A graded with age restriction 24-50).

2. Decide which age group can watch movie in which slot based on age restriction. (Morning, Afternoon, Evening, Night) Ex. For Movie1. Morning slot: 24,43,45 Afternoon slot: 43,45 Evening slot: 24 Night slot: 43,24,45

3. Calculate the profit for each movie based on slot. For Movie1: Morning profit: 30 (3 audiences * 10 profit) Afternoon profit: 20 Evening profit: 10 Night Profit: 30

4. Perform same for all the 4 movies and decide the movie sequence to be played in respective slots to get maximum profit in such a way that one movie can be played only once.

*/