package racingcar.view.console;

import racingcar.view.OutputView;

import java.util.List;
import java.util.Map;

public class ConsoleOutputView implements OutputView {
    @Override
    public void printRaceResultHeaderMessage() {
        System.out.println();
        System.out.println("실행 결과");
    }

    @Override
    public void printRaceHistory(final List<Map<String, Integer>> raceHistory) {
        raceHistory.forEach(round -> {
            round.forEach((carName, position) -> {
                String currentPosition = "-".repeat(position);
                System.out.printf("%s : %s%n", carName, currentPosition);
            });
            System.out.println();
        });
    }

    @Override
    public void printRaceWinners(final List<String> raceWinners) {
        String raceWinnerNames = String.join(", ", raceWinners);
        System.out.printf("%s가 최종 우승했습니다.", raceWinnerNames);
    }
}
