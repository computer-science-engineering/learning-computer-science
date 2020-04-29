package InterviewBit.src.Courses.Programming.Level3_BitManipulation.Problems.Bucketing.MinXorValue.Java;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;
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
        int[] input = {0, 2, 5, 7};
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 2;
            int actual = Solution.findMinXor(input);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void TrivialCase2() {
        int[] input = {15, 5, 1, 10, 2};
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 3;
            int actual = Solution.findMinXor(input);
            assertEquals(expected, actual);
        });
    }

    @Test
    public void SpecialCase1() {
        int[] input = {488769, 723905, 139136, 260545, 21376, 86209, 509505, 811457, 1105729, 1183809, 80577, 190720, 718017, 36289, 251008, 1156161, 240961, 876481, 471296, 1265985, 620225, 1089024, 504832, 119936, 700993, 44097, 578753, 177857, 321536, 765889, 895488, 252672, 800384, 91904, 1175680, 114113, 1019457, 399553, 551745, 844672, 1039744, 1209088, 1209921, 122945, 718592, 758400, 825281, 1159168, 821760, 1161665, 729088, 298305, 1028545, 614784, 1096513, 1260160, 298112, 342209, 396160, 1145344, 1081537, 573312, 251585, 69632, 1115648, 43904, 1266048, 665728, 737985, 1228160, 85760, 653184, 1142465, 271297, 1234625, 1101568, 707584, 263424, 1023360, 530944, 661441};
        assertTimeout(Duration.ofMillis(1000), () -> {
            int expected = 193;
            int actual = Solution.findMinXor(input);
            assertEquals(expected, actual);
        });
    }
}