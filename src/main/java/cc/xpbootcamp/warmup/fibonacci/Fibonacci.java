package cc.xpbootcamp.warmup.fibonacci;

public class Fibonacci {
    public Object calculate(int position) {
        if (position == 1) {
            return 1;
        }

        long first = 0;
        long second = 1;
        long res = 1;

        for (int i = 2; i <= position; i++) {
            res = first + second;
            first = second;
            second = res;
        }

        if (Integer.MAX_VALUE > res) {
            return (int)res;
        }
        return res;
    }
}
