package Miscellaneous.src.Problems.Programming.SortCommaSeparatedProducts.Java;

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
        assertTimeout(Duration.ofMillis(500), () -> {
            String[] args = new String[0];
            assertAll(() -> Solution.main(args));
        });
    }

    @Test
    public void TrivialCase1() {
        String[] INPUT = new String[] {"Selfie Stick,98,29", "iPhone Case,90,15",
                "Fire TV Stick,48,49", "Wyze Cam,48,25", "Water Filter,56,49",
                "Blue Light Blocking Glasses,90,16", "Ice Maker,47,119", "Video Doorbell,47,199",
                "AA Batteries,64,12", "Disinfecting Wipes,37,12", "Baseball Cards,73,16",
                "Winter Gloves,32,112", "Microphone,44,22", "Pet Kennel,5,24",
                "Jenga Classic Game,100,7", "Ink Cartridges,88,45", "Instant Pot,98,59",
                "Hoze Nozzle,74,26", "Gift Card,45,25", "Keyboard,82,19"};
        assertTimeout(Duration.ofMillis(500), () -> {
            // expected = ;
            // actual = Solution.;
            // assertEquals(expected, actual);
        });
    }
}
