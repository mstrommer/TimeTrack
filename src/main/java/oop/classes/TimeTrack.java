package oop.classes;

import java.sql.Time;

/**
 * @ProgrammingProblem.Category Simple Classes
 */
public class TimeTrack {


    /* private fields here */
    private TimeSheet currentTimeSheet;

    /**
     * Creates a new instance of TimeTrack by passing in the
     * id of the affected employee.
     */
    public TimeTrack(int employeeId) {
        currentTimeSheet = new TimeSheet(employeeId);
    }

    /**
     * Creates a new instance of TimeTrack that is initialized
     * with the passed in TimeSheet instance.
     */
    public TimeTrack(TimeSheet timeSheet) {
        currentTimeSheet = new TimeSheet(timeSheet);
    }

    /**
     * Gets a deep copy of the current timesheet.
     * The timesheet contains the currently added
     * time tracking data (e.g.: workinghours, sickleave)
     */
    public TimeSheet getCurrentTimeSheet() {
        return currentTimeSheet;
    }

    /**
     * Adds the specified amount of working hours to the time tracking.
     * After each 6 hours working time a break of 1 hour has to be made.
     * The required break time is subtracted from the passed working hours
     * automatically (e.g.: 14 working hours -&gt; 2 hours for break are subtracted
     * -&gt; 12 working hours are effectively added).
     */
    public void addWorkingHours(int hours) {
        int breaks = 0;
        breaks = hours / 6;
        currentTimeSheet.setWorkingHours(currentTimeSheet.getWorkingHours() + hours - breaks);
    }

    /**
     * Registers the specified amount of days as sick leave.
     */
    public void addSickLeave(int days) {
        currentTimeSheet.setSickLeave(currentTimeSheet.getSickLeave() + days);
    }

    /**
     * Add the specified amount of vacation days.
     */
    public void addVacation(int days) {
        currentTimeSheet.setVacation(currentTimeSheet.getVacation() + days);
    }

    /**
     * Starts a new time tracking period and resets
     * all already stored tracking data.
     */
    public void startNewPeriod() {
        currentTimeSheet.setVacation(0);
        currentTimeSheet.setSickLeave(0);
        currentTimeSheet.setWorkingHours(0);
    }
}
