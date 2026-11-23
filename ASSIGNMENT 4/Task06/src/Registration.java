public class Registration {
    private int id; private String studentId, studentName, eventName, department;
    public Registration() {}
    public Registration(String studentId,String studentName,String eventName,String department){this.studentId=studentId;this.studentName=studentName;this.eventName=eventName;this.department=department;}
    public int getId(){return id;} public void setId(int id){this.id=id;}
    public String getStudentId(){return studentId;} public String getStudentName(){return studentName;}
    public String getEventName(){return eventName;} public String getDepartment(){return department;}
}
