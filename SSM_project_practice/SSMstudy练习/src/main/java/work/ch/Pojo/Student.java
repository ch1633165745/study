package work.ch.Pojo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author shkstart
 * @create 2021-03-04-8:32
 */
public class Student {
    private Integer id;
    private Integer studentId;
    @NotEmpty
    private String studentName;
    private Integer gender;
    @NotEmpty
    private String className;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", gender=" + gender +
                ", className='" + className + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Student(Integer id, Integer studentId, String studentName, Integer gender, String className) {
        this.id = id;
        this.studentId = studentId;
        this.studentName = studentName;
        this.gender = gender;
        this.className = className;
    }

    public Student() {
    }
}
