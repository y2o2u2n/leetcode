package me.y2o2u2n.p1481;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LeastNumberOfUniqueIntegersAfterKRemovals {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer, Integer> countByNum = new HashMap<>();
        for (int num : arr) {
            Integer count = countByNum.getOrDefault(num, 0);
            countByNum.put(num, count + 1);
        }

        PriorityQueue<Item> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.count));

        for (int num : countByNum.keySet()) {
            Integer count = countByNum.get(num);
            pq.offer(new Item(num, count));
        }

        while (!pq.isEmpty() && k > 0) {
            Item poll = pq.poll();
            if (poll.count <= k) {
                k -= poll.count;
            } else {
                pq.offer(new Item(poll.num, poll.count - k));
                k = 0;
            }
        }

        return pq.size();
    }

    private static class Item {
        int num;
        int count;

        public Item(int num, int count) {
            this.num = num;
            this.count = count;
        }
    }
}
