package other;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

/**
 The structure of Expression Tree is a binary tree to evaluate certain expressions.
 All leaves of the Expression Tree have an number string value. All non-leaves of the Expression Tree have an operator string value.

 Now, given an expression array, build the expression tree of this expression, return the root of this expression tree.

 For the expression (2*6-(23+7)/(1+2)) (which can be represented by ["2" "*" "6" "-" "(" "23" "+" "7" ")" "/" "(" "1" "+" "2" ")"]).
 The expression tree will be like

              [ - ]
        /                  \
     [ ]                [ / ]
    /     \            /         \
   [ 2 ]  [ 6 ]      [ + ]        [ + ]
                    /    \       /      \
                 [ 23 ] [ 7 ] [ 1 ]   [ 2 ] .
 After building the tree, you just need to return root node [-].

 */
public class ExpressionTreeBuild {
    public ExpressionTreeNode build(String[] expression) {
        int n = expression.length;
        if(n==0) return null;
        LinkedList<ExpressionTreeNode> nums = new LinkedList();
        LinkedList<ExpressionTreeNode> ops = new LinkedList();

        Set<String> operations = new HashSet(Arrays.asList("+", "-", "*", "/"));
        int i = 0;
        while(i<n){
            if(operations.contains(expression[i])) {
                ops.add(new ExpressionTreeNode(expression[i]));
                i++;
            } else {
                if(expression[i].equals("(")) {
                    int j = i+1;
                    int count = 1;
                    while(j<n){
                        if(expression[j].equals("(")) {
                            count++;
                        } else if(expression[j].equals(")")){
                            count--;
                        }
                        if(count==0) break;
                        j++;
                    }

                    nums.add(build(Arrays.copyOfRange(expression, i+1, j)));
                    i = j+1;
                } else {
                    nums.add(new ExpressionTreeNode(expression[i]));
                    i++;
                }

                // Merge * or /
                if(!ops.isEmpty()) {
                    String s = ops.getLast().symbol;
                    if(s.equals("*") || s.equals("/")) {
                        ExpressionTreeNode b = nums.removeLast();
                        ExpressionTreeNode a = nums.removeLast();
                        ExpressionTreeNode op = ops.removeLast();
                        op.left = a;
                        op.right = b;
                        nums.add(op);
                    }
                }
            }
        }

        while(!ops.isEmpty()) {
            ExpressionTreeNode op = ops.removeFirst();
            ExpressionTreeNode a = nums.removeFirst();
            ExpressionTreeNode b = nums.removeFirst();
            op.left = a;
            op.right = b;
            nums.addFirst(op);
        }

        return nums.getFirst();
    }

    public class ExpressionTreeNode {
         public String symbol;
         public ExpressionTreeNode left, right;
         public ExpressionTreeNode(String symbol) {
             this.symbol = symbol;
             this.left = this.right = null;
         }
    }
}
