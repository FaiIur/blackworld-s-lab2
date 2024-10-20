import org.example.Solution;
import org.junit.Test;
import org.junit.Assert;

public class L2022211907_10_Test { // 示例学号：20201234 <-- 示例都懒得删除 真乃蓝狗也XD

    @Test
    public void testCase1() {
        Solution solution = new Solution();
        String expression = "-1/2+1/2";
        Assert.assertEquals("0/1", solution.fractionAddition(expression));
    }

    @Test
    public void testCase2() {
        Solution solution = new Solution();
        String expression = "-1/2+1/2+1/3";
        Assert.assertEquals("1/3", solution.fractionAddition(expression));
    }

    @Test
    public void testCase3() {
        Solution solution = new Solution();
        String expression = "1/3-1/2";
        Assert.assertEquals("-1/6", solution.fractionAddition(expression));
    }

    @Test
    public void testSingleFraction() {
        Solution solution = new Solution();
        String expression = "2/3";
        Assert.assertEquals("2/3", solution.fractionAddition(expression));
    }

    @Test
    public void testAllPositive() {
        Solution solution = new Solution();
        String expression = "1/2+1/2";
        Assert.assertEquals("1/1", solution.fractionAddition(expression));
    }

    @Test
    public void testAllNegative() {
        Solution solution = new Solution();
        String expression = "-1/2-1/2";
        Assert.assertEquals("-1/1", solution.fractionAddition(expression));
    }
}


