package umbcs680.prime;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.LinkedList;

public class PrimeGeneratorTest{

    @Test
    public void generatePrimesMethod() {
        PrimeGenerator put = new PrimeGenerator(1, 10);
        put.generatePrimes();
        Long[] expectedPrimes = {2L, 3L, 5L, 7L};
        assertArrayEquals( expectedPrimes, put.getPrimes().toArray() );
    }

    @Test
    public void isEvenNumber(){
        PrimeGenerator put =new PrimeGenerator(1,10);
        assertFalse(put.isEven(5));
        assertTrue(put.isEven(6));
    }

    @Test
    public void isPrimeNumber(){
        PrimeGenerator put =new PrimeGenerator(1,10);
        assertTrue(put.isPrime(3));
        assertFalse(put.isPrime(8));
    }

    @Test
    public void ConstructorException(){
        try{
            PrimeGenerator put = new PrimeGenerator(7,-1);
            put.generatePrimes();
        } catch (Exception ex) {

            assertEquals("Wrong input values: from=7 to=-1", ex.getMessage());
        }
    }

}