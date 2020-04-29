package EducativeIo.Courses.GrokkingTheCodingInterview.Ch05_MergeIntervals.PC1_MinimumMeetingRooms.Java;

import static org.junit.jupiter.api.Assertions.*;
import java.time.Duration;
import java.util.ArrayList;
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
        List<Meeting> meetings = new ArrayList<Meeting>() {
            private static final long serialVersionUID = 1L;

            {
                add(new Meeting(1, 4));
                add(new Meeting(2, 5));
                add(new Meeting(7, 9));
            }
        };
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 2;
            int actual = Solution.findMinimumMeetingRooms(meetings);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        List<Meeting> meetings = new ArrayList<Meeting>() {
            private static final long serialVersionUID = 1L;

            {
                add(new Meeting(6, 7));
                add(new Meeting(2, 4));
                add(new Meeting(8, 12));
            }
        };
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 1;
            int actual = Solution.findMinimumMeetingRooms(meetings);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase3() {
        List<Meeting> meetings = new ArrayList<Meeting>() {
            private static final long serialVersionUID = 1L;

            {
                add(new Meeting(1, 4));
                add(new Meeting(2, 3));
                add(new Meeting(3, 6));
            }
        };
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 2;
            int actual = Solution.findMinimumMeetingRooms(meetings);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase4() {
        List<Meeting> meetings = new ArrayList<Meeting>() {
            private static final long serialVersionUID = 1L;

            {
                add(new Meeting(4, 5));
                add(new Meeting(2, 3));
                add(new Meeting(2, 4));
                add(new Meeting(3, 5));
            }
        };
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 2;
            int actual = Solution.findMinimumMeetingRooms(meetings);
            assertEquals(expected, actual);
        });
    }
}
