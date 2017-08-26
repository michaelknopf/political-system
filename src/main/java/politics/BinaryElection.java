package politics;

/**
 * An election where BinaryVoters vote in favor or against a single proposal
 * of a given type.
 * @param <T> the type of the proposal being voted on
 */
public class BinaryElection<T> extends Election<T> {

    /**
     * Construct a BinaryElection from the proposal being voted on and
     * an array of BinaryVoters.
     * @param proposal the proposal being voted on
     * @param voters the voters who will be voting
     */
    public BinaryElection(T proposal, BinaryVoter<T>[] voters) {
        super((T[]) new Object[] { null, proposal }, voters);
    }

    /**
     * Determine whether the proposal was successful
     * @return true if successful, false if unsuccessful, null if tie
     */
    public Boolean isSuccessful() {
        if (isTie()) {
            return null;
        }
        return getWinner() != null;
    }

}
