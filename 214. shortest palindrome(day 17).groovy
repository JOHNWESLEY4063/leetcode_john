class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        String rev = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + rev;
        int[] kmpTable = generateKMPTable(combined);
        int longestPalindromePrefixLength = kmpTable[kmpTable.length - 1];
        String toAdd = rev.substring(0, rev.length() - longestPalindromePrefixLength);
        return toAdd + s;
    }

    private int[] generateKMPTable(String str) {
        int n = str.length();
        int[] table = new int[n];
        int j = 0;

        for (int i = 1; i < n; i++) {
            while (j > 0 && str.charAt(i) != str.charAt(j)) {
                j = table[j - 1];
            }

            if (str.charAt(i) == str.charAt(j)) {
                j++;
            }

            table[i] = j;
        }

        return table;
    }
}