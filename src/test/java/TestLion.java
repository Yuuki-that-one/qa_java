import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

@RunWith(MockitoJUnitRunner.class)
public class TestLion {


    @Mock
    private Feline feline;

    @Test
    public void checkGetKittens() throws Exception {
        Lion lion = new Lion("Самка", feline);

        Mockito.when(feline.getKittens()).thenReturn(1);

        Assert.assertEquals(1, lion.getKittens());
    }


    @Test
    public void checkLionGetFood() throws Exception {
        Lion lion = new Lion("Самка", feline);
        List<String> food = List.of("Животные", "Птицы", "Рыба");

        Mockito.when(feline.eatMeat()).thenReturn(food);
        Assert.assertEquals(food, lion.getFood());
    }

    @Test
    public void checkDoesHaveManeThrowsException() {

        Exception exception = assertThrows(Exception.class, () -> {
            Lion lion = new Lion("Собака", feline);
            lion.doesHaveMane();
        });
        String expectedMessage = "Используйте допустимые значения пола животного - самец или самка";
        String actualMessage = exception.getMessage();
        assertEquals(expectedMessage, actualMessage);

    }

}
