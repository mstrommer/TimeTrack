package oop.classes;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class TimeTrackTests {

    @Test
    public void getCurrentTimeSheet_addTimeTrackingData_returnsProperTimeSheet() {
        int employeeId = 2234;
        var instanceUnderTest = new TimeTrack(employeeId);
        int workingHours = 10;
        int anotherWorkingHours = 8;
        int sickLeave = 2;
        int anotherSickLeave = 1;
        int vacation = 2;
        int anotherVacation = 3;
        int breakHours = 2;
        TimeSheet expectedTimeSheet = new TimeSheet(employeeId);
        expectedTimeSheet.setWorkingHours(workingHours + anotherWorkingHours - breakHours);
        expectedTimeSheet.setSickLeave(sickLeave + anotherSickLeave);
        expectedTimeSheet.setVacation(vacation + anotherVacation);

        instanceUnderTest.addWorkingHours(workingHours);
        instanceUnderTest.addWorkingHours(anotherWorkingHours);
        instanceUnderTest.addSickLeave(sickLeave);
        instanceUnderTest.addSickLeave(anotherSickLeave);
        instanceUnderTest.addVacation(vacation);
        instanceUnderTest.addVacation(anotherVacation);
        TimeSheet timeSheet = instanceUnderTest.getCurrentTimeSheet();

        assertThat(timeSheet).isEqualToComparingFieldByField(expectedTimeSheet);
    }

    @Test
    public void startNewPeriod_timeTrackingDataAreAlreadyAdded_resetsTimeSheet() {
        int employeeId = 2245;
        TimeSheet timeSheet = new TimeSheet(employeeId);
        timeSheet.setVacation(12);
        timeSheet.setWorkingHours(123);
        timeSheet.setSickLeave(1);
        var instanceUnderTest = new TimeTrack(timeSheet);
        TimeSheet emptyTimeSheet = new TimeSheet(employeeId);

        instanceUnderTest.startNewPeriod();

        assertThat(instanceUnderTest.getCurrentTimeSheet()).isEqualToComparingFieldByField(emptyTimeSheet);
    }

    @Test
    public void getCurrentTimeSheet_emitsDeepCopyOfTImeSheet() {
        int employeeId = 2245;
        TimeSheet timeSheet = new TimeSheet(employeeId);
        var instanceUnderTest = new TimeTrack(timeSheet);

        var firstYieldedTimeSheet = instanceUnderTest.getCurrentTimeSheet();
        var secondYieldedTimeSheet = instanceUnderTest.getCurrentTimeSheet();

        assertThat(firstYieldedTimeSheet).isNotSameAs(secondYieldedTimeSheet);
    }

    @ParameterizedTest
    @MethodSource("provideWorkingHours")
    public void addWorkingHours_moreThanSixHoursAdded_reduceByBreak(int workingHours, int workingHoursWithoutBreak) {
        var instanceUnderTest = new TimeTrack(2234);

        instanceUnderTest.addWorkingHours(workingHours);
        var timeSheet = instanceUnderTest.getCurrentTimeSheet();

        assertThat(timeSheet.getWorkingHours()).isEqualTo(workingHoursWithoutBreak);
    }

    private static Stream<Arguments> provideWorkingHours() {
        return Stream.of(
                Arguments.of(6, 5),
                Arguments.of(8, 7),
                Arguments.of(3,3),
                Arguments.of(12, 10),
                Arguments.of(60, 50));
    }
}
