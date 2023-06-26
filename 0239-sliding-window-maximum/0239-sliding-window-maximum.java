class Solution {

    public class Node implements Comparable<Node> {
        int index;
        int val;

        Node(int index, int val) {
            this.index = index;
            this.val = val;
        }

        @Override
        public int compareTo(Node n2) {
            return n2.val - this.val;
        }
    }


    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        PriorityQueue<Node> pq = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            pq.add(new Node(i, nums[i]));
        }
        result[0] = pq.peek().val;
        for (int i = k; i < nums.length; i++) {
            while (!pq.isEmpty() && pq.peek().index < i - k + 1) {
                pq.remove();
            }
            pq.add(new Node(i, nums[i]));
            result[i - k + 1] = pq.peek().val;
        }
        return result;
    }
}