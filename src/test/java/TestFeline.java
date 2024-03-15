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

   @Test
    public void getMeatCallGetFoodWithReturnAnimalKind(){
       try {
           spyFeline.eatMeat();
       } catch (Exception e) {
           throw new RuntimeException(e);
       }

       try {
           Mockito.verify(spyFeline, Mockito.times(1)).getFood("Хищник");
       } catch (Exception e) {
           throw new RuntimeException(e);
       }

   }

   @Test
    public void getFamilyReturnCats(){
       Assert.assertEquals("Кошачьи",spyFeline.getFamily());
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
