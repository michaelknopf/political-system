package politics;

public class NoTiesElection<T> {

    private Election<T> delegate;

    public NoTiesElection(Election<T> delegate) {
        this.delegate = delegate;
    }

    public NoTiesElection(T[] choices, Voter<T>[] voters) {
        this(new Election<>(choices, voters));
    }

    public void conductElection() {
        delegate.conductElection();
        while (getWinner() == null) {
            delegate = new Election<>(delegate.getChoices(), delegate.getVoters());
            delegate.conductElection();
        }
    }

    public T getWinner() {
        return delegate.getWinner();
    }

    public Election<T> getDelegate() {
        return delegate;
    }

}
