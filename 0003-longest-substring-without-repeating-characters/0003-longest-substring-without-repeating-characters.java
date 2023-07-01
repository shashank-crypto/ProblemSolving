class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;
        int left = 0;
        int right = 0;
        int minSbstr = 1;
        Set<Character> set = new HashSet<>();
        while (right < s.length()) {
            if (!set.contains(s.charAt(right))) {
                set.add(s.charAt(right));
                right++;
            }
            else {
                if ((right - left) > minSbstr) minSbstr = right - left;
                set.remove(s.charAt(left));
                left++;
            }
        }
        if ((right - left) > minSbstr) minSbstr = right - left;
        return minSbstr;
    }
}