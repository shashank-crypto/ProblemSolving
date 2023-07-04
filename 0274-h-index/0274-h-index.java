class Solution {
    public int hIndex(int[] citations) {
        int hIndex = 0;
        Arrays.sort(citations);
        for (int i = citations.length - 1; i >= 0; i--) {
            if ((citations.length - i) <= citations[i]) hIndex = (citations.length - i);
            else break;
        }
        return hIndex;
    }
}