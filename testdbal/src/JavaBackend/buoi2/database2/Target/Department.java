package JavaBackend.buoi2.database2.Target;

public class Department {
    private String DeptID;
    private String Name;
    private String NoOFStudent;
    public Department(){

    }

    public Department(String deptID, String name, String noOFStudent) {
        this.DeptID = deptID;
        this.Name = name;
        this.NoOFStudent = noOFStudent;
    }

    public String getDeptID() {
        return DeptID;
    }

    public void setDeptID(String deptID) {
        DeptID = deptID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getNoOFStudent() {
        return NoOFStudent;
    }

    public void setNoOFStudent(String noOFStudent) {
        NoOFStudent = noOFStudent;
    }

    @Override
    public String toString() {
        return "Department{" +
                "DeptID='" + DeptID + '\'' +
                ", Name='" + Name + '\'' +
                ", NoOFStudent='" + NoOFStudent + '\'' +
                '}';
    }
}
