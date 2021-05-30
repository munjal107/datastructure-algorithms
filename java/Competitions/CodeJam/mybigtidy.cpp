#include <iostream>
#include <fstream>
#include <string>

inline char decrement(char c){
    return c == '1' ? '9' : char(c-1);
}

void gettidy(std::string& num){
    for(std::size_t i = 0 ; i != num.length()-1 ; i++){
        if(num[i] <= num[i+1]){
           continue;
        }
        else{
                if(num[i] == '1'){
                    num.replace(i+1,1,"");
                    for(int j = i+1 ; j < num.length() ; j++)
                        num[j] = '9';

                    for(int j = i ; j >=0 ; j--){
                        num[j] = decrement(num[j]);
                    }
                }

                else{
                    num[i] = decrement(num[i]);
                    for(int j = i +1 ; j != num.length() ; j++){
                        num[j] = '9';
                    }
                gettidy(num);
                }
                break;
        }
    }
}

int main()
{
    std::ifstream fin;
    fin.open("B-large-practice.in");
    std::ofstream fout;
    fout.open("B-large-practice1.out");

    int t;
    std::string num;
//    std::cin >> t;
    fin>>t;
    for(int i=1;i<=t;i++)
    {
//        std::cin >> num;
        fin >> num;
        gettidy(num);
//        std::cout << "case "/*<< i */<< "  : " << num << std::endl;
        fout<<"Case #"<<i<<": "<<num<<std::endl;
    }
    return(0);
}






