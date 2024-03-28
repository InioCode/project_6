import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;


@RunWith(MockitoJUnitRunner.class)
public class TestLion {
    static Feline stabFeline = Mockito.mock(Feline.class);
    private Lion realLion;

    @Before
    public void lionCreateObject(){
        try {
            this.realLion = new Lion("Самец", stabFeline);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void getKittensReturnNumberKittens(){
        Mockito.when(stabFeline.getKittens()).thenReturn(1);
        Assert.assertEquals(1, realLion.getKittens());
    }

    @Test
    public void getFoodReturnPredator(){
        try {
            Mockito.when(stabFeline.getFood(Mockito.anyString())).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        } catch (Exception e) {
            Assert.assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", e.getMessage());
        }
        try {
            Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), realLion.getFood());
        } catch (Exception e) {
            Assert.assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", e.getMessage());
        }
    }
}
