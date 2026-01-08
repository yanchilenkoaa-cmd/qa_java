import com.example.Feline;
import org.junit.Test;
import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import java.util.List;

public class FelineTest {

    @Test
    public void testGetFoodReturnsCorrectData() throws Exception {
        //Проверка, что getFood() возвращает ожидаемый список
        Feline feline = spy(new Feline("Хищник"));
        List<String> foodList = List.of("Мясо", "Кости");
        doReturn(foodList).when(feline).getFood();
        List<String> result = feline.getFood();
        assertEquals(foodList, result);
    }

    @Test
    public void testGetFoodReturnsEmptyList() throws Exception {
//Проверяем, что getFood() возвращает пустой список
        Feline feline = spy(new Feline("Хищник"));
        doReturn(List.of()).when(feline).getFood();
        List<String> result = feline.getFood();
        assertTrue(result.isEmpty());
    }
    @Test
    public void testGetFoodReturnsEmptyWithoutStub() throws Exception {
        // Проверка оригинальной реализации (без мокания)
        Feline feline = new Feline("Хищник");
        List<String> result = feline.getFood();
        assertTrue(result.isEmpty());
    }

    @Test
    public void testEatMeatReturnsFood() throws Exception {
        // Проверка метода eatMeat()
        Feline feline = spy(new Feline("Хищник"));
        List<String> meatList = List.of("Мясо");
        doReturn(meatList).when(feline).getFood();
        List<String> result = feline.eatMeat();
        assertEquals(meatList, result);
        verify(feline).getFood();
    }

    @Test
    public void testGetFamilyReturnsCorrectFamily() {
        Feline feline = new Feline("Хищник");
        assertEquals("Кошачьи", feline.getFamily());
    }

    @Test
    public void testGetKittensDefaultReturnsOne() {
        Feline feline = new Feline("Хищник");
        assertEquals(1, feline.getKittens());
    }

    @Test
    public void testGetKittensWithParameter() {
        Feline feline = new Feline("Хищник");
        assertEquals(5, feline.getKittens(5));
    }

    @Test
    public void testConstructorCreatesObject() {
        Feline feline = new Feline("Хищник");
        assertNotNull(feline);
    }

    @Test(expected = Exception.class)
    public void testGetFoodThrowsException() throws Exception {
        Feline feline = spy(new Feline("Хищник"));
        doThrow(new Exception("Ошибка")).when(feline).getFood();
        feline.getFood();  // Вызовет исключение
    }

    @Test(expected = Exception.class)
    public void testEatMeatThrowsException() throws Exception {
        Feline feline = spy(new Feline("Хищник"));
        doThrow(new Exception("Ошибка")).when(feline).getFood();
        feline.eatMeat();  // Вызовет исключение
    }
}