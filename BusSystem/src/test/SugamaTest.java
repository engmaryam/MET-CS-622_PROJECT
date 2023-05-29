package test;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.Sugama;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class SugamaTest {
    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @Test
    public void testDisplaySeatMatrix() {
        Sugama sugama = new Sugama(); // Create an instance of the Sugama class

        // Set up the seat matrix with some test data
        sugama.rows = 3;
        sugama.columns = 3;
        sugama.seatmatrix = new char[][] {
                {'X', 'O', 'O'},
                {'O', 'X', 'O'},
                {'O', 'O', 'X'}
        };

        // Call the displayseatmatrix method
        sugama.displayseatmatrix();

        // Assert the expected output
        String expectedOutput = "XOO\nOXO\nOOX\n";
        Assert.assertEquals(expectedOutput, output.toString());
    }

    // Add more test methods for other methods in the Sugama class
}


