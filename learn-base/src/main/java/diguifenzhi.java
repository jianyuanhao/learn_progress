import java.util.Arrays;

/**
 * 递归：大问题分解为小问题，小问题最后一定有一个出口－求解基本问题 把对原问题的求解分解成对子问题的求解－降低问题规模，拆完性质一样 Created by jianyuanhao on 18-12-8.
 */
public class diguifenzhi {
    public int F(int n) {
        // 出口
        if (n == 1 || n == 0) {
            return 1;
        }
        // 递归
        return F(n - 1) + F(n - 2);
    }

    // 分治拆分，不额外开辟空间
    public long sum(int[] arr, int startIndex, int endIndex) {
        if (startIndex == endIndex) {
            return arr[startIndex];
        }
        return arr[startIndex] + sum(arr, startIndex + 1, endIndex);
    }

    public static void main(String[] args) {
        int[] a = new int[] { 3, 4, 2, 1 };
        System.out.println(Arrays.toString(a));
        System.out.println(new diguifenzhi().sum(a, 0, a.length - 1));
    }

    private class Node {
        int val;
        Node next;
    }

    public void printNode(Node node) {
        if (node == null) {
            return;
        }
        System.out.println(node.val);
        printNode(node.next);
    }
    //栈－攒着　后进先出性质
    public void printRevertNode(Node node) {
        if (node == null) {
            return;
        }
        printNode(node.next);
        System.out.println(node.val);
    }
}
