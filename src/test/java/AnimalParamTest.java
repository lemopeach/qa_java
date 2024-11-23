import com.example.Animal;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(Parameterized.class)
public class AnimalParamTest {

    Animal animal;

    private String animalKind;
    private List<String> expectedResult;
    private boolean expectException;
    private String expectedExceptionMessage;

    public AnimalParamTest(List<String> expectedResult, String animalKind, boolean expectException, String expectedExceptionMessage) {
        this.expectedResult = expectedResult;
        this.animalKind = animalKind;
        this.expectException = expectException;
        this.expectedExceptionMessage = expectedExceptionMessage;
    }

    @Parameterized.Parameters(name = "expectedResult = {0}, animalKind = {1}, expectedException = {2}, exceptedExceptionMessage = {3}")
    public static Object[][] getData(){
        return new Object[][]{
                {List.of("Трава", "Различные растения"),"Травоядное", false, null},
                {List.of("Животные", "Птицы", "Рыба"),"Хищник", false, null},
                {null,"Насекомое", true, "Неизвестный вид животного, используйте значение Травоядное или Хищник"}
        };
    }


    @Before
    public void setAnimal(){
        animal = new Animal();
    }

    @Test
    public void getFoodTest() throws Exception {
        if(expectException) {
            Exception exception = assertThrows(Exception.class, () -> animal.getFood(animalKind));
            String actualExceptionMessage = exception.getMessage();
            assertEquals(expectedExceptionMessage, actualExceptionMessage);
        } else {
            List<String> actualResult = animal.getFood(animalKind);
            assertEquals(expectedResult, actualResult);
        }
    }
}
