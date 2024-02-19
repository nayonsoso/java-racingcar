package racingcar.dto.response;

import racingcar.domain.car.Car;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public record RaceResultResponse(Map<String, Integer> raceResult) {
    public static RaceResultResponse from(final List<Car> raceResult) {
        Map<String, Integer> raceResultResponse = new LinkedHashMap<>();
        raceResult.forEach(car -> raceResultResponse.put(car.getName(), car.getPosition()));
        return new RaceResultResponse(raceResultResponse);
    }
}
