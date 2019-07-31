import com.playtika.Knight;
import com.playtika.Main;
import org.assertj.core.api.Assertions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;

import static com.playtika.Main.buildArmor;

public class TestForOtherMethods extends Assert {
    @BeforeClass
    public void beforeClass() {

        System.out.println("Test starts:");
    }

    @Test
    public void getWeightSum() {
        int totalWeightSum = 355;
        Assert.assertEquals(totalWeightSum, buildArmor().getWeight());

    }


    @Test
    public void getCostSum() {
        double totalCostSum = 485.0;
        Assert.assertEquals(totalCostSum, buildArmor().getCost());
    }

     @Test
    public void testWriteToFile () throws IOException, ClassNotFoundException {
         Knight knight= new Knight(23,"Art",buildArmor(),"soldier");
         String fileName = "Knight.txt";
         Main.writeToFile(knight, fileName);

         Knight actual = Main.readKnightInfoFromTxtFile(fileName);
         Assertions.assertThat(actual).isEqualToComparingFieldByFieldRecursively(knight);
     }
}