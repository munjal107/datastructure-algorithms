#include<iostream>
#include<cstring>
#include<fstream>

using namespace std;
char n[10];
	int k,t,count1;
int getdata();
int check();
void change(int);


int main()
{
    ifstream fin;
    fin.open("A-small-practice.in");
    ofstream fout;
    fout.open("A-small-practice2.out");
    fin>>t;
    int q;
    for(int j=1;j<=t;j++)
    {
        fin>>n>>k;
        q=getdata();
        if(q==0)
        {
            fout<<"\nCase #"<<j<<": IMPOSSIBLE";
        }
        else
        {
            fout<<"\nCase #"<<j<<": "<<count1;
        }
    }

	return 0;
}
int getdata()
{
    	int c,i;
    	count1=0;
	for(i=0;i<=(strlen(n)-k);i++)
	{

		if(check())
		{
			break;
		}
		if(n[i]=='-')
		{
			count1=count1+1;
			change(i);
		}
	}
	c=check();
    return(c);
}
void change(int x)
{
	int a,b=1;
	for(a=x;b<=k;b++,a++)
	{
		if(n[a]=='-')
			n[a]='+';
		else
			n[a]='-';
	}
}
int check()
{
	for(int i=0;i<strlen(n);i++)
	{
		if(n[i]=='-')
			return 0;
	}
	return 1;
}


