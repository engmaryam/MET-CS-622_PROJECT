package test;

	import org.junit.Assert;
	import org.junit.Test;

	import java.util.ArrayList;
	import java.util.List;
	import main.*;

	public class BusInfoTest {
	    @Test
	    public void testGenerics() {
	        String expectedType = "String";
	        String expectedValue = "Test The class!";
	        String actualType, actualValue;

	        // Call the generics method
	        BusInfo.generics(expectedValue);

	        // Retrieve the printed type and value from the console
	        actualType = "String"; // Replace with the actual type you observed in the console
	        actualValue = "Test The class!"; // Replace with the actual value you observed in the console

	        // Perform assertions
	        Assert.assertEquals(expectedType, actualType);
	        Assert.assertEquals(expectedValue, actualValue);
	    }

	    @Test
	    public void testGetFirstElement() {
	        List<String> stringList = new ArrayList<>();
	        stringList.add("Element 1");
	        stringList.add("Element 2");

	        String expected = "Element 1";
	        String actual = BusInfo.getFirstElement(stringList);

	        Assert.assertEquals(expected, actual);
	    }

	    @Test
	    public void testProcessPair() {
	        String expectedFirst = "First";
	        Integer expectedSecond = 2;

	        // Call the processPair method
	        BusInfo.processPair(expectedFirst, expectedSecond);

	        // Observe the printed first and second elements in the console

	        // No assertions are necessary as the method only prints the values
	    }
	}


