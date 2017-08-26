package politics;

public interface BinaryVoter<T> extends Voter<T> {

    boolean vote(T bill);

    @Override
    default int vote(T[] choices) {
        if (choices[0] == null && choices.length == 2) {
            return vote(choices[1]) ? 1 : 0;
        } else {
            throw new IllegalArgumentException("argument to vote should be length 2 array with first element null;" +
                    "return value 0 represents 'no' vote and 1 represents 'yes' vote");
        }
    }

}
