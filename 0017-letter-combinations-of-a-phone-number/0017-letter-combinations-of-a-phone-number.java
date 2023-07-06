class Solution {
    char[][] digitMapping = {{'a','b','c'},{'d','e','f'},{'g','h','i'},{'j','k','l'},{'m','n','o'},{'p','q','r','s'},{'t','u','v'},{'w','x','y','z'}};

    public List<String> letterCombinations(String digits) {
        List<String> result = new LinkedList<>();
        StringBuilder word = new StringBuilder();
        helper(result, word, digits, 0);
        return result;
    }

    private void helper(List<String> result, StringBuilder word, String digits, int index) {
        if (index >= digits.length()) {
            if (word.length() > 0) result.add(word.toString());
            return;
        }
        int number = Integer.parseInt(Character.toString(digits.charAt(index)));
        for (char letter: digitMapping[number - 2]) {
            word.append(letter);
            helper(result, word, digits, index + 1);
            word.deleteCharAt(word.length() - 1);
        }
    }
}