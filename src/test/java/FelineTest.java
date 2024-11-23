import com.example.Feline;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class FelineTest {
    Feline feline;

    @Before
    public void setFeline(){
        feline = new Feline();
    }

    @Test
    public void getFamilyTest(){
        String expectedResult = "Кошачьи";
        String actualResult = feline.getFamily();
        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void getKittensWOParamTest(){
        int expectedResult = 2;
        int actualResult = feline.getKittens(2);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void getKittensTest() {
        Feline felineSpy = Mockito.spy(new Feline());
        int expectedResult = 1;
        int actualResult = felineSpy.getKittens();
        verify(felineSpy).getKittens(1);
        assertEquals(expectedResult,actualResult);
    }

    @Test
    public void eatMeatTest() throws Exception {
        Feline felineSpy = Mockito.spy(new Feline());
        doReturn(List.of("Животные", "Птицы", "Рыба")).when(felineSpy).getFood("Хищник");
        List<String> actualFood = felineSpy.eatMeat();
        assertEquals(List.of("Животные", "Птицы", "Рыба"), actualFood);
        verify(felineSpy).getFood("Хищник");
    }
}
