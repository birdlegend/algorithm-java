package com.zsb.weinxin;

import com.zsb.codingInterviews.isNumeric.Solution;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * created by zsb on 2018/9/11
 *
 * @see <a href="https://birdlegend.github.io/">birdlegend的博客</a>
 */
public class advertisement {
    /**
     * @param adverNum 广告数
     * @param slots    每个广告出现概率
     * @param capacity 一次能显示多少广告
     * @param count    显示多少次广告
     */
    public void solution(int adverNum, int[] slots, int capacity, int count) {
        Random random = new Random(System.nanoTime());
        int hit = -1;

        Set<Integer> occupy = new HashSet<>();
        int slotNum = 0;

        for (int i : slots) {
            slotNum += i;
        }

        int[] tmpSlots = new int[slots.length];
        System.arraycopy(slots, 0, tmpSlots, 0, slots.length);

        int[] resArr = new int[capacity * count];

        int slot = 0;
        int resCnt = 0;
        for (int i = 0; i < count; i++) {
            occupy.clear();
            // 广告1
            for (int j = 0; j < capacity; j++) {
                if (slot >= slotNum) {
                    System.arraycopy(slots, 0, tmpSlots, 0, slots.length);
                }

                boolean hasSet = false;
                do {
                    hit = random.nextInt(adverNum);
                    if (!occupy.contains(hit) && tmpSlots[hit] > 0) {
                        occupy.add(hit);
                        tmpSlots[hit]--;
                        slot++;
                        resArr[resCnt++] = hit + 1;
                        hasSet = true;
                    }
                } while (!hasSet);
            }
        }

        System.out.println(Arrays.toString(resArr));
    }


    public static void main(String[] args) {
        int adverNum = 4;
        int capacity = 2;
        int slots[] = new int[]{1, 2, 3, 4};
        int count = 1;

        advertisement advertisement = new advertisement();
        advertisement.solution(adverNum, slots, 2, 5);
    }
}

