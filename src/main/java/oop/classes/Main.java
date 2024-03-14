package oop.classes;

public class Main {
    public static void main(String[] args) {
        int employeeId = 2234;
        var timeTrack = new TimeTrack(employeeId);
        System.out.println(String.format("Create timesheet of Employee with id %d", employeeId));
        System.out.println(String.format("Add %d working hours.", 10));
        timeTrack.addWorkingHours(10);
        System.out.println(String.format("Add another %d working hours.", 12));
        timeTrack.addWorkingHours(12);
        System.out.println(String.format("Add %d days sick leave.", 1));
        timeTrack.addSickLeave(1);
        System.out.println(String.format("Add another %d days sick leave", 1));
        timeTrack.addSickLeave(1);
        System.out.println(String.format("Add %d days sick leave.", 2));
        timeTrack.addVacation(2);
        System.out.println(String.format("Add %d days sick leave.", 1));
        timeTrack.addVacation(1);
        TimeSheet timeSheet = timeTrack.getCurrentTimeSheet();
        System.out.println(timeSheet.toString());
    }
}