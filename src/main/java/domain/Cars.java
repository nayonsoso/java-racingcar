package domain;

import util.NumberGenerator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private final List<Car> cars;

    public Cars(List<String> carNames) {
        checkNameDuplication(carNames);
        cars = new ArrayList<>();
        addCar(carNames);
    }

    private void checkNameDuplication(List<String> carNames) {
        long uniqueNameCount = carNames.stream()
                .distinct()
                .count();
        if (uniqueNameCount != carNames.size()) {
            throw new IllegalArgumentException("중복되는 자동차 이름이 존재합니다.");
        }
    }

    private void addCar(List<String> carNames) {
        for (String carName : carNames) {
            cars.add(new Car(carName));
        }
    }

    public List<String> findWinners(Integer maxDistance) {
        return cars.stream()
                .filter(car -> car.getDistance() == maxDistance)
                .map(Car::getCarName)
                .collect(Collectors.toList());
    }

    public int findMaxDistance() {
        return cars.stream()
                .mapToInt(Car::getDistance)
                .max()
                .orElse(0);
    }

    public void progressRound(NumberGenerator randomNumberGenerator, MovementManager movementManager) {
        for (Car car : cars) {
            int randomNumber = randomNumberGenerator.generateNumber();
            car.move(movementManager, randomNumber);
        }
    }

    public List<Car> getCars() {
        return Collections.unmodifiableList(cars);
    }

}