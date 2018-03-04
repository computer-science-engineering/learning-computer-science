package InterviewBit.src.Courses.Programming.Level6_HeapsAndMaps.Problems.Heapmap.LruCache.Java;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class SolutionTest {
    
    @BeforeEach
    public void setUp() throws Exception {
    }
    
    @AfterEach
    public void tearDown() throws Exception {
    }
    
    @Test
    public void TrivialCase1() {
        Solution solution = new Solution(2);
        assertTimeout(Duration.ofMillis(500), () -> {
            solution.set(1, 10);
            solution.set(5, 12);
            assertEquals(12, solution.get(5));
            assertEquals(10, solution.get(1));
            assertEquals(-1, solution.get(10));
            solution.set(6, 14);
            assertEquals(-1, solution.get(5));
        });
    }
}