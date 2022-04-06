/*  Author: Jonathan Baskharoun
 *  Date: 04/06/2022
 *  Version: Java 1.8
 * 
 *  The TVShow class holds TVShow object information
 */
package TVShow;

public class TVShow {

    /* Holding info for each TVShow in a String array with the following index:
     * 
     * 0. Name
     * 1. Year
     * 2. numSeasons
     * 3. numEpisodes
     * 4. network
     * 5. genre
     * 6. maleLead
     * 7. femaleLead
     */
    private String[] showDetails;

    // Constructor
    public TVShow(String[] showDetails) {

        this.showDetails = showDetails;
    }

    @Override
    public String toString() {
        return "TVShow [showDetails=" + Arrays.toString(showDetails) + "]";
    }

    // Getters and Setters
    public String[] getShowDetails() {
        return showDetails;
    }

    public void setShowDetails(String[] showDetails) {
        this.showDetails = showDetails;
    }

}
