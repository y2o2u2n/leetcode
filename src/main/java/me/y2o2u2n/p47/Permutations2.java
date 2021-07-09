package me.y2o2u2n.p47;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations2 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Set<List<Integer>> ans = new HashSet<>();
        boolean[] visited = new boolean[nums.length];
        int[] output = new int[nums.length];
        perm(nums, visited, output, 0, ans);
        return new ArrayList<>(ans);
    }

    private void perm(
            int[] nums,
            boolean[] visited,
            int[] output,
            int depth,
            Set<List<Integer>> ans
    ) {
        if (depth == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int num : output) {
                temp.add(num);
            }
            ans.add(temp);
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            output[depth] = nums[i];
            perm(nums, visited, output, depth + 1, ans);
            visited[i] = false;
        }
    }
}
