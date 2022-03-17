package leetcode;

public class P4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int medianIndex = (nums1.length + nums2.length)/2;
        int i = 0, j = 0;
        boolean needAve = ((nums1.length + nums2.length)%2==0);
        if (medianIndex == 0){
            return nums1.length > 0 ? nums1[0] : nums2[0];
        }
        else {
            int median = 0;
            for (int k = 0; k <= medianIndex; k++){
                if (k == medianIndex ){
                    int[] medianAndIndex = findMedian(nums1, nums2, i, j);
                    int newMedian = medianAndIndex[0];
                    return needAve ? ((double) median + (double) newMedian)/2 : (double) newMedian;
                }
                int[] medianAndIndex = findMedian(nums1, nums2, i, j);
                median = medianAndIndex[0];
                i = medianAndIndex[1];
                j = medianAndIndex[2];
            }
        }
        return 0;
    }

    private int[] findMedian(int[] nums1, int[] nums2, int i, int j){
        int median = 0;
        if (i < nums1.length && j < nums2.length){
            median = nums1[i] > nums2[j] ? nums2[j++] : nums1[i++];
        }else if (i >= nums1.length){
            median = nums2[j++];
        }else {
            median = nums1[i++];
        }
        return new int[]{median, i, j};
    }

    public static void main(String[] args){
        System.out.println(new P4().findMedianSortedArrays(new int[]{3,4}, new int[]{1,2}));
    }
}
