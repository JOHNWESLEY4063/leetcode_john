class Solution{
    public int minBitFlips(int start,int goal){
        int xorResult=start^goal;
        int bitFlips=0;
        while (xorResult !=0){
            bitFlips=bitFlips+(xorResult & 1);
            xorResult=xorResult/2;
        }
        return bitFlips;
    }
}