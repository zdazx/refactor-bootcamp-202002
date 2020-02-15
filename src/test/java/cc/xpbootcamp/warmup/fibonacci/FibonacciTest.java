package cc.xpbootcamp.warmup.fibonacci;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class FibonacciTest {

    private Fibonacci fibonacci;

    @BeforeEach
    void setUp() {
        fibonacci = new Fibonacci();
    }

    @Test
    public void should_return_1_when_calculate_given_position_is_1() {
        Object result = fibonacci.calculate(1);
        assertThat(result, is(1));
    }

    @Test
    public void should_return_1_when_calculate_given_position_is_2() {
        Object result = fibonacci.calculate(2);
        assertThat(result, is(1));
    }

    @Test
    public void should_return_2_when_calculate_given_position_is_3() {
        Object result = fibonacci.calculate(3);
        assertThat(result, is(2));
    }

    @Test
    public void should_return_55_when_calculate_given_position_is_10() {
        Object result = fibonacci.calculate(10);
        assertThat(result, is(55));
    }

    @Test
    public void should_return_12586269025L_when_calculate_position_is_55() {
        Object result = fibonacci.calculate(50);
        assertThat(result, is(12586269025L));
    }

    @Test
    public void should_return_0_when_calculate_position_is_0() {
        Object result = fibonacci.calculate(0);
        assertThat(result, is(0));
    }

    @Test
    public void should_return_0_when_calculate_position_is_less_than_0() {
        Object result = fibonacci.calculate(-1);
        assertThat(result, is(0));
    }
}