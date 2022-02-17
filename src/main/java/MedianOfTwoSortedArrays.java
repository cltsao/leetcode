public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalCount = nums1.length + nums2.length;
        if (totalCount % 2 == 1) {
            return findKthNumber(nums1, 0, nums2, 0, (totalCount + 1) / 2);
        } else {
            return (findKthNumber(nums1, 0, nums2, 0, totalCount / 2) + findKthNumber(nums1, 0, nums2, 0, totalCount / 2 + 1)) / 2.0;
        }
    }

    // Binary search by iteratively discarding floor(k/2) numbers
    private int findKthNumber(int[] nums1, int start1, int[] nums2, int start2, int k) {
        // If one array is exhausted, must find in another array
        if (start1 >= nums1.length) return nums2[start2 + k - 1];
        if (start2 >= nums2.length) return nums1[start1 + k - 1];

        // Last step in binary search
        if (k == 1) return Math.min(nums1[start1], nums2[start2]);

        int mid1 = (start1 + k/2 - 1 < nums1.length) ? nums1[start1 + k/2 - 1] : Integer.MAX_VALUE;
        int mid2 = (start2 + k/2 - 1 < nums2.length) ? nums2[start2 + k/2 - 1] : Integer.MAX_VALUE;
        if (mid1 < mid2) {
            // Throw away floor(k/2) numbers in array 1, and find ceil(k/2)-th number in the remaining numbers
            return findKthNumber(nums1, start1 + k/2, nums2, start2, k - k/2);
        } else {
            return findKthNumber(nums1, start1, nums2, start2 + k/2, k - k/2);
        }
    }
}
