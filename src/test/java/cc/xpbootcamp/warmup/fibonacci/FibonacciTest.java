package cc.xpbootcamp.warmup.fibonacci;

import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class FibonacciTest {
    @Test
    public void should_return_1_when_calculate_given_position_is_1() {
        Fibonacci fibonacci = new Fibonacci();
        int result = fibonacci.calculate(1);
        assertThat(result, is(1));
    }
}