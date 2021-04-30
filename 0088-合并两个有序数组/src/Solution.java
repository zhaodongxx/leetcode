/**
 * @author zhaodong5
 * @date 2021/4/30 10:30
 */
public class Solution {

    /**
     * 双指针法
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (m == 0) {
            for (int i = 0; i < nums2.length; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }
        if (n == 0) {
            return;
        }

        int[] temp = new int[m + n];
        int i = 0;
        int j = 0;
        int k = 0;
        while (i < m && j < n) {
            if (nums1[i] < nums2[j]) {
                temp[k++] = nums1[i++];
            } else {
                temp[k++] = nums2[j++];
            }
        }

        while (i < m) {
            temp[k++] = nums1[i++];
        }

        while (j < n) {
            temp[k++] = nums2[j++];
        }

        for (int a = 0; a < temp.length; a++) {
            nums1[a] = temp[a];
        }
    }

    public static void main(String[] args) {

    }
}
