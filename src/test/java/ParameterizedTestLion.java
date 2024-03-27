import com.example.Feline;
import com.example.Lion;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.Mockito;

@RunWith(Parameterized.class)
public class ParameterizedTestLion {
    static Feline stabFeline = Mockito.mock(Feline.class);
    private final String sex;
    private Lion realLion;
    public ParameterizedTestLion(String sex, Feline feline){
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
    public void doesHaveManeWithMaleReturnTrue(){
        if (sex.equals("Самец")) {
            Assert.assertEquals( true, realLion.doesHaveMane());
        } else{
            Assert.assertEquals( false, realLion.doesHaveMane());
        }

    }

}
