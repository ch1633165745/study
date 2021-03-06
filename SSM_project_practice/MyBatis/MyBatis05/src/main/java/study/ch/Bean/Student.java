package study.ch.Bean;

/**
 * @author shkstart
 * @create 2021-02-24-15:29
 */
public class Student {
    private Integer id;
    private String sname;
    private Teacher teacher;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", sname='" + sname + '\'' +
                ", teacher=" + teacher +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student(Integer id, String sname, Teacher teacher) {
        this.id = id;
        this.sname = sname;
        this.teacher = teacher;
    }

    public Student() {
    }
}
