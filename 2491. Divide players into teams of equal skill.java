import java.util.Arrays;

class Solution{
    public long dividePlayers(int[] skill){
        Arrays.sort(skill);

        int n=skill.length;
        int target=skill[0]+skill[n-1];
        long totalChemistry=0;

        for(int i=0;i<n/2;i++){
            int left=skill[i];
            int right=skill[n-1-i];
            if(left+right !=target){
                return -1;
            }

            totalChemistry +=(long) left*right;
        }

return totalChemistry;
        }
    
}