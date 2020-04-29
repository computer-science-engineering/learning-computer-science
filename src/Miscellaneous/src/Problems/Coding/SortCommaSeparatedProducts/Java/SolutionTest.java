package Miscellaneous.src.Problems.Coding.SortCommaSeparatedProducts.Java;

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
        String[] INPUT = new String[] {"Selfie Stick,98,29", "iPhone Case,90,15",
                "Fire TV Stick,48,49", "Wyze Cam,48,25", "Water Filter,56,49",
                "Blue Light Blocking Glasses,90,16", "Ice Maker,47,119", "Video Doorbell,47,199",
                "AA Batteries,64,12", "Disinfecting Wipes,37,12", "Baseball Cards,73,16",
                "Winter Gloves,32,112", "Microphone,44,22", "Pet Kennel,5,24",
                "Jenga Classic Game,100,7", "Ink Cartridges,88,45", "Instant Pot,98,59",
                "Hoze Nozzle,74,26", "Gift Card,45,25", "Keyboard,82,19"};
        assertTimeout(Duration.ofMillis(1000), () -> {
            List<String> expected = Arrays.asList("Jenga Classic Game", "Selfie Stick",
                    "Instant Pot", "iPhone Case", "Blue Light Blocking Glasses", "Ink Cartridges",
                    "Keyboard", "Hoze Nozzle", "Baseball Cards", "AA Batteries", "Water Filter",
                    "Wyze Cam", "Fire TV Stick", "Ice Maker", "Video Doorbell", "Gift Card",
                    "Microphone", "Disinfecting Wipes", "Winter Gloves", "Pet Kennel");
            List<Solution.Item> items = new ArrayList<Solution.Item>();
            for (String eachInput : INPUT) {
                String[] temps = eachInput.split(",");
                Solution.Item temp = new Solution.Item(temps[0], Integer.parseInt(temps[1]),
                        Integer.parseInt(temps[2]));
                items.add(temp);
            }
            List<Solution.Item> resultAll = Solution.getSorted(items);
            List<String> actual = new ArrayList<>();
            for (Solution.Item eachItem : resultAll) {
                actual.add(eachItem.name);
            }
            assertEquals(expected, actual);
        });
    }
}
