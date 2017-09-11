package politics;

/**
 * A Voter that is able to vote yes or no on a single choice of a given type.
 * @param <T> the type of object able to be voted on
 */
public interface BinaryVoter<T> extends Voter<T> {

    /**
     * Vote yes or no on a choice.
     * @param choice the choice being voted on
     * @return true if in favor, otherwise false
     */
    boolean vote(T choice);

    /**
     * A default implementation of the vote method from the Voter interface that
     * simply redirects to the binary implementation of vote.  This method expects
     * choices to be a 2-element array, the first element being null and representing
     * a "no" vote, the second being the object being voted on and representing a "yes" vote.
     *
     * Note: Do not override this method.  Overriding will result in unintended behavior in a BinaryElection.
     *
     * @param choices a 2-element array, the first element being null and representing a "no" vote,
     *                the second being the object being voted on and representing a "yes" vote.
     * @return 1 if in favor, otherwise 0
     */
    @Override
    default int vote(T[] choices) {
        // check that choices is of expected form
        if (choices[0] == null && choices.length == 2) {
            return vote(choices[1]) ? 1 : 0;
        } else {
            throw new IllegalArgumentException("argument to vote should be length 2 array with first element null;" +
                    "return value 0 represents 'no' vote and 1 represents 'yes' vote");
        }
    }

}
