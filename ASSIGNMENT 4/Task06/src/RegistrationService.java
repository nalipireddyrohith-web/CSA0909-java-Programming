import java.sql.SQLException; import java.util.List;
public class RegistrationService {
    private final RegistrationDAO dao=new RegistrationDAO();
    public String register(Registration r){if(r.getStudentId()==null||r.getStudentId().trim().isEmpty())return"Student ID is required.";if(r.getStudentName()==null||r.getStudentName().trim().isEmpty())return"Student name is required.";if(r.getEventName()==null||r.getEventName().trim().isEmpty())return"Event name is required.";if(r.getDepartment()==null||r.getDepartment().trim().isEmpty())return"Department is required.";try{if(dao.isDuplicate(r))return"Duplicate registration.";dao.insert(r);return"Registration successful.";}catch(SQLException e){return"Database error: "+e.getMessage();}}
    public List<Registration> filter(String event)throws SQLException{return dao.findByEvent(event);}
}
