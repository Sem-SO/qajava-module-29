import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.util.Calendar;


public class PersonTest {

    void currentTime() {
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ssss");
        System.out.println(dateFormat.format(calendar.getTime()));
    }

    @BeforeClass
    void beforeClass() {
        System.out.print("Test start: ");
        currentTime();
    }

    @AfterClass
    void afterTime() {
        System.out.print("Test end: ");
        currentTime();
    }

    // согласно условию возраст тинейджера от 13 до 19 лет
    @DataProvider(name = "testData")
    Object[][] testData() {
        return new Object[][] {
                 // проверка нулевых и отрицательных значений
                {-1, false},
                {0, false},
                // проверка граничных значений для 13
                {12, false},
                {13,true},
                {15,true},
                // проверка граничных значений для 19
                {18,true},
                {19,false},
                {20,false}
        };
    }

    @Test(dataProvider = "testData")
    void testPersonIsTeenager(int age, boolean expected) {
        boolean result = Person.isTeenager(age);
        System.out.println("For age " + age + ": " + "Actual result: " + result + " / " + "Expected result: " + expected);
        assertEquals(result, expected);
    }
}
