import com.example.Cat;
import com.example.Feline;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;
@RunWith(MockitoJUnitRunner.class)
public class TestCat {

    @Spy
    private Feline SpyFeline = new Feline();
    Cat cat = new Cat(SpyFeline);

    @Test
    public void getFoodReturnListOfFood() throws Exception {
        Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), cat.getFood());
    }

    @Test
    public void getSoundReturnMeow(){
        Assert.assertEquals("Мяу",cat.getSound());
    }
}
