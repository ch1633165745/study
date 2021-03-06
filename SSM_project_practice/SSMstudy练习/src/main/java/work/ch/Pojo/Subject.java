package work.ch.Pojo;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * @author shkstart
 * @create 2021-03-04-8:37
 */
public class Subject {
    private Integer id;
    private Integer subjectId;
    @NotEmpty
    private String subjectName;

    @Override
    public String toString() {
        return "Subject{" +
                "id=" + id +
                ", subjectId=" + subjectId +
                ", subjectName='" + subjectName + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(Integer subjectId) {
        this.subjectId = subjectId;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Subject(Integer id, Integer subjectId, String subjectName) {
        this.id = id;
        this.subjectId = subjectId;
        this.subjectName = subjectName;
    }

    public Subject() {
    }
}
