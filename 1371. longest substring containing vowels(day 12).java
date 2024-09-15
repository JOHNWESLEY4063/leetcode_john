import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findTheLongestSubstring(String s) {
        int n = s.length();
        int mask = 0;
        int maxLen = 0;
        Map<Integer, Integer> seen = new HashMap<>();
        seen.put(0, -1);

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            switch (c) {
                case 'a': mask ^= 1; break;
                case 'e': mask ^= 2; break;
                case 'i': mask ^= 4; break;
                case 'o': mask ^= 8; break;
                case 'u': mask ^= 16; break;
            }

            if (seen.containsKey(mask)) {
                maxLen = Math.max(maxLen, i - seen.get(mask));
            } else {
                seen.put(mask, i);
            }
        }

        return maxLen;
    }
}