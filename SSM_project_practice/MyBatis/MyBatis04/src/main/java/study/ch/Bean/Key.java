package study.ch.Bean;

import org.omg.PortableInterceptor.LOCATION_FORWARD;

import java.util.List;

/**
 * 钥匙表
 */
public class Key {
    private Integer id;
    private String KeyName;
    private Lock lock;


    @Override
    public String toString() {
        return "Key{" +
                "id=" + id +
                ", KeyName='" + KeyName + '\'' +
                ", lock=" + lock +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKeyName() {
        return KeyName;
    }

    public void setKeyName(String keyName) {
        KeyName = keyName;
    }

    public Lock getLock() {
        return lock;
    }

    public void setLock(Lock lock) {
        this.lock = lock;
    }

    public Key(Integer id, String keyName, Lock lock) {
        this.id = id;
        KeyName = keyName;
        this.lock = lock;
    }

    public Key() {
    }
}
