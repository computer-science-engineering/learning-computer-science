package EducativeIo.Courses.GrokkingTheCodingInterview.Ch15_KWayMerge.P4_SmallestNumberRange.Java;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SolutionTest {

    Solution solution;

    @BeforeEach
    public void setUp() throws Exception {
        solution = new Solution();
    }

    @AfterEach
    public void tearDown() throws Exception {
        solution = null;
    }

    @Test
    public void MainFunction() {
        assertTimeout(Duration.ofMillis(1000), () -> {
            String[] args = new String[0];
            assertAll(() -> Solution.main(args));
        });
    }

    @Test
    public void TrivialCase1() {
        Integer[] l1 = new Integer[] {1, 5, 8};
        Integer[] l2 = new Integer[] {4, 12};
        Integer[] l3 = new Integer[] {7, 8, 10};
        List<Integer[]> lists = new ArrayList<Integer[]>();
        lists.add(l1);
        lists.add(l2);
        lists.add(l3);
        assertTimeout(Duration.ofMillis(1000), () -> {
            int[] expected = {4, 7};
            int[] actual = Solution.findSmallestRange(lists);
            assertArrayEquals(expected, actual);
        });
    }
}
