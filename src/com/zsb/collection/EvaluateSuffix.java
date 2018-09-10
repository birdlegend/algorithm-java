package com.zsb.collection;

import java.util.Stack;

/**
 * Created by zsb on 2018/3/27.
 */
public class EvaluateSuffix {
    public static void main(String[] args) {
        System.out.println(EvaluateSuffix.infixToSuffix("4.3+(6-10+2*2)*2"));
    }

    /**
     * 中缀表达式转后缀表达式
     *
     * @param expression 表达式
     * @return 返回后缀表达式
     */
    public static String infixToSuffix(String expression) {
        StringBuffer suffix = new StringBuffer();
        Stack<Character> optrStack = new Stack<>();
        // 遍历这个表达式
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            // 数值
            if (Character.isDigit(c) || c == '.') {
//                // 读取一个数值
//                while (i < expression.length() && (Character.isDigit(c=) || c == '.')) {
//                    suffix.append(c);
//                    i++;
//                }

                do {
                    suffix.append(c);
                    i++;
                } while (i < expression.length() &&
                        (Character.isDigit(c=expression.charAt(i)) || c == '.'));
                i--;
                suffix.append(" ");
            }

             else {
                /* c操作符与栈中的操作符比较，
                1. 如果优先级高于栈顶的，直接将c压入栈中；
                2. 如果等于栈顶，则c为}，栈顶为{，直接弹出栈顶；
                3. 如果优先级低于栈顶的，弹出栈顶，并将该值加入字符串中。将c加入操作符栈。
                */
                outer:
                while (!optrStack.isEmpty()) {
                    char lOptr = optrStack.peek(); // 栈顶操作符，即左操作符
                    switch (precede(lOptr, c)) { //
                        case '<':
                            optrStack.push(c);
                            break outer; //直接跳出循环。
                        case '=': // lOptr为{，c为}
                            optrStack.pop(); //直接弹出
                            break outer;
                        case '>':
                            suffix.append(optrStack.pop());
                            suffix.append(" ");
                            break; //c与新的栈顶进行比较
                    }
                }

                // 栈为空，直接压入操作符
                if (optrStack.isEmpty()) {
                    optrStack.push(c);
                }
            }
        }

        while (!optrStack.isEmpty()) {
            suffix.append(optrStack.pop());
            suffix.append(" ");
        }


        return suffix.toString();
    }

    /**
     * 比较两个运算符的优先权大小
     *
     * @param θ1
     * @param θ2
     * @return
     */
    public static char precede(char θ1, char θ2) {
        if (θ1 == '+' || θ1 == '-') {
            if (θ2 == '+' || θ2 == '-' || θ2 == ')') {
                return '>';
            } else {
                return '<';
            }
        } else if (θ1 == '*' || θ1 == '/') {
            if (θ2 == '(') {
                return '<';
            } else {
                return '>';
            }
        } else if (θ1 == '(') {
            if (θ2 == ')') {
                return '=';
            } else {
                return '<';
            }
        } else if (θ1 == ')') {
            return '>';
        }
        return '>';
    }
}
