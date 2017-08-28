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