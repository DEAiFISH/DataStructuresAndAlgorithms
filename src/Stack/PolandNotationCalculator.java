package Stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 逆波兰计算器
 */
public class PolandNotationCalculator {
    public static void main(String[] args) {
        PolandNotationCalculator calculator = new PolandNotationCalculator();
        System.out.println(calculator.calculate("(12+5)*(8-1)-6*6"));
    }

    public PolandNotationCalculator() {
    }

    /**
     * 计算
     * @param calculation 逆波兰表达式
     * @return 结果
     */
    public int calculate(String calculation) {
        Stack<String> stack = new Stack<>();
        List<String> suffixExpression = parseSuffixExpressionList(toInfixExpressionList(calculation));

        for (String str : suffixExpression) {
            if (str.matches("\\d+")) {
                stack.push(str);
            } else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                switch (str) {
                    case "+":
                        stack.push(String.valueOf(num1 + num2));
                        break;
                    case "-":
                        stack.push(String.valueOf(num1 - num2));
                        break;
                    case "*":
                        stack.push(String.valueOf(num1 * num2));
                        break;
                    case "/":
                        stack.push(String.valueOf(num1 / num2));
                        break;
                    default:
                        throw new RuntimeException("符号输入有误。。。");
                }
            }
        }
        return Integer.parseInt(stack.pop());
    }

    /**
     * 中缀表达式转为List集合
     * @param str 中缀表达式
     * @return List集合
     */
    private List<String> toInfixExpressionList(String str) {
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (Character.isDigit(c)) {
                StringBuilder num = new StringBuilder();
                while (i < str.length() && Character.isDigit(str.charAt(i))) {
                    num.append(str.charAt(i++));
                }
                i--;
                list.add(String.valueOf(num));
            } else {
                list.add(String.valueOf(c));
            }
        }
        return list;
    }

    /**
     * 中缀表达式列表转换为后缀表达式列表
     * @param list 中缀表达式列表
     * @return 后缀表达式列表
     */
    private List<String> parseSuffixExpressionList(List<String> list){
        Stack<String> s1 = new Stack<>();
        Stack<String> s2 = new Stack<>();

        for (String str :list) {
            if(str.matches("\\d+")){
                s2.push(str);
            } else if ("(".equals(str)) {
                s1.push(str);
            } else if(")".equals(str)){
                while(!"(".equals(s1.peek())){
                    s2.push(s1.pop());
                }
                s1.pop();
            }else{
                while(!s1.isEmpty() && priority(s1.peek().charAt(0)) >= priority(str.charAt(0))){
                    s2.push(s1.pop());
                }
                s1.push(str);
            }
        }

        ArrayList<String> res = new ArrayList<>(s2);
        while (!s1.isEmpty()){
            res.add(s1.pop());
        }

        return res;
    }

    /**
     * 符号优先级
     * @param sign
     * @return
     */
    private int priority(int sign){
        if(sign == '*' || sign == '/'){
            return 1;
        } else if (sign == '(') {
            return -1;
        } else{
            return 0;
        }
    }
}
