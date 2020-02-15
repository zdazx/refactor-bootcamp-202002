package cc.xpbootcamp.warmup.fibonacci;

public class Fibonacci {
    public int calculate(int position) {
        if (position == 1) {
            return 1;
        }

        int first = 0;
        int second = 1;
        int res = 1;

        for (int i = 2; i <= position; i++) {
            res = first + second;
            first = second;
            second = res;
        }

        return res;
    }
}
