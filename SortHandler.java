package TVShow;

public class SortHandler {

    private TVShow[] showsList;
    private String[] headers;

    // Constructor
    public SortHandler(TVShow[] showsList, String[] headers) {

        this.showsList = showsList;
        this.headers = headers;
    }

    void insertionSort(int sortBy, boolean descend) {

        // sorting from second element to end
        for (int i = 1; i < showsList.length; ++i) {

            // get attribute to be sorted by from showlist tvshow details
            TVShow currShow = showsList[i];
            String currCheck = currShow.getShowDetails()[sortBy];

            int j = i - 1;

            // columns 1, 2, 3 contain numeric data which must be passed through parseInt()
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
            } else { // all other columns involve string comparisons

                if (descend) { // descending sort

                    while (j >= 0 &&
                            showsList[j].getShowDetails()[sortBy].compareTo(currCheck) < 0) {

                        showsList[j + 1] = showsList[j];
                        --j;
                    }
                } else {

                    while (j >= 0 &&
                            showsList[j].getShowDetails()[sortBy].compareTo(currCheck) > 0) {

                        showsList[j + 1] = showsList[j];
                        --j;
                    }
                }
            }
            showsList[j + 1] = currShow;
        }
    }

    public void mergeLists(TVShow[] newList, int leftStart, int rightEnd, int sortBy, boolean descend) {

        int leftEnd = (rightEnd + leftStart) / 2;
        int rightStart = leftEnd + 1;
        int newSize = rightEnd - leftStart + 1;

        int currLeft = leftStart;
        int currRight = rightStart;
        int currIndex = leftStart;

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
                            .compareTo(showsList[currRight].getShowDetails()[sortBy]) >= 0) {

                        newList[currIndex] = showsList[currLeft];
                        ++currLeft;

                    } else {
                        newList[currIndex] = showsList[currRight];
                        ++currRight;
                    }
                    ++currIndex;

                } else { // ascending sort

                    if (showsList[currLeft].getShowDetails()[sortBy]
                            .compareTo(showsList[currRight].getShowDetails()[sortBy]) <= 0) {

                        newList[currIndex] = showsList[currRight];
                        ++currRight;

                    } else {
                        newList[currIndex] = showsList[currLeft];
                        ++currLeft;
                    }
                    ++currIndex;
                }

            }

        }

        System.arraycopy(showsList, currLeft, newList, currIndex, leftEnd - currLeft + 1);
        System.arraycopy(showsList, currRight, newList, currIndex, rightEnd - currRight + 1);
        System.arraycopy(newList, leftStart, showsList, leftStart, newSize);
    }

    public void mergeSortStart(int sortBy, boolean descend) {

        mergeSort(new TVShow[showsList.length], 0, showsList.length - 1, sortBy, descend);
    }

    // TODO: update sort logic
    public void mergeSort(TVShow[] newList, int leftStart, int rightEnd, int sortBy, boolean descend) {

        if (leftStart >= rightEnd) {
            return;
        }

        int middle = (leftStart + rightEnd) / 2;

        mergeSort(newList, leftStart, middle, sortBy, descend);
        mergeSort(newList, middle + 1, rightEnd, sortBy, descend);

        mergeLists(newList, leftStart, rightEnd, sortBy, descend);

        // if (sortBy == 1 || sortBy == 2 || sortBy == 3) { // int columns

        // if (descend) { // descending sort

        // if (Integer.parseInt(showsList[j].getShowDetails()[sortBy]) > Integer
        // .parseInt(showsList[swapIndex].getShowDetails()[sortBy])) {

        // swapIndex = j;
        // }

        // } else { // ascending sort

        // if (Integer.parseInt(showsList[j].getShowDetails()[sortBy]) < Integer
        // .parseInt(showsList[swapIndex].getShowDetails()[sortBy])) {

        // swapIndex = j;
        // }
        // }

        // } else { // string columns

        // if (descend) { // descending sort

        // if (showsList[j].getShowDetails()[sortBy]
        // .compareTo(showsList[swapIndex].getShowDetails()[sortBy]) > 0) {

        // swapIndex = j;
        // }

        // } else { // ascending sort

        // if (showsList[j].getShowDetails()[sortBy]
        // .compareTo(showsList[swapIndex].getShowDetails()[sortBy]) < 0) {

        // swapIndex = j;
        // }
        // }

    }

    public void selectionSort(int sortBy, boolean descend) {

        // select one number on each pass through and move forward
        for (int i = 0; i < showsList.length - 1; ++i) {

            int swapIndex = i;

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

                    if (descend) { // descending sort

                        if (showsList[j].getShowDetails()[sortBy]
                                .compareTo(showsList[swapIndex].getShowDetails()[sortBy]) > 0) {

                            swapIndex = j;
                        }

                    } else { // ascending sort

                        if (showsList[j].getShowDetails()[sortBy]
                                .compareTo(showsList[swapIndex].getShowDetails()[sortBy]) < 0) {

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

    } // end function selectionSort

    public void printShows(int printInfo[]) {

        String divider = "------------------------";

        for (int i = 0; i < printInfo.length; ++i) {

            System.out.printf("%21s | ", headers[printInfo[i]]);
        }
        System.out.println();
        for (int k = 0; k < printInfo.length; ++k) {

            System.out.print(divider);
        }
        System.out.println();

        for (int i = 0; i < showsList.length; ++i) {

            for (int j = 0; j < printInfo.length; ++j) {

                System.out.printf("%21s | ", showsList[i].getShowDetails()[printInfo[j]]);
            }

            System.out.println();
        }
        System.out.println();

    }

}
