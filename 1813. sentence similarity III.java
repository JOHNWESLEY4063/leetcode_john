class Solution {
    public boolean areSentencesSimilar(String sentence1, String sentence2) {
        String[] words1 = sentence1.split(" ");
        String[] words2 = sentence2.split(" ");
        
        if (words1.length < words2.length) {
            return areSimilar(words1, words2);
        } else {
            return areSimilar(words2, words1);
        }
    }
    
    private boolean areSimilar(String[] shorter, String[] longer) {
        int i = 0, j = 0;
        
        while (i < shorter.length && shorter[i].equals(longer[i])) {
            i++;
        }
        
        while (j < shorter.length && shorter[shorter.length - 1 - j].equals(longer[longer.length - 1 - j])) {
            j++;
        }
        
        return i + j >= shorter.length;
    }
}
