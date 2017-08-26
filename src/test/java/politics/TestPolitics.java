package politics;

import junit.framework.TestCase;

public class TestPolitics extends TestCase {

    public void setUp() {
        long seed = 123456789;
        Legislator.random.setSeed(seed);
        Citizen.random.setSeed(seed);
    }

    public void testLegislativeBodyVote() {

        LegislativeBody legislativeBody = new LegislativeBody("Utopia Legislature");
        for (int j = 0; j < 10; j++) {
            legislativeBody.addLegislator(new Legislator("Some Important Person", Faction.RED));
        }

        Bill bill = new Bill(
                "Economic Prosperity Act",
                new String[]{
                        "All citizens will be given $1 every day."
                }
        );

        boolean[] expected = new boolean[] { false, false, false, true, true };
        for (int i = 0; i < 5; i++) {
            boolean result = legislativeBody.voteOnBill(bill);
            assertEquals(result, expected[i]);
        }
    }

    public void testNoTieCandidateElection() {

        Citizen[] citizens = new Citizen[10];
        for (int j = 0; j < citizens.length; j++) {
            citizens[j] = new Citizen("Jane Doe");
        }

        final String office = "Some Important-Sounding Job Title";
        Candidate[] candidates = new Candidate[] {
                new Candidate(String.format("Super Special Person 1"), office, Faction.RED),
                new Candidate(String.format("Super Special Person 2"), office, Faction.BLUE),
                new Candidate(String.format("Super Special Person 3"), office, Faction.GREEN)
        };

        int[] expected = new int[] { 1, 1, 2, 1, 2 };

        for (int i = 0; i < 5; i++) {
            NoTiesElection<Candidate> election = new NoTiesElection<>(
                    new Election<>(candidates, citizens)
            );
            election.conductElection();
            assertEquals(election.getWinner(), candidates[expected[i]]);
        }

    }

}
