package racingcar.domain.car;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class PositionTest {
    @Test
    void forward메서드_테스트() {
        // given
        final int value = 0;
        final Position position = new Position(value);

        // when
        position.forward();

        // then
        assertThat(position.getValue()).isEqualTo(value + 1);
    }

    @Test
    void compareTo메서드_테스트() {
        // given
        final Position position1 = new Position(1);
        final Position position2 = new Position(2);

        // when & then
        assertThat(position1.compareTo(position2)).isEqualTo(-1);
        assertThat(position2.compareTo(position1)).isEqualTo(1);
        assertThat(position1.compareTo(position1)).isEqualTo(0);
    }

}