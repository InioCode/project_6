import com.example.Feline;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import org.junit.Assert;

@RunWith(MockitoJUnitRunner.class)
public class TestFeline {

    @Spy
    private Feline spyFeline;

    Feline realFeline = new Feline();

   @Test
    public void eatMeatCallGetFoodWithReturnAnimalKind(){
       try {
           spyFeline.eatMeat();
       } catch (Exception e) {
           Assert.assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", e.getMessage());
       }

       try {
           Mockito.verify(spyFeline, Mockito.times(1)).getFood("Хищник");
       } catch (Exception e) {
           Assert.assertEquals("Неизвестный вид животного, используйте значение Травоядное или Хищник", e.getMessage());
       }
   }

   @Test
    public void getFamilyReturnCats(){
       Assert.assertEquals("Кошачьи",realFeline.getFamily());
   }

   @Test
    public void getKittensWithThreeReturnThree(){
       spyFeline.getKittens(3);
       Mockito.verify(spyFeline,Mockito.times(1)).getKittens(3);
   }

   @Test
    public void getKittensWithoutNumberReturnOne(){
       spyFeline.getKittens();
       Mockito.verify(spyFeline,Mockito.times(1)).getKittens(1);
   }
}
