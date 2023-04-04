package com.example.ex3_2_back;

import com.example.ex3_2_back.entity.User;
import com.example.ex3_2_back.security.MySecurity;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class SecurityTest {
    MySecurity mySecurity;

    @Autowired
    public void setMySecurity(MySecurity mySecurity) {
        this.mySecurity = mySecurity;
    }

    @Test
    void testSecurity() {
        log.info(mySecurity.genToken(new User()));
    }
}
