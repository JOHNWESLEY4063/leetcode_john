class Solution{
    public int longestSubarray(int[] nums){
        int max=Integer.MIN_VALUE;
        for(int num:nums)
        {
            if(num>max){
                max=num;
            }
        }
        int maxlength=0;
        int current=0;
        for(int num:nums){
            if(num==max){
                current++;
                if(current>maxlength){
                    maxlength=current;
                }
            }
            else{
                current=0;
            }
        }
        return maxlength;
    }
}