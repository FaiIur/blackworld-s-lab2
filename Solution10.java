class Solution10 {
    public String fractionAddition(String expression) {
        long numerator = 0, denominator = 1; // 初始化分子和分母
        int index = 0, n = expression.length();

        while (index < n) {
            // 读取分子部分
            long num = 0, sign = 1; 
            if (expression.charAt(index) == '-' || expression.charAt(index) == '+') {
                sign = expression.charAt(index) == '-' ? -1 : 1; // 修正符号判断
                index++;
            }
            // 解析分子
            while (index < n && Character.isDigit(expression.charAt(index))) {
                num = num * 10 + expression.charAt(index) - '0';
                index++;
            }
            num *= sign;  // 添加符号
            index++; // 跳过 '/'

            // 解析分母
            long denom = 0;
            while (index < n && Character.isDigit(expression.charAt(index))) {
                denom = denom * 10 + expression.charAt(index) - '0';
                index++;
            }

            // 执行分数加法：num1/denom1 + num2/denom2 = (num1 * denom2 + num2 * denom1) / (denom1 * denom2)
            numerator = numerator * denom + num * denominator;
            denominator *= denom;
        }

        if (numerator == 0) {
            return "0/1"; // 特殊情况
        }

        long gcd = gcd(Math.abs(numerator), denominator); // 获取最大公约数
        return (numerator / gcd) + "/" + (denominator / gcd); // 返回最简分数
    }

    // 辗转相除法求最大公约数
    public long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}
