import com.example.Cat;
import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class CatTest {

    Cat cat;

    @Mock
    Feline feline;

    @Test
    public void getSoundTest(){
        cat = new Cat (feline);
        String expectedResult = "Мяу";
        String actualResult = cat.getSound();
        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void getFoodTest() throws Exception {
        cat = new Cat (feline);
        List<String> expectedResult = List.of("Животные", "Птицы", "Рыба");

        Mockito.when(feline.eatMeat()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        List<String> actualResult = cat.getFood();

        assertEquals(expectedResult,actualResult);
    }
}
