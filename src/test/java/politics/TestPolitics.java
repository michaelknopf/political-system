package politics;

import junit.framework.TestCase;

/**
 * Integration test where elections are held and their outcomes verified.
 */
public class TestPolitics extends TestCase {

    public void setUp() {
        // set seed for reproducible outcomes
        long seed = 123456789;
        Legislator.random.setSeed(seed);
        Citizen.random.setSeed(seed);
    }

    /**
     * Test that a legislative body can vote on a bill, and that the expected results are produced.
     */
    public void testLegislativeBodyVote() {

        // initialize LegislativeBody
        LegislativeBody legislativeBody = new LegislativeBody("Utopia Legislature");
        for (int j = 0; j < 10; j++) {
            legislativeBody.addLegislator(new Legislator("Some Important Person", Faction.RED));
        }

        // initialize Bill
        Bill bill = new Bill(
                "Economic Prosperity Act",
                new String[]{
                        "All citizens will be given $1 every day."
                }
        );

        // define expectations
        boolean[] expected = new boolean[] { false, false, false, true, true };

        // run test 5 times
        for (int i = 0; i < 5; i++) {
            // conduct election
            boolean result = legislativeBody.voteOnBill(bill);
            // check result against expectation
            assertEquals(result, expected[i]);
        }

    }

    /**
     * Test that a NoTiesElection can be held where citizens vote on a list of candidates,
     * and that the expected results are produced.
     */
    public void testNoTiesCandidateElection() {

        // initialize citizens
        Citizen[] citizens = new Citizen[10];
        for (int j = 0; j < citizens.length; j++) {
            citizens[j] = new Citizen("Jane Doe");
        }

        // initialize candidates
        final String office = "Some Important-Sounding Job Title";
        Candidate[] candidates = new Candidate[] {
                new Candidate(String.format("Super Special Person 1"), office, Faction.RED),
                new Candidate(String.format("Super Special Person 2"), office, Faction.BLUE),
                new Candidate(String.format("Super Special Person 3"), office, Faction.GREEN)
        };

        // define expectations
        int[] expected = new int[] { 1, 1, 2, 1, 2 };

        // run test 5 times
        for (int i = 0; i < 5; i++) {
            // construct NoTiesElection
            NoTiesElection<Candidate> election = new NoTiesElection<>(
                    new Election<>(candidates, citizens)
            );
            // conduct election
            election.conductElection();
            // check result against expectation
            assertEquals(election.getWinner(), candidates[expected[i]]);
        }

    }

}
