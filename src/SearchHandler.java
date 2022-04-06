/*  Author: Jonathan Baskharoun
 *  Date: 04/06/2022
 *  Version: Java 1.8
 * 
 *  The SearchHandler class handles all searching
 */

public class SearchHandler {

    private TVShow[] showsList;
    private String[] headers;

    // Constructor
    public SearchHandler(TVShow[] showsList, String[] headers) {

        this.showsList = showsList;
        this.headers = headers;
    }

    // Binary search basic algorithm, returns index if value found, -1 otherwise
    public int binarySearch(int searchParam, String searchVal) {

        int low = 0;
        int high = showsList.length - 1;
        int find = -1;
        int mid;

        while (low <= high) { // ends when range adjustments pass each other, value not found

            mid = low + (high - low) / 2;

            // if string < searchVal adjust range upward 
            if (showsList[mid].getShowDetails()[searchParam].compareTo(searchVal) < 0) {
                low = mid + 1;
            }
            // if string > searchVal adjust range downward 
            else if (showsList[mid].getShowDetails()[searchParam].compareTo(searchVal) > 0) {
                high = mid - 1;
            }
            else { // if == then value found

                find = mid;
                break;
            }
        }
        return find;
    }

    // binary search wrapper to handle adjacency checks and printing
    public void binarySearchHandler(int searchParam, String searchVal) {

        int foundIndex = binarySearch(searchParam, searchVal);
        int checkIndex = foundIndex;
        int numFound = 0;

        if (foundIndex == -1) {
            System.out.printf("Search item %s not found%n", searchVal);
            return;
        }

        // Checks indices at and to the left of found index, prints matches
        while (showsList[checkIndex].getShowDetails()[searchParam].compareTo(searchVal) == 0) {
            System.out.printf("%s, ", showsList[checkIndex].getShowDetails()[0]);
            ++numFound;
            --checkIndex;
        }

        // Checks indices to the right of found index and prints matches
        checkIndex = foundIndex + 1;
        while (showsList[checkIndex].getShowDetails()[searchParam].compareTo(searchVal) == 0) {
            System.out.printf("%s, ", showsList[checkIndex].getShowDetails()[0]);
            ++numFound;
            ++checkIndex;
        }
        System.out.println();
        System.out.printf("There are %d %s shows%n%n", numFound, searchVal);
    }

    // Sequential search algorithm that checks for string equality matches
    public void sequentialSearchMatch(int searchParam, String searchVal) {

        String divider = "------------------------";
        int[] printInfo = new int[] { 0, 1, 2, 4 };

        // printing headers
        for (int i = 0; i < printInfo.length; ++i) {

            System.out.printf("%21s | ", headers[printInfo[i]]);
        }
        System.out.println();

        // printing dividers
        for (int i = 0; i < printInfo.length; ++i) {

            System.out.print(divider);
        }
        System.out.println();

        // search through sequentially and print matching shows
        for (int i = 0; i < showsList.length; ++i) {

            if (showsList[i].getShowDetails()[searchParam].compareTo(searchVal) == 0) {

                for (int j = 0; j < printInfo.length; ++j) {

                    System.out.printf("%21s | ", showsList[i].getShowDetails()[printInfo[j]]);
                }
                System.out.println();
            }
        }
    }

    // Sequential search algorithm that checks for integer >= matches
    public void sequentialSearchPass(int searchParam, String searchVal) {

        String divider = "------------------------";
        int[] printInfo = new int[] { 0, 2, 3 };

        // printing headers
        for (int i = 0; i < printInfo.length; ++i) {

            System.out.printf("%21s | ", headers[printInfo[i]]);
        }
        System.out.println();

        // printing dividers
        for (int i = 0; i < printInfo.length; ++i) {

            System.out.print(divider);
        }
        System.out.println();

        // search through and print TVShows with searchParam >= searchVal
        for (int i = 0; i < showsList.length; ++i) {

            if (Integer.parseInt(showsList[i].getShowDetails()[searchParam]) > Integer.parseInt(searchVal)) {

                for (int j = 0; j < printInfo.length; ++j) {

                    System.out.printf("%21s | ", showsList[i].getShowDetails()[printInfo[j]]);
                }
                System.out.println();
            }
        }
    }

}
