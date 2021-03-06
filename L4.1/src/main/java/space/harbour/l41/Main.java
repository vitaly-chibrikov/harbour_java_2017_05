package space.harbour.l41;

import java.io.IOException;
import java.util.List;

/**
 * Created by tully.
 */
public class Main {
    private static final int MAX_WINNERS_COUNT = 2;

    public static void main(String[] args) throws IOException {
        String pathToFile;
        if (args.length >= 1) {
            pathToFile = args[0];
        } else {
            pathToFile = "emails.csv";
        }

        String seedString = "May the Force be with you";

        List<String> winners = new Lottery(
                new EmailsReader(pathToFile),
                new LotteryMachine(MAX_WINNERS_COUNT),
                seedString
        ).run();

        System.out.println("Winners:");
        winners.forEach(System.out::println);
    }
}
