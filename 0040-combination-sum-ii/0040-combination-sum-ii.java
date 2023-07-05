class Solution {

    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> finalResult = new LinkedList<>();
        Arrays.sort(candidates);
        backtrack(new LinkedList<Integer>(), target, 0, candidates);
        return result;
        
    }

    public void backtrack(LinkedList<Integer> combination, int target, int index, int[] candidates) {
        if (target == 0) {
            result.add(new LinkedList<>(combination));
            return;
        }
        if (index >= candidates.length || target < 0) return;
        combination.addLast(candidates[index]);
        backtrack(combination, target - candidates[index], index + 1, candidates);
        combination.removeLast();
        while (index + 1 < candidates.length && candidates[index] == candidates[index+1]) index++;
        backtrack(combination, target, index + 1, candidates);
    
    }
}