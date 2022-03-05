public class BinaryTreeCameras {
    private int numCameras;

    // Returns number of camera needed from parent
    // 1: child is not covered and need camera from parent
    // 0: child is covered, so parent camera is optional
    // -1: child has camera, so parent is already covered
    private int coverNode(TreeNode node) {
        if (node.left == null && node.right == null) return 1;  // Don't place a camera at a leaf node. Placing a camera at its parent is always better
        boolean childNeedCamera = false;
        boolean childHasCamera = false;
        if (node.left != null) {
            switch(coverNode(node.left)) {
                case 1:
                    childNeedCamera = true;
                    break;
                case -1:
                    childHasCamera = true;
                    break;
            }
        }
        if (node.right != null) {
            switch (coverNode(node.right)) {
                case 1:
                    childNeedCamera = true;
                    break;
                case -1:
                    childHasCamera = true;
                    break;
            }
        }
        if (childNeedCamera) {
            ++numCameras;
            return -1;
        } else if (childHasCamera) {
            return 0;
        } else {
            return 1;
        }

    }

    public int minCameraCover(TreeNode root) {
        numCameras = 0;
        int rootNeedCamera = coverNode(root);
        if (rootNeedCamera > 0) ++numCameras;
        return numCameras;
    }
}
