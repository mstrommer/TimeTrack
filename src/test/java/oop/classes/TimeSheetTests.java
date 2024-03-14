package oop.classes;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

public class TimeSheetTests {

    @Test
    public void toString_emitsProperStringRepresentation() {
        int employeeId = 2245;
        int vacation = 21;
        int workingHours = 34;
        int sickLeave = 2;
        var instanceUnderTest = new TimeSheet(employeeId);
        instanceUnderTest.setVacation(vacation);
        instanceUnderTest.setWorkingHours(workingHours);
        instanceUnderTest.setSickLeave(sickLeave);

        String result = instanceUnderTest.toString();

        assertThat(result).
                contains(Integer.toString(employeeId)).
                contains(Integer.toString(vacation)).
                contains(Integer.toString(workingHours)).
                contains(Integer.toString(sickLeave));
    }
}
