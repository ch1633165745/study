package study.ch.Bean;

import org.omg.PortableInterceptor.INACTIVE;

import java.util.Date;

/**
 * @author shkstart
 * @create 2021-02-24-21:09
 */
public class Teacher {
    private Integer id;//编号
    private String name;//姓名
    private String course;//课程
    private String address;//住址
    private Date birth;//生日

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", course='" + course + '\'' +
                ", address='" + address + '\'' +
                ", birth=" + birth +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public Teacher(Integer id, String name, String course, String address, Date birth) {
        this.id = id;
        this.name = name;
        this.course = course;
        this.address = address;
        this.birth = birth;
    }

    public Teacher() {
    }
}
