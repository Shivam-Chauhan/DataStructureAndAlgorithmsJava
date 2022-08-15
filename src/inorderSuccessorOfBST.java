//public class inorderSuccessorOfBST {
//    // Time Complexity :- O(Log(N))
//    // Space Complexity :- O(1) + Auxillary Space Of Recursion Stack
//    // link :- https://practice.geeksforgeeks.org/problems/inorder-successor-in-bst/1
//    public Node inorderSuccessor(Node root, Node x) {
//        Node ans = null;
//        while (root != null) {
//            if (root.data > x.data) {
//                ans = root;
//                root = root.left;
//            } else {
//                root = root.right;
//            }
//        }
//        return ans;
//    }
//}
