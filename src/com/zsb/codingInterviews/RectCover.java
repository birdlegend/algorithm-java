package com.zsb.codingInterviews;

/**
 * created by zsb on 2018/9/13
 *
 * @see <a href="https://birdlegend.github.io/">birdlegend的博客</a>
 */
public class RectCover {
    public int RectCover(int target) {
        if (target < 1) return 0;
        if (target == 1) return 1;
        if (target == 2) return 2;

        return RectCover(target - 1) + RectCover(target - 2);
    }
}
