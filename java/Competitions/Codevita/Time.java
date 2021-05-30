/* codevita mockvita 18 

The objective is to form the maximum possible time in the HH:MM:SS format using any six of nine given single 
digits (not necessarily distinct)
Given a set of nine single (not necessarily distinct) digits, say 0, 0, 1, 3, 4, 6, 7, 8, 9, it is possible to 
form many distinct times in a 24 hour time format HH:MM:SS, such as 17:36:40 or 10:30:41 by using each of the 
digits only once. The objective is to find the maximum possible valid time (00:00:01 to 24:00:00) that can be 
formed using some six of the nine digits exactly once. In this case, it is 19:48:37.

Input Format
A line consisting of a sequence of 9 (not necessarily distinct) single digits (any of 0-9) separated by commas. 
The sequence will be non-decreasing

Output
The maximum possible time in a 24 hour clock (00:00:01 to 24:00:00) in a HH:MM:SS form that can be formed by 
using some six of the nine given digits (in any order) precisely once each. If no combination of any six digits 
will form a valid time, the output should be the word Impossible

Explanation
Example 1
Input
0,0,1,1,3,5,6,7,7

Output
17:57:36

The maximum valid time in a 24 hour clock that can be formed using some six of the 9 digits precisely once 
is 17:57:36

Example 2
Input
3,3,3,3,3,3,3,3,3
Output
Impossible

0,0,1,3,4,6,7,8,9

*/
  import java.io.*;

class Time{
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int[] input = new int[9];
		String[] str = br.readLine().split(",");
		for(int i=0;i<input.length;i++){
			input[i]=Integer.parseInt(str[i]);
		}
		solve(input);
	}
	static void solve(int[] input){
		int i=0,j=0,count=0,chk=-1;
		StringBuilder sb = new StringBuilder("");	
		for(i=2;i>=0;i--){
			for(j=0;j<input.length;j++){
				if(input[j]==i){
					sb.append(i);
					input[j]=-1;
					chk=i;
					count++;				
					break;
				}
			}
			if(count==1)
				break;
		}
		if(count==0){
			System.out.print("Impossible");
			return;
		}
		if(chk==2){
			for(i=4;i>=0;i--){
				for(j=0;j<input.length;j++){
					if(input[j]==i){
						sb.append(i);
						input[j]=-1;
						count++;
						break;
					}
				}
				if(count==2)
					break;
			}
		}
		else if(chk==1 || chk ==0){
			for(i=9;i>=0;i--){
				for(j=0;j<input.length;j++){
					if(input[j]==i){
						sb.append(i);
						input[j]=-1;
						count++;
						break;
					}
				}
				if(count==2)
					break;
			}
			
		}
		if(count<=1){
			System.out.print("Impossible");
			return;
		}
		if(count==2)
				sb.append(":");
			else {
				System.out.print("Impossible");
				return;
			}
		if(String.valueOf(sb).equals("24:")){
			int c=0;
			for(j=0;j<input.length;j++){
					if(input[j]==0){
						c++;
					}
			}
			if(c>=4){
				System.out.print("24:00:00");
				return;
			}
			else{
				System.out.print("Impossible");
				return;
			}

		}
		
		for(i=5;i>=0;i--){
			for(j=0;j<input.length;j++){
				if(input[j]==i){
					sb.append(i);
					input[j]=-1;
					count++;
					break;
				}
			}
			if(count==3)
				break;
		}	
		if(count<=2){
			System.out.print("Impossible");
			return;
		}	
		for(i=9;i>=0;i--){
			for(j=0;j<input.length;j++){
				if(input[j]==i){
					sb.append(i);
					input[j]=-1;
					count++;
					break;
				}
			}
			if(count==4)
				break;
		}
		if(count<=3){
			System.out.print("Impossible");
			return;
		}
		if(count==4)
			sb.append(":");
		else {
			System.out.print("Impossible");
			return;
		}
		

		for(i=5;i>=0;i--){
			for(j=0;j<input.length;j++){
				if(input[j]==i){
					sb.append(i);
					input[j]=-1;
					
					count++;
					break;
				}
			}
			if(count==5)
				break;
		}

		if(count<=4){
			System.out.print("Impossible");
			return;
		}

		for(i=9;i>=0;i--){
			for(j=0;j<input.length;j++){
				if(input[j]==i){
					sb.append(i);
					input[j]=-1;
					count++;
					break;
				}
			}
			if(count==6)
				break;
		}
		if(count==6)
		{
			if(String.valueOf(sb).equals("00:00:00")){
				System.out.print("Impossible");
			}
			else
			{
				System.out.print(sb);
			}
		}
		else {
			System.out.print("Impossible");
			return;
		}
	}
}