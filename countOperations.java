// TLE 
class Solution {
    public int countOperations(int num1, int num2) {
        int cnt = 0;
        while(num1 != 0 || num2 != 0){
            if(num1 < num2){
                num2 -= num1;
                cnt++;
            }else if( num2 < num1){
                num1 -= num2;
                cnt++;
            }else{
                cnt++;
                break;
            }
        }
        return cnt;
        
    }
}

----------------------------------------------------------
  class Solution {
    public int countOperations(int num1, int num2) {
        if(num1 == 0 || num2 == 0) return 0;
        if(num1 < num2) return countOperations(num2,num1);
        return (num1 / num2) + countOperations (num1 % num2, num2); 
    }
}
-------------------------------------------------------------------
