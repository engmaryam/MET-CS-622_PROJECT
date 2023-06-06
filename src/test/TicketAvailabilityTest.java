package test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import main.MainJframProjectOutput;
import main.User;

import java.io.FileNotFoundException;

public class TicketAvailabilityTest {

    @Test
    public void testReadTicketAvailabilityFromFile() throws FileNotFoundException {
        // Arrange
        User user = new User("John", "Doe", "123456789", "john.doe@example.com");
        String source = "Source";
        String destination = "Destination";
        String date = "2023-06-05";
        String expected = "No Ticket  available for this information ";

        // Act
        String actual = MainJframProjectOutput.readTicketAvailabilityFromFile(source, destination, date);

        // Assert
        Assertions.assertEquals(expected, actual);
    }
}
