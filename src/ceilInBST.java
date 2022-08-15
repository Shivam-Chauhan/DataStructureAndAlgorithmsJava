//public class ceilInBST {
//
//    // Time Complexity :- O(Log(N))
//    // Space Complexity :- O(1) + Auxillary Space Of Recursion Stack
//    // link :- https://www.codingninjas.com/codestudio/problems/ceil-from-bst_920464?leftPanelTab=1
//    public static int findCeil(TreeNode<Integer> node, int x) {
//        int ceil = -1;
//        while (node != null) {
//            if (node.data == x) {
//                return node.data;
//            }
//            if (node.data > x) {
//                ceil = node.data;
//                node = node.left;
//            } else {
//                node = node.right;
//            }
//        }
//        return ceil;
//
//    }
//}
