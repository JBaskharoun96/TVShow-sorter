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

    // TODO: update sort logic
    public void mergeSort(int sortBy, boolean descend) {

        if (sortBy == 1 || sortBy == 2 || sortBy == 3) { // int columns

            if (descend) { // descending sort

                /*
                 * if (Integer.parseInt(showsList[j].getShowDetails()[sortBy]) > Integer
                 * .parseInt(showsList[swapIndex].getShowDetails()[sortBy])) {
                 * 
                 * swapIndex = j;
                 * }
                 * 
                 * } else { // ascending sort
                 * 
                 * if (Integer.parseInt(showsList[j].getShowDetails()[sortBy]) < Integer
                 * .parseInt(showsList[swapIndex].getShowDetails()[sortBy])) {
                 * 
                 * swapIndex = j;
                 * }
                 * }
                 */

            } else { // string columns

                /*
                 * if (descend) { // descending sort
                 * 
                 * if (showsList[j].getShowDetails()[sortBy]
                 * .compareTo(showsList[swapIndex].getShowDetails()[sortBy]) > 0) {
                 * 
                 * swapIndex = j;
                 * }
                 * 
                 * } else { // ascending sort
                 * 
                 * if (showsList[j].getShowDetails()[sortBy]
                 * .compareTo(showsList[swapIndex].getShowDetails()[sortBy]) < 0) {
                 * 
                 * swapIndex = j;
                 * }
                 * }
                 */
            }

        }
    }

    // TODO: this bullshit function can't handle repeats! fuck!
    public void selectionSort(int sortBy, boolean descend) {

        // select one number on each pass through and move forward
        for (int i = 0; i < showsList.length - 1; ++i) {

            // Find the minimum element in unsorted array
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
                // Swap the found minimum element with the first
                // element
                TVShow temp = showsList[swapIndex];
                showsList[swapIndex] = showsList[i];
                showsList[i] = temp;
            }
        }
    }

    public void printShows(int printInfo[]) {

        String divider = "-";

        for (int i = 0; i < printInfo.length; ++i) {

            System.out.printf("%21s | ", headers[printInfo[i]]);
        }
        System.out.println();
        for (int k = 0; k < printInfo.length; ++k) {

            System.out.print(divider.repeat(24));
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
