package org.example.streamdemo.studentdemo.entity;

public class MarksWrapper {

    private long id;
    private String standard;
    private int session;
    private Year year;
    private int attemptCount;
    private Result resultStatus;
    private Marks marks;

    public MarksWrapper(){

    }

    public MarksWrapper(long id, String standard, int session, Year year, int attemptCount, Result resultStatus, Marks marks) {
        this.id = id;
        this.standard = standard;
        this.session = session;
        this.marks = marks;
        this.year = year;
        this.attemptCount = attemptCount;
        this.resultStatus = resultStatus;
    }

    public Result getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(Result resultStatus) {
        this.resultStatus = resultStatus;
    }

    public int getAttemptCount() {
        return attemptCount;
    }

    public void setAttemptCount(int attemptCount) {
        this.attemptCount = attemptCount;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getStandard() {
        return standard;
    }

    public void setStandard(String standard) {
        this.standard = standard;
    }

    public int getSession() {
        return session;
    }

    public void setSession(int session) {
        this.session = session;
    }

    public Marks getMarks() {
        return marks;
    }

    public void setMarks(Marks marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "MarksWrapper{" +
                "id=" + id +
                ", standard='" + standard + '\'' +
                ", session=" + session +
                ", year=" + year +
                ", attemptCount=" + attemptCount +
                ", marks=" + marks +
                '}';
    }
}
