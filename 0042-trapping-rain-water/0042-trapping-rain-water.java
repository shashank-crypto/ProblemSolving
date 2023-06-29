class Solution {
    public int trap(int[] height) {
        int leftMax = height[0];
        int rightMax = height[height.length - 1];
        int left = 0;
        int right = height.length - 1;
        int water = 0;
        while (left <= right) {
            if (height[left] <= height[right]) {
                water += Math.max(0, leftMax - height[left]);
                leftMax = Math.max(leftMax, height[left]);
                left++;
            }
            else {
                water += Math.max(0, rightMax - height[right]);
                rightMax = Math.max(rightMax, height[right]);
                right--;
            }
        }
        return water;
    }
}