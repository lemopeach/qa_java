import com.example.Feline;
import com.example.Lion;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class LionParamTest {
    Lion lion;

    private String animalSex;
    private boolean expectedResult;
    private boolean expectedException;
    private String expectedExceptionMessage;

    public LionParamTest(String animalSex, boolean expectedResult, boolean expectedException, String expectedExceptionMessage) {
        this.animalSex = animalSex;
        this.expectedResult = expectedResult;
        this.expectedException = expectedException;
        this.expectedExceptionMessage = expectedExceptionMessage;
    }

    @Parameterized.Parameters(name = "animalSex = {0}, expectedResult = {1}, expectedException = {2}, exceptedExceptionMessage = {3}")
    public static Object[][] getData(){
        return new Object[][]{
                {"Самец",true, false, null },
                {"Самка",false, false, null },
                {"Лев", false, true, "Используйте допустимые значения пола животного - самец или самка"}
        };
    }

    Feline feline = Mockito.mock(Feline.class);

    @Test
    public void doesHaveManeTest() throws Exception {
        if(expectedException){
            Exception exception = assertThrows(Exception.class, () -> new Lion(animalSex, feline));
            String actualExceptionMessage = exception.getMessage();
            assertEquals(expectedExceptionMessage, actualExceptionMessage);
        }
        else{
            lion = new Lion(animalSex, feline);
            boolean actualResult = lion.doesHaveMane();
            if (expectedResult){
                assertTrue(actualResult);
            } else {
                assertFalse(actualResult);
            }
        }
    }
}
