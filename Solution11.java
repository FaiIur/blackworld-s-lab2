import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * @Description 三数之和
 * 给你一个整数数组 nums，判断是否存在三元组 [nums[i], nums[j], nums[k]] 满足 i != j、i != k 且 j != k，
 * 同时还满足 nums[i] + nums[j] + nums[k] == 0。返回所有和为 0 且不重复的三元组。
 * 注意：答案中不可以包含重复的三元组。
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;  // 修正：length() 改为 length
        Arrays.sort(nums);  // 排序数组
        List<List<Integer>> ans = new ArrayList<>();

        // 枚举 a
        for (int first = 0; first < n; ++first) {
            if (first > 0 && nums[first] == nums[first - 1]) {
                continue;  // 跳过重复的元素
            }

            int third = n - 1;  // c 指向数组右端
            int target = -nums[first];  // 修正：漏掉分号

            // 枚举 b
            for (int second = first + 1; second < n; ++second) {
                if (second > first + 1 && nums[second] == nums[second - 1]) {
                    continue;  // 跳过重复的元素
                }

                // b 的指针必须在 c 的左侧
                while (second < third && nums[second] + nums[third] > target) {
                    --third;
                }

                // 如果指针重合，退出循环
                if (second >= third) {
                    break;
                }

                // 找到符合条件的三元组
                if (nums[second] + nums[third] == target) {
                    ans.add(Arrays.asList(nums[first], nums[second], nums[third]));
                }
            }
        }
        return ans;
    }
}