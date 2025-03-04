package umbcs680.prime;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class SingletonPrimeGeneratorTest{

    // here we need to test singleton instances using assertSame since we can check object references using it.

    @Test
    public void checkingInstances(){
        SingletonPrimeGenerator sput = SingletonPrimeGenerator.getInstance(1,10);
        SingletonPrimeGenerator sput1= SingletonPrimeGenerator.getInstance(1,10);
        assertSame(sput,sput1);
    }

    // here, we create and assign the object instance instead of constructor for every method
    @Test
    public void generatePrimesMethod() {
        SingletonPrimeGenerator sput = SingletonPrimeGenerator.getInstance(1, 10);
        sput.generatePrimes();
        Long[] expectedPrimes = {2L, 3L, 5L, 7L};
        assertArrayEquals( expectedPrimes, sput.getPrimes().toArray() );
    }

    @Test
    public void isEvenNumber(){
        SingletonPrimeGenerator sput = SingletonPrimeGenerator.getInstance(1, 10);
        assertFalse(sput.isEven(5));
        assertTrue(sput.isEven(6));
    }

    @Test
    public void isPrimeNumber(){
        SingletonPrimeGenerator sput = SingletonPrimeGenerator.getInstance(1, 10);
        assertTrue(sput.isPrime(3));
        assertFalse(sput.isPrime(8));
    }

    @Test
    public void ConstructorException(){
        try{
            SingletonPrimeGenerator sput = SingletonPrimeGenerator.getInstance(7, -1);
            sput.generatePrimes();
        } catch (Exception ex) {

            assertEquals("Wrong input values: from=7 to=-1", ex.getMessage());
        }
    }

}