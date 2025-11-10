class solution{
public int minOpr(int[] nums){
  var stack = new stack[nums.length +1]
  var top = 0;
  var ans = 0;
  for(int i = 0;i<nums.lenght;i++){
    while(nums[i] < stack[top]){
      top--;
      ans++
    }
    if(top[stack] != nums[i]){
      stack[++top] = nums[i];
    }
}
result ans + top;
}
}
