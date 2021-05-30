import math

class Solution:
    def intToRoman(self, num: int) -> str:
        d = {
            4 : "IV",
            9 : "IX",
            40 : "XL",
            90 : "XC",
            400 : "CD",
            900 : "CM"
        }
        
        out = []
        for i,n in enumerate(str(num)[::-1]):
            n = int(n)
            temp = n * 10**i
            print(temp)
            if temp in d.keys():
                out.append(d[temp])
            else:
                if temp >= 1000:
                    a = temp//1000 * 'M'
                elif temp >= 500:
                    a = 'D' + (temp-500)//100 * 'C'
                elif temp >= 100:
                    a = temp//100 * 'C'
                elif temp >= 50:
                    a = 'L' + (temp-50)//10 * "X"
                elif temp >= 10:
                    a = temp//10 * 'X'
                elif temp >= 5 and temp < 9:
                    a = 'V' + (temp-5) * 'I'
                else:
                    a = temp * 'I'
                out.append(a)
        return ''.join(out[::-1])
    
    
if __name__ == '__main__':
    obj = Solution()
   # print(obj.intToRoman(60))
    print(obj.intToRoman(70))

    #print(obj.intToRoman(1894))
    #print(obj.intToRoman(1994))

