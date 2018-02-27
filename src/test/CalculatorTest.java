package test;

import ru.test.Calculator;
import ru.test.MyJUnit.*;

@SuppressWarnings("unused")
public class CalculatorTest {

    @Test
    public void add() {
        Assert.isEquals(Calculator.add(5, 5), 10L);
        Assert.isEquals(Calculator.add(-5, 5), 0L);
        Assert.isEquals(Calculator.add(-5, -5), -10L);
        Assert.isEquals(Calculator.add(5, -5), 0L);
    }

    @Test
    public void difference() {
        Assert.isEquals(Calculator.subtract(5, 5), 0L);
        Assert.isEquals(Calculator.subtract(5, -5), 10L);
        Assert.isEquals(Calculator.subtract(-5, -5), 0L);
        Assert.isEquals(Calculator.subtract(-5, 5), -10L);
    }

    @Test
    public void multiple() {
        Assert.isEquals(Calculator.multiple(5, 5), 25L);
        Assert.isEquals(Calculator.multiple(5, -5), -25L);
        Assert.isEquals(Calculator.multiple(-5, -5), 25L);
        Assert.isEquals(Calculator.multiple(-5, 5), -25L);
    }

    @Test
    public void devise() {
        Assert.isEquals(Calculator.devise(5, 5), 1L);
        Assert.isEquals(Calculator.devise(5, -5), -1L);
        Assert.isEquals(Calculator.devise(-5, -5), 1L);
        Assert.isEquals(Calculator.devise(-5, 5), -1L);

    }

    @Test
    public void combine() {
        Assert.isEquals(Calculator.devise(Calculator.multiple(Calculator.add(9, 2), Calculator.subtract(9, 2)), 1), 77L);
    }
}
