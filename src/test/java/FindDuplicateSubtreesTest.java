import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class FindDuplicateSubtreesTest {
    FindDuplicateSubtrees solution = new FindDuplicateSubtrees();

    @Test
    public void testExample1() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(2);
        root.right.left.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        assertThat(List.of(root.right.left, root.right.left.left)).hasSameElementsAs(solution.findDuplicateSubtrees(root));
    }

    @Test
    public void testExample2() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        assertThat(List.of(root.right)).hasSameElementsAs(solution.findDuplicateSubtrees(root));
    }

    @Test
    public void testExample3() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);
        assertThat(List.of(root.right, root.right.left)).hasSameElementsAs(solution.findDuplicateSubtrees(root));
    }
}
