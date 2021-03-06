package work.ch.Pojo;

/**
 * @author shkstart
 * @create 2021-03-04-8:59
 */
public class subject_student {
    private Integer id;
    private Student student;
    private Subject subject;

    @Override
    public String toString() {
        return "subject_student{" +
                "id=" + id +
                ", student=" + student +
                ", subject=" + subject +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public subject_student(Integer id, Student student, Subject subject) {
        this.id = id;
        this.student = student;
        this.subject = subject;
    }

    public subject_student() {
    }
}
