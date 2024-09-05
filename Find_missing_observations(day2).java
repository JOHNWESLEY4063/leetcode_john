import java.util.*;

public class Solution {
    
    public static int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int totalsum = mean * (n + m);
        int currentsum = 0;
        
        for (int roll : rolls) {
            currentsum += roll;
        }
        
        int missingsum = totalsum - currentsum;
        
        
        if (missingsum < n || missingsum > 6 * n) {
            return new int[0]; // Impossible case
        }
        
        int[] result = new int[n];
        int average = missingsum / n;
        int remainder = missingsum % n;
        
       
        for (int i = 0; i < n; i++) {
            result[i] = average + (i < remainder ? 1 : 0);
        }
        
        return result;
    }

    public static void main(String[] args) {
        
        int[] rolls1 = {3, 2, 4, 3};
        int mean1 = 4;
        int n1 = 2;
        System.out.println(Arrays.toString(missingRolls(rolls1, mean1, n1)));  // Output: [6, 6]

        
        int[] rolls2 = {1, 5, 6};
        int mean2 = 3;
        int n2 = 4;
        System.out.println(Arrays.toString(missingRolls(rolls2, mean2, n2)));  // Output: [2, 3, 2, 2]

        
        int[] rolls3 = {1, 2, 3, 4};
        int mean3 = 6;
        int n3 = 4;
        System.out.println(Arrays.toString(missingRolls(rolls3, mean3, n3)));  // Output: []
    }
}
