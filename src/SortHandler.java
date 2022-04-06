/*  Author: Jonathan Baskharoun
 *  Date: 04/06/2022
 *  Version: Java 1.8
 * 
 *  The SortHandler class handles all sorting
 */

public class SortHandler {

    private TVShow[] showsList;
    private String[] headers;

    // Constructor
    public SortHandler(TVShow[] showsList, String[] headers) {

        this.showsList = showsList;
        this.headers = headers;
    }

    // Sort by insertion sort algorithm: combing backwards on each iteration
    // to find the right index to insert new value, swapping each time
    void insertionSort(int sortBy, boolean descend) {

        // sorting from second element to end
        for (int i = 1; i < showsList.length; ++i) {

            // get attribute to be sorted by from showlist tvshow details
            TVShow currShow = showsList[i];
            String currCheck = currShow.getShowDetails()[sortBy];

            int j = i - 1;

            // columns 1, 2, 3 to be sorted numerically
            if (sortBy == 1 || sortBy == 2 || sortBy == 3) {

                if (descend) { // descending sort

                    while ((j >= 0) && (Integer.parseInt(currCheck) > Integer
                            .parseInt(showsList[j].getShowDetails()[sortBy]))) {

                        showsList[j + 1] = showsList[j];
                        --j;
                    }

                } else { // ascending sort

                    while ((j >= 0) && (Integer.parseInt(currCheck) < Integer
                            .parseInt(showsList[j].getShowDetails()[sortBy]))) {

                        showsList[j + 1] = showsList[j];
                        --j;
                    }
                }

            } else { // all other columns sort alphabetically

                if (descend) { // descending sort

                    while (j >= 0 &&
                            showsList[j].getShowDetails()[sortBy].compareTo(currCheck) < 0) {

                        showsList[j + 1] = showsList[j];
                        --j;
                    }
                } else { // ascending sort

                    while (j >= 0 &&
                            showsList[j].getShowDetails()[sortBy].compareTo(currCheck) > 0) {

                        showsList[j + 1] = showsList[j];
                        --j;
                    }
                }
            }
            showsList[j + 1] = currShow; // final swap
        }
    }

    // mergeSort initializer function
    public void mergeSortStart(int sortBy, boolean descend) {

        mergeSort(new TVShow[showsList.length], 0, showsList.length - 1, sortBy, descend);
    }

    // splits out subarrays recursively until down to a single element, then calls mergeLists
    public void mergeSort(TVShow[] newList, int leftStart, int rightEnd, int sortBy, boolean descend) {

        if (leftStart >= rightEnd) {
            return;
        }

        int middle = (leftStart + rightEnd) / 2;

        mergeSort(newList, leftStart, middle, sortBy, descend);
        mergeSort(newList, middle + 1, rightEnd, sortBy, descend);

        mergeLists(newList, leftStart, rightEnd, sortBy, descend);
    }
    
    // function merges lists back together after being split out by mergeSort
    public void mergeLists(TVShow[] newList, int leftStart, int rightEnd, int sortBy, boolean descend) {

        int leftEnd = (rightEnd + leftStart) / 2;
        int rightStart = leftEnd + 1;
        int newSize = rightEnd - leftStart + 1;

        int currLeft = leftStart;
        int currRight = rightStart;
        int currIndex = leftStart;

        // until either left or right side array is empty
        while (currLeft <= leftEnd && currRight <= rightEnd) {

            if (sortBy == 1 || sortBy == 2 || sortBy == 3) { // int columns

                if (descend) { // descending sort

                    if (Integer.parseInt(showsList[currLeft].getShowDetails()[sortBy]) >= Integer
                            .parseInt(showsList[currRight].getShowDetails()[sortBy])) {

                        newList[currIndex] = showsList[currLeft];
                        ++currLeft;

                    } else {
                        newList[currIndex] = showsList[currRight];
                        ++currRight;
                    }
                    ++currIndex;

                } else { // ascending sort

                    if (Integer.parseInt(showsList[currLeft].getShowDetails()[sortBy]) <= Integer
                            .parseInt(showsList[currRight].getShowDetails()[sortBy])) {

                        newList[currIndex] = showsList[currLeft];
                        ++currLeft;

                    } else {
                        newList[currIndex] = showsList[currRight];
                        ++currRight;
                    }
                    ++currIndex;
                }

            } else { // string columns

                if (descend) { // descending sort

                    if (showsList[currLeft].getShowDetails()[sortBy]
                            .compareTo(showsList[currRight].getShowDetails()[sortBy]) > 0) {

                        newList[currIndex] = showsList[currLeft];
                        ++currLeft;

                    } else {
                        newList[currIndex] = showsList[currRight];
                        ++currRight;
                    }
                    ++currIndex;

                } else { // ascending sort

                    if (showsList[currLeft].getShowDetails()[sortBy]
                            .compareTo(showsList[currRight].getShowDetails()[sortBy]) < 0) {

                        newList[currIndex] = showsList[currRight];
                        ++currRight;

                    } else {
                        newList[currIndex] = showsList[currLeft];
                        ++currLeft;
                    }
                    ++currIndex;
                }

            }

        } // end while

        // copy remaining elements into new list, one will already be empty
        System.arraycopy(showsList, currLeft, newList, currIndex, leftEnd - currLeft + 1);
        System.arraycopy(showsList, currRight, newList, currIndex, rightEnd - currRight + 1);

        // copy finished new list back into original showlist
        System.arraycopy(newList, leftStart, showsList, leftStart, newSize);
    }

