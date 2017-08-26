package politics;

public class Election<T> {

    private int[] tally;
    private T[] choices;
    private boolean tie;

    private Voter<T>[] voters;

    public Election(T[] choices, Voter<T>[] voters) {
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

    public T getWinner() {
        T winner = null;
        int mostVotes = 0;
        for (int i = 0; i < choices.length; i++) {
            int votes = tally[i];
            if (votes > mostVotes) {
                tie = false;
                mostVotes = votes;
                winner = choices[i];
            } else if (votes == mostVotes) {
                tie = true;
                winner = null;
            }
        }
        return winner;
    }

    public boolean isTie() {
        return tie;
    }

    public T[] getChoices() {
        return choices;
    }

    public Voter<T>[] getVoters() {
        return voters;
    }

}
