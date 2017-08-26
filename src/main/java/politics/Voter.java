package politics;

import java.util.List;

public interface Voter<T> {

    public int vote(T[] choices);

}
