import com.example.Feline;
import com.example.Lion;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

@RunWith(MockitoJUnitRunner.class)
public class LionTest {
    Lion lion;

    @Mock
    Feline feline;

    @Test
    public void getKittensTest() throws Exception {
        lion = new Lion("Самец", feline);

        int expectedResult = 1;
        Mockito.when(feline.getKittens()).thenReturn(1);

        int actualResult = lion.getKittens();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getFoodTest() throws Exception {
        lion = new Lion("Самец", feline);

        List<String> expectedResult = List.of("Трава", "Различные растения");
        Mockito.when(feline.getFood("Хищник")).thenReturn(List.of("Трава", "Различные растения"));

        List<String> actualResult = lion.getFood();

        assertEquals(expectedResult, actualResult);
    }
}
