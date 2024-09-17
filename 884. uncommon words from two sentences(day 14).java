import java.util.*;

class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {
        // Split both sentences into words
        String[] words1 = s1.split(" ");
        String[] words2 = s2.split(" ");
        
        // Create a HashMap to store word counts
        Map<String, Integer> wordCount = new HashMap<>();
        
        // Count the occurrences of each word from s1
        for (String word : words1) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        // Count the occurrences of each word from s2
        for (String word : words2) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        
        // Collect the uncommon words
        List<String> result = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : wordCount.entrySet()) {
            if (entry.getValue() == 1) {
                result.add(entry.getKey());
            }
        }
        
        // Convert the result list to an array and return
        return result.toArray(new String[0]);
    }
}
