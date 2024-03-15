import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

import java.util.List;

@RunWith(Parameterized.class)
public class TestLion {
    static Feline stabFeline = Mockito.mock(Feline.class);
    private final String sex;
    private Lion realLion;

    public TestLion(String sex, Feline feline){
        this.sex = sex;
        this.stabFeline = feline;
    }
    @Parameterized.Parameters
    public static Object[] getProperty(){
        return new Object[][]{
                {"Самец",stabFeline},
                {"Самка",stabFeline},
                {"Сумка",stabFeline}
        };
    }

    @Before
    public void lionCreateObject(){
        try {
            this.realLion = new Lion(sex, stabFeline);
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
    public void doesHaveManeWithMaleReturnTrue(){
        if (sex.equals("Самец")) {
            Assert.assertEquals( true, realLion.doesHaveMane());
        } else{
            Assert.assertEquals( false, realLion.doesHaveMane());
        }

    }

    @Test
    public void getFoodReturnPredator(){
        try {
            Mockito.when(stabFeline.getFood(Mockito.anyString())).thenReturn(List.of("Животные", "Птицы", "Рыба"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        try {
            Assert.assertEquals(List.of("Животные", "Птицы", "Рыба"), realLion.getFood());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
