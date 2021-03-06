package study.ch.Bean;


import java.util.List;

/**
 * @author shkstart
 * @create 2021-02-24-15:28
 */
public class Teacher {
    private Integer id;
    private String tname;
    private List<Student> students;

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", tname='" + tname + '\'' +
                ", students=" + students +
                '}';
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public Teacher(Integer id, String tname, List<Student> students) {
        this.id = id;
        this.tname = tname;
        this.students = students;
    }

    public Teacher() {
    }
}
