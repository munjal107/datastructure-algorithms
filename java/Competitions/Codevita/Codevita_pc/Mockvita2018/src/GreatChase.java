import java.util.Scanner;

class GreatChase {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t =sc.nextInt();
        for(int j=0;j<t;j++){
            long i = sc.nextLong();
            long d = sc.nextLong();
            long z = sc.nextLong();
            solve(i,d,z);
        }

    }
    static void solve(long i,long d,long z){
        while(true){
            if(i%z==0)
                break;
            i=i+d;
        }
        System.out.println(i/z);
        /*long i1=i;
        long d1=z;
        int count=1;

        while(true){
            while(i1<=d1){
                if(d1==i1)
                    break;
                i1=i1+d;
            }
            if(d1==i1)
                break;
            count++;
            d1=d1+z;
        }
        System.out.println(count);*/
    }
}
/*
1
10 15 20

2
9 5 12
5 7 9


 long i1=i;
        long d1=z;
        int count=1;
while(true){
            while (d1<=i1){
                if(d1==i1)
                    break;
                d1=d1+z;
                count++;
            }
            if(d1==i1)
                break;
            i1=i1+d;
        }
        System.out.println(count);


        Welcome to the Planet Zandar, the second most prominent planet in the Milky Way Galaxy (of course after our own Earth).

The planet  is in a distress condition, a Group of Galactic pirates, Zorons have stolen the Trident Crystal, which is the main source of energy of the planet, and are escaping the Galaxy. The Nova Corps, the military agency of Zandar, have gathered intelligence that the Zoronion space craft can run in cosmic leaps of exactly D units, (it means that the space craft will move D units from its position in every leap/turn) and is currently I units away from Zandar.

The Zandarian Space crafts can run in cosmic leaps of exactly Z units. The Commander of Nova Corps wants to know the smallest number of leaps required to catch Zorons (Note that it is possible to catch the pirates only when they will be at the same point in the cosmic universe). The Zorons, even though are clever thieves, travel in one direction, and keep jumping exactly D units without stopping at any point.

The Nova Corps can dial in the number of jumps they need to make (each of them exactly Z units), and reach the place almost instantly. They can then wait there until the Zorons arrive, and recover the Trident Crystal.

However, their wizard has told them that there may be situations where it is impossible for the Nova corps to be at the same distance as the Zorons.

As the planet is out of power currently, their supercomputers are shut down and they are not able to calculate the required information. As you are there from Earth they have approached you for help.

Note: Assume that the Cosmic universe is one dimensional.

Constraints
1 <= I,D <= 10^12

1<= Z <= 10^9

Input Format
An integer T for number of test cases, followed by T test cases each one consisting of three numbers

1) I :- initial distance of Zorons

2) D:- distance covered in a single cosmic leap by Zoronion space craft.

3) Z:- distance covered by Zandarian space crafts.

Output
Single number, the number of leaps required to catch the pirates, and if it is not possible to catch them, output will be -1


Explanation
Example 1

Input

2 9 5 12 5 7 9

Output

2 6

Explanation

The first line is 2, so T is 2, and there are 2 test cases.

In the first test case, The Zorons will initially be at 9 and then they will leap to 14,19 24.....  The Nova Corps can take leaps of 12 and will catch them nearest at a distance 24, taking 2 leaps 12 and 24.

In the second test case, The Zorons will initially be at 5 and then they will leap to 12 19 26 33, 40, 47, 54.....  The Nova Corps can take leaps of 9 and will catch them nearest at 54, taking 6 leaps.

Hence the output has 2 lines, 2 and 6.

Example 2

Input

1

10 15 20

Output

2

Explanation

The first line is 1, so T is 1, and there is 1 test case.

The Zorons will initially be at 10, and jump in jumps of 15, landing at 25,40,

The Nova Corps take leaps of 20, and arrive at 20, 40. Hence, they can meet at 40 after 2 leaps. The output is 2.
* */