    // checks through array to find next appropriate element then swaps it in
    public void selectionSort(int sortBy, boolean descend) {

        // select one number on each pass through and move forward
        for (int i = 0; i < showsList.length - 1; ++i) {

            int swapIndex = i; // start at i value

            // go through each remaining element
            for (int j = i + 1; j < showsList.length; ++j) {

                if (sortBy == 1 || sortBy == 2 || sortBy == 3) { // int columns

                    if (descend) { // descending sort

                        if (Integer.parseInt(showsList[j].getShowDetails()[sortBy]) > Integer
                                .parseInt(showsList[swapIndex].getShowDetails()[sortBy])) {

                            swapIndex = j;
                        }

                    } else { // ascending sort

                        if (Integer.parseInt(showsList[j].getShowDetails()[sortBy]) < Integer
                                .parseInt(showsList[swapIndex].getShowDetails()[sortBy])) {

                            swapIndex = j;
                        }
                    }

                } else { // string columns

                    String toCheck;
                    String toSwap;
                    String[] fullName;

                    // extra logic added post hoc for bonus sorts by last names
                    if (sortBy == 6 || sortBy == 7) {
                        fullName = showsList[j].getShowDetails()[sortBy].split(" ");
                        toCheck = fullName[1];

                        fullName = showsList[swapIndex].getShowDetails()[sortBy].split(" ");
                        toSwap = fullName[1];

                    } else { // regular string sort logic

                        toCheck = showsList[j].getShowDetails()[sortBy];
                        toSwap = showsList[swapIndex].getShowDetails()[sortBy];
                    }

                    if (descend) { // descending sort

                        if (toCheck.compareTo(toSwap) > 0) {

                            swapIndex = j;
                        }

                    } else { // ascending sort

                        if (toCheck.compareTo(toSwap) < 0) {

                            swapIndex = j;
                        }
                    }
                }

            } // end inner loop (j search for element)

            // Swap the found element with original index
            TVShow temp = showsList[swapIndex];
            showsList[swapIndex] = showsList[i];
            showsList[i] = temp;

        } // end outer loop (i iterating through each slot)

    }

    // prints headers and TVShows into neat columns
    public void printShows(int printInfo[]) {

        // divider the width of one column
        String divider = "------------------------";

        // prints headers
        for (int i = 0; i < printInfo.length; ++i) {

            System.out.printf("%21s | ", headers[printInfo[i]]);
        }
        System.out.println();

        // prints divider * numColumns
        for (int k = 0; k < printInfo.length; ++k) {

            System.out.print(divider);
        }
        System.out.println();

        // prints TVShow information one per line
        for (int i = 0; i < showsList.length; ++i) {

            for (int j = 0; j < printInfo.length; ++j) {

                System.out.printf("%21s | ", showsList[i].getShowDetails()[printInfo[j]]);
            }
            System.out.println();
        }
        System.out.println();
    }

}
