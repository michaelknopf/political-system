package politics;

/**
 * An Election represents a process where a group of Voters each choose
 * from a list of objects of a given type to vote for.
 * @param <T> the type of the choices being voted on
 */
public class Election<T> {

    /**
     * an array of vote totals for each choice
     */
    private int[] tally;

    /**
     * the choices being voted on
     */
    private T[] choices;

    /**
     * true if the election resulted in a tie, otherwise false
     */
    private boolean tie;

    /**
     * the electorate voting in the election
     */
    private Voter<T>[] voters;

    /**
     * Construct an election from an array of choices of a given type
     * and an array of voters capable of voting on that type
     * @param choices the choices to vote on
     * @param voters the voters who are voting
     */
    public Election(T[] choices, Voter<T>[] voters) {
        this.choices = choices;
        this.voters = voters;

        // construct and initialize tally
        tally = new int[choices.length];
        for (int i = 0; i < choices.length; i++) {
            tally[i] = 0;
        }
    }

    /**
     * Iterates through each voter, asking his or her vote
     * and tallying the results.
     */
    public void conductElection() {
        for (Voter<T> voter : voters) {
            tally[voter.vote(choices)]++;
        }
    }

    /**
     * Determines and returns the winner of the election.
     * @return the winning object
     */
    public T getWinner() {

        // initialize winner to null
        T winner = null;

        // the highest vote total that has yet been encountered
        int mostVotes = 0;

        // iterate through each choice and its tally
        for (int i = 0; i < choices.length; i++) {
            int votes = tally[i];

            // if this choice has more votes than any other so far
            if (votes > mostVotes) {
                // there is currently a clear winner
                tie = false;
                // update mostVotes to this new tally
                mostVotes = votes;
                // update winner to this choice
                winner = choices[i];

            // if this choice is in a tie with the current vote leader
            } else if (votes == mostVotes) {
                // we currently have a tie
                tie = true;
                // there is currently no winner
                winner = null;
            }
        }

        return winner;
    }

    /**
     * Determine if the election was a tie.
     * @return true if the election was a tie, otherwise false
     */
    public boolean isTie() {
        return tie;
    }

    /**
     * Getter for choices
     * @return the election's choices
     */
    public T[] getChoices() {
        return choices;
    }

    /**
     * Getter for voters.
     * @return the election's voters
     */
    public Voter<T>[] getVoters() {
        return voters;
    }

}
