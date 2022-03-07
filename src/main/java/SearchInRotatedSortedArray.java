public class SearchInRotatedSortedArray {
    public int search(int[] nums, int target) {
        int min = 0, max = nums.length - 1;
        while(max > min) {
            int mid = (max + min) / 2;
            if (nums[mid] == target) return mid;
            if (nums[mid] < target) {
                if (nums[min] > nums[mid] && nums[min] <= target) {
                    max = mid - 1;
                } else {
                    min = mid + 1;
                }
            } else {
                if (nums[max] < nums[mid] && nums[max] >= target) {
                    min = mid + 1;
                } else {
                    max = mid - 1;
                }
            }
        }
        if (nums[min] == target) return min;
        else return -1;
    }
}
