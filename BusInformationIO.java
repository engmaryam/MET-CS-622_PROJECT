package main;

import java.io.*;

public class BusInformationIO {

    private static String FILE_NAME;

    /**
     * Constructs a BusInformationIO object with the specified file name.
     *
     * @param fileName the name of the file to be used for reading and writing bus information
     */
    public BusInformationIO(String fileName) {
        FILE_NAME = fileName;
    }

    /**
     * Writes bus information to the file.
     *
     * @param busInformation the information to be written
     * @throws IOException if an error occurs while writing the file
     * @precondition busInformation is not null
     * @postcondition the bus information is written to the file
     */
    public static void writeBusInformation(String busInformation) throws IOException {
        if (busInformation == null) {
            throw new IllegalArgumentException("Bus information cannot be null.");
        }

        FileWriter fileWriter = new FileWriter(FILE_NAME, true);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        bufferedWriter.write(busInformation);
        bufferedWriter.newLine();

        // Close the resources
        bufferedWriter.close();
        fileWriter.close();

        System.out.println("Bus information written to file successfully.");
    }

    /**
     * Reads and displays bus information from the file.
     *
     * @throws FileNotFoundException if the file does not exist
     * @throws IOException           if an error occurs while reading the file
     * @precondition the bus information file exists
     * @postcondition the bus information is displayed on the console
     */
    public static void readBusInformation() throws FileNotFoundException, IOException {
        FileReader fileReader = new FileReader(FILE_NAME);
        BufferedReader bufferedReader = new BufferedReader(fileReader);

        String line;
        while ((line = bufferedReader.readLine()) != null) {
            System.out.println(line);
        }

        // Close the resources
        bufferedReader.close();
        fileReader.close();
    }
}
