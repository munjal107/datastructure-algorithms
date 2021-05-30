#include<iostream>
//#include<algorithm>
#include<climits>
int main(){
    int n ;
    std::cin >> n ;
    long long sum = 0 ;
    long long avg = 0 ;
    long long budgets[n];
    for(int i = 0 ; i < n ; i++){
        std::cin >> budgets[i];
        sum += budgets[i];
    }
    avg = sum/n;
    /** Without doing sorting O(n) */
    int count = 0;
    long long temp = LLONG_MAX;
    for(int i = 0 ; i < n ; i++){
        if(budgets[i] >= avg){
            if(temp > budgets[i])
                temp = budgets[i];
            count++;
        }
    }
    std::cout << count*temp ;
/** With Sorting The Elements might slow because O(nlog(n)) + O(n)*/
    /*std::sort(budgets,budgets+n);
    for(int i = 0 ; i < n ; i++){
        if(budgets[i]>=avg){
            std::cout << (n-i)*budgets[i];
            return 0;
        }
    }*/
}