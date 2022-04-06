/*  Author: Jonathan Baskharoun
 *  Date: 04/06/2022
 *  Version: Java 1.8
 * 
 *  The TVShowDriver class is the main driver, initializes objects, 
 *  calls methods, and directs program control flow
 */
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

        BufferedReader fileRead;

        // Counting the number of lines in the provided file
        fileRead = new BufferedReader(
                new FileReader(filename));

        while (fileRead.readLine() != null) {
            ++numShows;
        }
        --numShows; // First line is header names, so -1 line
        fileRead.close();

        // Initialize TVShow array size based on counted lines
        TVShow[] showsList = new TVShow[numShows];

        // Start reader at beginning again, reading info out this time
        fileRead = new BufferedReader(
                new FileReader(filename));

        // Reading out headers from first line
        String headerLine = fileRead.readLine();
        String[] headers = headerLine.split(",");

        // Looping through remaining lines, each one has info for a TVShow
        while ((dataLine = fileRead.readLine()) != null) {

            // Splitting out data from csv into array of strings
            content = dataLine.split(",");

            // Use string array with TVShow info to init new TVShow object
            TVShow tmp = new TVShow(content);

            // Add TVShow object to array holding full list of TVShows
            showsList[indexCount] = tmp;
            ++indexCount;
        }
        fileRead.close();

        // Construct sort handler with list of shows from csv
        SortHandler mrSorty = new SortHandler(showsList, headers);

        // Construct search handler with list of shows from csv
        SearchHandler mrSearchy = new SearchHandler(showsList, headers);

        // Sorts

        System.out.println();
        System.out.println("Insertion Sort 1: Ascending Insertion Sort by TV Show Name:");
        mrSorty.insertionSort(0, false);
        mrSorty.printShows(new int[] { 0, 1, 6, 7 });

        System.out.println();
        System.out.println("Insertion Sort 2: Descending Insertion Sort by Seasons:");
        mrSorty.insertionSort(2, true);
        mrSorty.printShows(new int[] { 0, 1, 2 });

        System.out.println();
        System.out.println("Selection Sort 1: Ascending Selection Sort by Year:");
        mrSorty.selectionSort(1, false);
        mrSorty.printShows(new int[] { 0, 1, 2 });

        System.out.println();
        System.out.println("Selection Sort 2: Descending Selection Sort by Genre:");
        mrSorty.selectionSort(5, true);
        mrSorty.printShows(new int[] { 0, 3, 5 });

        System.out.println();
        System.out.println("Merge Sort 1: Descending Merge sort by Network:");
        mrSorty.mergeSortStart(4, true);
        mrSorty.printShows(new int[] { 0, 1, 2, 4 });

        System.out.println();
        System.out.println("Merge Sort 2: Ascending Merge Sort by Episodes:");
        mrSorty.mergeSortStart(3, false);
        mrSorty.printShows(new int[] { 0, 1, 3, 4 });

        // Searches

        System.out.println();
        System.out.println("Sequential Search 1: Sequential Search for 2 Seasons:");
        mrSearchy.sequentialSearchMatch(2, "2");

        System.out.println();
        System.out.println("Sequential Search 2: Sequential Search for >100 Episodes:");
        mrSearchy.sequentialSearchPass(3, "100");

        System.out.println();
        mrSorty.insertionSort(4, false);
        System.out.println("Binary Search 1: Binary Search for CBS Shows:");
        mrSearchy.binarySearchHandler(4, "CBS");

        System.out.println();
        mrSorty.selectionSort(5, false);
        System.out.println("Binary Search 2: Binary Search for Fantasy Shows:");
        mrSearchy.binarySearchHandler(5, "Fantasy");

        System.out.println();
        System.out.println("Binary Search 3: Binary Search for Drama Shows:");
        mrSearchy.binarySearchHandler(5, "Drama");

        // Bonus

        System.out.println();
        System.out.println("Bonus Sort 1: Ascending Sort by Male Lead Last Name:");
        mrSorty.selectionSort(6, false);
        mrSorty.printShows(new int[] { 0, 1, 6, 7 });

        System.out.println();
        System.out.println("Bonus Sort 2: Descending Sort by Female Lead Last Name:");
        mrSorty.selectionSort(7, true);
        mrSorty.printShows(new int[] { 0, 1, 6, 7 });

    }

}
