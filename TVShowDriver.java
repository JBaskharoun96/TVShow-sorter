package TVShow;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TVShowDriver {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        int indexCount = 0;
        int numShows = 0;
        String[] content = null;
        String dataLine = null;

        // Edit filename or set path here if needed
        String filename = "tv_shows.csv";

        { // Counting the number of lines in the provided file
            BufferedReader fileRead = new BufferedReader(
                    new FileReader(filename) );

            while (fileRead.readLine() != null) {
                ++numShows;
            }
            --numShows; // first line is header names, so -1
            fileRead.close();
        }

        TVShow[] showsList = new TVShow[numShows];

        // Start reader at beginning again, reading info out this time
        BufferedReader fileRead = new BufferedReader(
                new FileReader(filename) );

        // Reading out headers from first line
        String headerLine = fileRead.readLine();
        String[] headers = headerLine.split(",");

        // Looping through remaining lines, each one has info for a TVShow
        while ((dataLine = fileRead.readLine()) != null) {

            // Splitting out data from csv into array of strings
            content = dataLine.split(",");

            // There are 8 pieces of info per TVShow, same order on each line
            TVShow tmp = new TVShow(content);

            showsList[indexCount] = tmp;
            ++indexCount;
        }
        fileRead.close();
        
        // Construct sort handler with full list of shows from csv
        SortHandler mrSorty = new SortHandler(showsList, headers);


        // Assigned sorts in order:

        System.out.println("Ascending Insertion Sort by Name:");
        mrSorty.insertionSort(0, false);
        mrSorty.printShows(new int[]{0, 1, 6, 7});

        System.out.println();

        System.out.println("Descending Insertion Sort by Seasons:");
        mrSorty.insertionSort(2, true);
        mrSorty.printShows(new int[]{0, 1, 2});

        System.out.println("Ascending Selection Sort by Year:");
        mrSorty.selectionSort(1, false);
        mrSorty.printShows(new int[]{0, 1, 2});

        System.out.println("Descending Selection Sort by Genre:");
        mrSorty.selectionSort(5, true);
        mrSorty.printShows(new int[]{0, 3, 5});

        for (int i = 0; i < headers.length; i++) {
            // System.out.printf("%20s ", headers[i]);
        }

        for (int j = 0; j < numShows; ++j) {

            // System.out.println(showsList[j].toString());
        }

    }

}
