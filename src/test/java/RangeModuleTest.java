import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RangeModuleTest {
    @Test
    public void testExample1() {
        RangeModule rangeModule = new RangeModule();
        rangeModule.addRange(10, 20);
        rangeModule.removeRange(14, 16);
        assertTrue(rangeModule.queryRange(10, 14)); // return True,(Every number in [10, 14) is being tracked)
        assertFalse(rangeModule.queryRange(13, 15)); // return False,(Numbers like 14, 14.03, 14.17 in [13, 15) are not being tracked)
        assertTrue(rangeModule.queryRange(16, 17)); // return True, (The number 16 in [16, 17) is still being tracked, despite the remove operation)
    }


    @Test
    public void testExample2() {
        RangeModule rangeModule = new RangeModule();
        assertFalse(rangeModule.queryRange(21, 34));
        assertFalse(rangeModule.queryRange(27, 87));
        rangeModule.addRange(44, 53);
        rangeModule.addRange(69, 89);
        assertFalse(rangeModule.queryRange(23, 26));
        assertTrue(rangeModule.queryRange(80, 84));
        assertFalse(rangeModule.queryRange(11,12));
        rangeModule.removeRange(86,91);
        rangeModule.addRange(87,94);
        rangeModule.removeRange(34,52);
        rangeModule.addRange(1,59);
        rangeModule.removeRange(62,96);
        rangeModule.removeRange(34,83);
        assertFalse(rangeModule.queryRange(11,59));
        assertFalse(rangeModule.queryRange(59,79));
        assertTrue(rangeModule.queryRange(1,13));
        assertTrue(rangeModule.queryRange(21,23));
        rangeModule.removeRange(9,61);
        rangeModule.addRange(17,21);
        rangeModule.removeRange(4,8);
        assertFalse(rangeModule.queryRange(19,25));
        rangeModule.addRange(71,98);
        rangeModule.addRange(23,94);
        rangeModule.removeRange(58,95);
        assertFalse(rangeModule.queryRange(12,78));
        rangeModule.removeRange(46,47);
        rangeModule.removeRange(50,70);
        rangeModule.removeRange(84,91);
        rangeModule.addRange(51,63);
        rangeModule.removeRange(26,64);
        rangeModule.addRange(38,87);
        assertTrue(rangeModule.queryRange(41,84));
        assertTrue(rangeModule.queryRange(19,21));
        assertFalse(rangeModule.queryRange(18,56));
        assertFalse(rangeModule.queryRange(23,39));
        assertFalse(rangeModule.queryRange(29,95));
        rangeModule.addRange(79, 100);
        rangeModule.removeRange(76,82);
        rangeModule.addRange(37,55);
        rangeModule.addRange(30,97);
        rangeModule.addRange(1,36);
        assertTrue(rangeModule.queryRange(18,96));
        rangeModule.removeRange(45,86);
        rangeModule.addRange(74,92);
        assertFalse(rangeModule.queryRange(27,78));
        rangeModule.addRange(31,35);
        assertTrue(rangeModule.queryRange(87,91));
        rangeModule.removeRange(37,84);
        rangeModule.removeRange(26,57);
        rangeModule.addRange(65,87);
        rangeModule.addRange(76,91);
        assertFalse(rangeModule.queryRange(37,77));
        assertFalse(rangeModule.queryRange(18,66));
        rangeModule.addRange(22,97);
        rangeModule.addRange(2,91);
        rangeModule.removeRange(82,98);
        rangeModule.removeRange(41,46);
        rangeModule.removeRange(6,78);
        assertFalse(rangeModule.queryRange(44,80));
        rangeModule.removeRange(90,94);
        rangeModule.removeRange(37,88);
        rangeModule.addRange(75,90);
        assertFalse(rangeModule.queryRange(23,37));
        rangeModule.removeRange(18,80);
        rangeModule.addRange(92,93);
        rangeModule.addRange(3,80);
        assertTrue(rangeModule.queryRange(68,86));
        rangeModule.removeRange(68,92);
        assertFalse(rangeModule.queryRange(52,91));
        rangeModule.addRange(43,53);
        rangeModule.addRange(36,37);
        rangeModule.addRange(60,74);
        rangeModule.addRange(4,9);
        rangeModule.addRange(44,80);
        rangeModule.removeRange(85,93);
        rangeModule.removeRange(56,83);
        rangeModule.addRange(9,26);
        assertFalse(rangeModule.queryRange(59,64));
        assertFalse(rangeModule.queryRange(16,66));
        rangeModule.removeRange(29,36);
        rangeModule.removeRange(51,96);
        rangeModule.removeRange(56,80);
        rangeModule.addRange(13,87);
        assertTrue(rangeModule.queryRange(42,72));
        rangeModule.removeRange(6,56);
        assertFalse(rangeModule.queryRange(24,53));
        rangeModule.addRange(43,71);
        rangeModule.removeRange(36,83);
        rangeModule.removeRange(15,45);
        assertFalse(rangeModule.queryRange(10,48));
    }
}
