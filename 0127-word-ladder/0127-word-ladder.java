class Solution {

    public void removeNextWords(String word, Set<String> wordSet, Queue<String> wordQueue) {
        // StringBuilder wordBuilder = new StringBuilder(word);
        for (int j = 0; j < word.length(); j++) {
            for (char i = 'a' ; i <= 'z'; i++) {
                if (word.charAt(j) != i) {
                    // wordBuilder.setCharAt(j, i);
                    // String nextWord = wordBuilder.toString();
                    String nextWord = word.substring(0, j) + i + word.substring(j+1);
                        //  System.out.println(nextWord);
                    if (wordSet.contains(nextWord)) {
                        wordQueue.add(nextWord);
                        wordSet.remove(nextWord);
                    }
                }
            }
        }
    }

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        Queue<String> wordQueue = new LinkedList<>();
        int counter = 0;
        wordQueue.add(beginWord);
        while (!wordQueue.isEmpty()) {
            int size = wordQueue.size();
            while (size-- > 0) {
                String word = wordQueue.poll();
                if (word.equals(endWord)) return counter + 1;
                removeNextWords(word, wordSet, wordQueue);
                // System.out.println(wordQueue + " " + wordSet.size());
            }
            counter++;
        }
        return 0;
    }
}