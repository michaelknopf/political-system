# political-system

This toy example of a Java class hierarchy is a representation of a democratic political system.  It is an attempt to create a small example where inheritance, interfaces, and delegation all work together.

The action happens in the following classes/interfaces:

1. [Voter](src/main/java/politics/Voter.java)
2. [BinaryVoter](src/main/java/politics/BinaryVoter.java)
3. [Election](src/main/java/politics/Election.java)
4. [BinaryElection](src/main/java/politics/BinaryElection.java)
5. [NoTiesElection](src/main/java/politics/NoTiesElection.java)

A ```Voter``` can vote in an ```Election```, but a ```Voter``` only knows how to answer a "multiple choice" question, not a strictly binary one.  So we extend the ```Voter``` interface to create ```BinaryVoter```, which contains some wrapper methods that morph the signature of ```int vote(T[] choices)``` into one suited for this binary situation: ```boolean vote(T proposal)```.  We do this by encoding the binary question as a multiple choice one, where the array of choices is ```{null, proposal}```.  This allows us to reuse the implementation of ```Election``` by extending it to make ```BinaryElection```.

Later, we want to model an election where ties are not allowed.  We will do this by repeating the election until it results in a lone winner.  We could attempt this through inheritance, extending ```Election``` and overriding the ```conductElection()``` method to call ```super.conductElection()``` repeatedly until the tie is broken.  The problem is that we will have to do this *again* for ```BinaryElection```, creating redundancy.  Delegation is a better solution here, so we create a wrapper class ```NoTiesElection```, which delegates calls to an instance of ```Election```.  Because of polymorphism, any subclass of ```Election``` can serve as this delegate, and so our solution works for ```BinaryElection``` as well.


## Issues & Limitations

The purpose of this project is to squeeze a lot of concepts into a small collection of classes.  As a consequence, the class hierarchy does not model the real situation perfectly.  Some problems of note are listed here.


### Erasure

Due to erasure, a class cannot implement ```Voter<T>``` for different values of the generic type ```T```.  For instance, if we had a class ```Referendum``` and wanted ```Citizen``` to implement both ```Voter<Candidate>``` and ```Voter<Referendum>```, this would be impossible since the compiler would encounter two conflicting definitions of ```int vote(Object[] choices)```.  I wanted the example to include generics, but in practice it would have been better to define the ```Voter``` interface as

```java
public interface Voter {
    int vote(Object[] choices);
}
```

and determine at runtime whether a given value of ```choices``` is compatible with the method:

```java
public class Citizen extends PoliticalEntity implements Voter {
    ...
    public int vote(Object[] choices) {
        switch(choices.getClass().getComponentType()) {
            case Candidate.class:
                ...
            case Referendum.class:
                ...
            default:
                throw new IllegalArgumentException(
                        String.format(
                                "Citizen cannot vote on objects of type %s",
                                choices.getClass().getComponentType()
                        )
                );
        }
    }
}
```


### Default Implementation of ```int vote(T[] choices)``` in ```BinaryVoter```

In order to reuse the functionality of ```Election``` in the subclass ```BinaryElection```, we have provided a default implementation of  ```int vote(T[] choices)``` that simply reroutes calls to ```boolean vote(T choice)```.  The intention is that an implementation of ```BinaryVoter``` should never implement ```int vote(T[] choices)``` - however, it is impossible to make a ```default``` method ```final```.  So it is possible that someone could unknowingly implement this method without realizing that it would break the assumption made by ```BinaryElection``` that this method simply delegates to ```boolean vote(T choice)```.