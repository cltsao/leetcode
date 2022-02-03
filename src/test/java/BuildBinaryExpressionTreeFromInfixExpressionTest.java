import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BuildBinaryExpressionTreeFromInfixExpressionTest {
    BuildBinaryExpressionTreeFromInfixExpression bbetfie = new BuildBinaryExpressionTreeFromInfixExpression();

    @Test
    public void testExample1() {
        Node root = bbetfie.expTree("3*4-2*5");
        assertEquals('-', root.val);
        assertEquals('*', root.left.val);
        assertEquals('*', root.right.val);
        assertEquals('3', root.left.left.val);
        assertEquals('4', root.left.right.val);
        assertEquals('2', root.right.left.val);
        assertEquals('5', root.right.right.val);
    }

    @Test
    public void testExample2() {
        Node root = bbetfie.expTree("2-3/(5*2)+1");
        assertEquals('+', root.val);
        assertEquals('-', root.left.val);
        assertEquals('1', root.right.val);
        assertEquals('2', root.left.left.val);
        assertEquals('/', root.left.right.val);
        assertEquals('3', root.left.right.left.val);
        assertEquals('*', root.left.right.right.val);
        assertEquals('5', root.left.right.right.left.val);
        assertEquals('2', root.left.right.right.right.val);
    }

    @Test
    public void testExample3() {
        Node root = bbetfie.expTree("1+2+3+4+5");
        assertEquals('+', root.val);
        assertEquals('+', root.left.val);
        assertEquals('5', root.right.val);
        assertEquals('+', root.left.left.val);
        assertEquals('4', root.left.right.val);
        assertEquals('+', root.left.left.left.val);
        assertEquals('3', root.left.left.right.val);
        assertEquals('1', root.left.left.left.left.val);
        assertEquals('2', root.left.left.left.right.val);
    }
}
