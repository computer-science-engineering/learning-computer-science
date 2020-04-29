package EducativeIo.Courses.GrokkingTheCodingInterview.Ch14_TopKElements.P3_KClosestPointsToTheOrigin.Java;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

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
        Point[] points = new Point[] {new Point(1, 3), new Point(3, 4), new Point(2, -1)};
        int k = 2;
        assertTimeout(Duration.ofMillis(1000), () -> {
            List<Integer> expected = Arrays.asList(1, 3, 2, -1);
            List<Point> result = Solution.findClosestPoints(points, k);
            List<Integer> actual = new ArrayList<>();
            for (Point p : result) {
                actual.add(p.x);
                actual.add(p.y);
            }
            assertEquals(expected, actual);
        });
    }
}
