package politics;

/**
 * NoTiesElection is a wrapper class that delegates calls to an Election instance,
 * but ensures that no ties occur by conducting the election repeatedly until
 * it does not result in a tie.
 * @param <T> the type of object being voted on
 */
public class NoTiesElection<T> {

    /**
     * the election being delegated to
     */
    private Election<T> delegate;

    /**
     * Construct a NoTiesElection from an election
     * @param delegate the election that will be used as a delegate
     */
    public NoTiesElection(Election<T> delegate) {
        this.delegate = delegate;
    }

    /**
     * Construct an election from an array of choices and an array of voters,
     * which used to construct the delegate election.
     * @param choices the choices being voted on
     * @param voters the voters who will be voting
     */
    public NoTiesElection(T[] choices, Voter<T>[] voters) {
        this(new Election<>(choices, voters));
    }

    /**
     * Conduct the election, repeating until there are no ties.
     */
    public void conductElection() {
        delegate.conductElection();

        // conduct again as long as there is a tie
        while (getWinner() == null) {
            // reconstruct delegate election
            delegate = new Election<>(delegate.getChoices(), delegate.getVoters());
            // conduct again
            delegate.conductElection();
        }
    }

    /**
     * Get the winner of the election
     * @return the winner of the election
     */
    public T getWinner() {
        return delegate.getWinner();
    }

    /**
     * Getter for delegate
     * @return delegate
     */
    public Election<T> getDelegate() {
        return delegate;
    }

}
