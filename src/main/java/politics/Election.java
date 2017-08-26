package politics;

import java.util.Iterator;

public class Election<T> {

    private int[] tally;
    private T[] choices;
    private Voter<T>[] voters;

    public Election(T[] choices, Voter[] voters) {
        this.choices = choices;
        this.voters = voters;
        tally = new int[choices.length];
        for (int i = 0; i < choices.length; i++) {
            tally[i] = 0;
        }
    }

    public void conductElection() {
        for (Voter<T> voter : voters) {
            tally[voter.vote(choices)]++;
        }
    }

    public T[] getChoices() {
        return choices;
    }

    public T getWinner() {
        T winner = null;
        int mostVotes = 0;
        for (int i = 0; i < choices.length; i++) {
            int votes = tally[i];
            if (votes > mostVotes) {
                mostVotes = votes;
                winner = choices[i];
            } else if (votes == mostVotes) {
                winner = null;
            }
        }
        return winner;
    }

}
