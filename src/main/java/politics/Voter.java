package politics;

/**
 * An object that is able to cast a vote given an array
 * of choices, all of a particular type.
 * @param <T> the type of object able to be voted on
 */
public interface Voter<T> {

    /**
     * Vote on a list of choices, all of type T.
     * @param choices the list of choices
     * @return the index of the choice
     */
    int vote(T[] choices);

}
