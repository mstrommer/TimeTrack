package oop.classes;

import java.sql.Time;

/**
 * @ProgrammingProblem.Category Simple Classes
 */

public class TimeSheet {

    // Attributes
    private int employeeId;
    private int workingHours;
    private int sickLeave;
    private int vacation;

    /**
     * Creates a new instance of TimeSheet for the
     * specified employee id.
     * 
     * @ProgrammingProblem.Aspect Constructor
     */
    public TimeSheet(int employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * 
     * @param workingHours
     * @ProgrammingProblem.Aspect simple setter
     */
    public void setWorkingHours(int workingHours) {
        this.workingHours = workingHours;
    }

    /**
     * 
     * @param sickLeave
     * @ProgrammingProblem.Aspect simple setter
     */
    public void setSickLeave(int sickLeave) {
        this.sickLeave = sickLeave;
    }

    /**
     * 
     * @param vacation
     * @ProgrammingProblem.Aspect simple setter
     */
    public void setVacation(int vacation) {
        this.vacation = vacation;
    }

    /**
     * Creates a new instance of TimeSheet that is
     * a deep copy of the input argument.
     * (copy constructor)
     * 
     * @ProgrammingProblem.Aspect DeepCopyConstructor
     */
    public TimeSheet(TimeSheet copyFrom) {
        this(copyFrom.employeeId);
        this.vacation = copyFrom.vacation;
        this.workingHours = copyFrom.workingHours;
        this.sickLeave = copyFrom.sickLeave;
    }


    /**
     * 
     * @return
     * 
     *  @ProgrammingProblem.Aspect simple getter
     */
    public int getEmployeeId() {
        return employeeId; // this.employeeId
    }

    /**
     * @ProgrammingProblem.Aspect simple getter
     * @return
     */
    public int getSickLeave() {
        return sickLeave;
    }

    /**
     * @ProgrammingProblem.Aspect simple getter
     * @return
     */
    public int getWorkingHours() {
        return workingHours;
    }

    /**
     * @ProgrammingProblem.Aspect simple getter
     * @return
     */
    public int getVacation() {
        return vacation;
    }

    @Override
    public String toString() {
        return "Time sheet of employeeId -> " + employeeId +
                "\tworkingHours -> " + workingHours +
                "\tsickLeave -> " + sickLeave +
                "\tvacation -> " + vacation;
        /*
        Time sheet of employeeId -> 2234
        workingHours -> 19
        sickLeave -> 2
        vacation -> 3
         */
    }
}
