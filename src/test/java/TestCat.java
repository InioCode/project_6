import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
@RunWith(MockitoJUnitRunner.class)
public class TestCat {

        @Mock
        private Cat mockCat;
        @Mock
        private Feline mockFeline;

        Cat cat = new Cat(mockFeline);

    @Test
    public void getSoundReturnMeow(){
        Assert.assertEquals("Мяу",cat.getSound());
    }

    @Test
    public void getFoodReturnException(){

        try {
            Mockito.when(mockCat.getFood()).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        try {
            Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), mockCat.getFood());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
