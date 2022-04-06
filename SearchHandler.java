package TVShow;

public class SearchHandler {

    private TVShow[] showsList;
    private String[] headers;

    // Constructor
    public SearchHandler(TVShow[] showsList, String[] headers) {

        this.showsList = showsList;
        this.headers = headers;
    }

    public int binarySearch(int searchParam, String searchVal) {

        int low = 0;
        int high = showsList.length - 1;
        int find = -1;
        int mid;

        while (low <= high) {

            mid = low + (high - low) / 2;

            if (showsList[mid].getShowDetails()[searchParam].compareTo(searchVal) < 0) {
                low = mid + 1;
            }
            else if (showsList[mid].getShowDetails()[searchParam].compareTo(searchVal) > 0) {
                high = mid - 1;
            }
            else {
                find = mid;
                break;
            }
        }
        return find;
    }

    public void binarySearchHandler(int searchParam, String searchVal) {

        int foundIndex = binarySearch(searchParam, searchVal);
        int checkIndex = foundIndex;
        int numFound = 0;

        if (foundIndex == -1) {
            System.out.printf("Search item %s not found%n", searchVal);
            return;
        }

        while (showsList[checkIndex].getShowDetails()[searchParam].compareTo(searchVal) == 0) {
            System.out.printf("%s, ", showsList[checkIndex].getShowDetails()[0]);
            ++numFound;
            --checkIndex;
        }
        checkIndex = foundIndex + 1;
        while (showsList[checkIndex].getShowDetails()[searchParam].compareTo(searchVal) == 0) {
            System.out.printf("%s, ", showsList[checkIndex].getShowDetails()[0]);
            ++numFound;
            ++checkIndex;
        }
        System.out.println();
        System.out.printf("There are %d %s shows%n%n", numFound, searchVal);
    }

    public void sequentialSearchMatch(int searchParam, String searchVal) {

        String divider = "------------------------";
        int[] printInfo = new int[] { 0, 1, 2, 4 };

        for (int i = 0; i < printInfo.length; ++i) {

            System.out.printf("%21s | ", headers[printInfo[i]]);
        }
        System.out.println();

        for (int i = 0; i < printInfo.length; ++i) {

            System.out.print(divider);
        }
        System.out.println();

        for (int i = 0; i < showsList.length; ++i) {

            if (showsList[i].getShowDetails()[searchParam].compareTo(searchVal) == 0) {

                for (int j = 0; j < printInfo.length; ++j) {

                    System.out.printf("%21s | ", showsList[i].getShowDetails()[printInfo[j]]);
                }
                System.out.println();
            }
        }
    }

    public void sequentialSearchPass(int searchParam, String searchVal) {

        String divider = "------------------------";
        int[] printInfo = new int[] { 0, 2, 3 };

        for (int i = 0; i < printInfo.length; ++i) {

            System.out.printf("%21s | ", headers[printInfo[i]]);
        }
        System.out.println();

        for (int i = 0; i < printInfo.length; ++i) {

            System.out.print(divider);
        }
        System.out.println();

        for (int i = 0; i < showsList.length; ++i) {

            if (Integer.parseInt(showsList[i].getShowDetails()[searchParam]) > Integer.parseInt(searchVal)) {

                for (int j = 0; j < printInfo.length; ++j) {

                    System.out.printf("%21s | ", showsList[i].getShowDetails()[printInfo[j]]);
                }
                System.out.println();
            }
        }
    }

    public void printShows(int printInfo[]) {

        String divider = "------------------------";

        for (int i = 0; i < printInfo.length; ++i) {

            System.out.printf("%21s | ", headers[printInfo[i]]);
        }
        System.out.println();
        for (int i = 0; i < printInfo.length; ++i) {

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
