class Solution {
    public boolean isAnagram(String s, String t) {
        int matched = t.length();
        if (s.length() != t.length()) return false;
        HashMap<Character, Integer> freq = new HashMap<>(); 
        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            freq.put(sChar, freq.getOrDefault(sChar, 0) + 1);
        }
        for (int i = 0; i < t.length(); i++) {
            char tChar = t.charAt(i);
            int tFreq = freq.getOrDefault(tChar, 0);
            if (tFreq <= 0) {
                return false;
            }
            freq.put(tChar,tFreq - 1);
        }
        return true;
    }
}