package JavaBackend.buoi2.database2.Target;

public class AddAverage {
    private String StudentID;
    private String CourseID;
    private double Mark;
    private int Credits;
    public AddAverage(){

    }

    public AddAverage(String studentID, String courseID, double mark, int credits) {
        this.StudentID = studentID;
        this.CourseID = courseID;
        this.Mark = mark;
        this.Credits = credits;
    }

    public String getStudentID() {
        return StudentID;
    }

    public void setStudentID(String studentID) {
        StudentID = studentID;
    }

    public String getCourseID() {
        return CourseID;
    }

    public void setCourseID(String courseID) {
        CourseID = courseID;
    }

    public double getMark() {
        return Mark;
    }

    public void setMark(double mark) {
        Mark = mark;
    }

    public int getCredits() {
        return Credits;
    }

    public void setCredits(int credits) {
        Credits = credits;
    }

    @Override
    public String toString() {
        return "AddAverage{" +
                "StudentID='" + StudentID + '\'' +
                ", CourseID='" + CourseID + '\'' +
                ", Mark=" + Mark +
                ", Credits=" + Credits +
                '}';
    }
}
