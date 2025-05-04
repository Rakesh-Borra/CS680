package umbcs680.hw10.car;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class ComparatorTest {

	private static List<Car> carList;

    @BeforeAll
    static void setUp() {
        carList = new ArrayList<>();
        carList.add(new Car("Civic", "Honda", 5000, 2025, 22000));
        carList.add(new Car("Corolla", "Toyota", 8000, 2022, 21000));
        carList.add(new Car("Accord", "Honda", 12000, 2024, 24000));
        carList.add(new Car("Camry", "Toyota", 10000, 2019, 23000));
        carList.add(new Car("Altima", "Nissan", 15000, 2020, 20000));
    }
    
    @Test
    public void testMileageComparator() {

    	String[] expected = {"Civic", "Corolla", "Camry", "Accord", "Altima"};
    	Collections.sort(carList, new MileageComparator());
    	String[] actual = new String[carList.size()];
        for (int i = 0; i < carList.size(); i++) {
        	actual[i] = carList.get(i).getModel();
        }
        assertArrayEquals(expected, actual);
    }


    @Test
    public void testYearComparator() {

    	String[] expected = {"Civic", "Accord", "Corolla", "Altima", "Camry"};
    	Collections.sort(carList, new YearComparator());
    	String[] actual = new String[carList.size()];
        for (int i = 0; i < carList.size(); i++) {
        	actual[i] = carList.get(i).getModel();
        }
        assertArrayEquals(expected, actual);
    }

    
    @Test
    public void testPriceComparator() {

    	String[] expected = {"Altima", "Corolla", "Civic", "Camry", "Accord"};
    	Collections.sort(carList, new PriceComparator());
    	String[] actual = new String[carList.size()];
        for (int i = 0; i < carList.size(); i++) {
        	actual[i] = carList.get(i).getModel();
        }
        assertArrayEquals(expected, actual);
    }



    @Test
    public void testParetoComparator() {
    	String[] expected = {"Civic", "Corolla", "Altima","Accord",  "Camry"};
    	for(Car car :  carList){
    		car.setDominationCount(carList); 
    	}
    	Collections.sort(carList, new ParetoComparator());
    	
    	String[] actual = new String[carList.size()];
        for (int i = 0; i < carList.size(); i++) {
        	actual[i] = carList.get(i).getModel();
        }
        assertArrayEquals(expected, actual);
    }
    

}
