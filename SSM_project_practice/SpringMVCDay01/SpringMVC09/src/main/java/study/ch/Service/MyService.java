package study.ch.Service;

import org.springframework.stereotype.Service;

/**
 * 在spring容器中
 */
@Service
public class MyService {

    public MyService(){
        System.out.println("MyService...");
    }
}
