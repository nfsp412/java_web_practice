import java.util.Arrays;
import java.util.HashMap;

/**
 * @author sunpeng
 * @version v1.0
 * @package spring_project
 * @name Demo1
 * @create 2024/9/13 10:21
 */

public class Demo1 {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 7, 1, 11};
        int target = 9;
        int[] index = getIndex(nums, target);
        Arrays.stream(index).forEach(System.out::println);

    }

    /**
     * @param nums   整数数组,例如[2,7,1,11]
     * @param target 目标值,例如9
     */
    public static int[] getIndex(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // 存储索引
        int[] index = new int[2];
        // 遍历数组
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                index[0] = map.get(target - nums[i]);
                index[1] = i;
            } else {
                map.put(nums[i], i);
            }
        }
        return index;
    }
}
