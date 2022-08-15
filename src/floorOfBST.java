//public class floorOfBST {
//    // Time Complexity :- O(Log(N))
//    // Space Complexity :- O(1) + Auxillary Space Of Recursion Stack
//    // link :- https://www.codingninjas.com/codestudio/problems/floor-from-bst_920457?leftPanelTab=0
//    public static int floorInBST(TreeNode<Integer> root, int X) {
//        int floor = -1;
//        while (root != null) {
//            if (root.data == X) return X;
//            if (root.data > X) root = root.left;
//            else {
//                floor = root.data;
//                root = root.right;
//            }
//        }
//        return floor;
//    }
//}
