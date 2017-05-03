package space.harbour.l41;

import java.util.List;
import java.util.function.Supplier;

/**
 * Created by tully.
 */
class Lottery {
    private final Supplier<List<String>> emailsSource;
    private final LotteryMachine machine;
    private final String seedString;

    Lottery(Supplier<List<String>> emailsSource, LotteryMachine machine, String seedString) {
        this.emailsSource = emailsSource;
        this.machine = machine;
        this.seedString = seedString;
    }

    List<String> run() {
        List<String> emails = emailsSource.get();

        System.out.println("Emails count: " + emails.size());

        return machine.setSeed(seedString).draw(emails);
    }
}
