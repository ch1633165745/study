package study.ch.Bean;

import java.util.List;

/**
 * 锁子表
 */
public class Lock {
    private Integer id;
    private String LockName;

    public List<Key> getKeys() {
        return keys;
    }

    public void setKeys(List<Key> keys) {
        this.keys = keys;
    }

    private List<Key> keys;

    @Override
    public String toString() {
        return "Lock{" +
                "id=" + id +
                ", LockName='" + LockName + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLockName() {
        return LockName;
    }

    public void setLockName(String lockName) {
        LockName = lockName;
    }

    public Lock(Integer id, String lockName) {
        this.id = id;
        LockName = lockName;
    }

    public Lock() {
    }
}
