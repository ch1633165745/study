package study.ch.Bean;

/**
 * @author shkstart
 * @create 2021-02-17-22:14
 */
public class Employee {
    private Integer id;
    private String empName;
    private Integer gender;
    private String email;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", empName='" + empName + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                '}';
    }

    public Employee(Integer id, String empName, Integer gender, String email) {
        this.id = id;
        this.empName = empName;
        this.gender = gender;
        this.email = email;
    }

    public Employee() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
