package my.sandbox.feign.test;

import my.sandbox.feign.clientSide.SimpleFeign;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class SimpleFeignTest {

    private static final String TEST_MESSAGE = "test message";

    @Autowired
    SimpleFeign client;

    @Test
    public void mirrorCallTest() {
        // when
        var result = client.mirror(TEST_MESSAGE);

        // then
        assertEquals(TEST_MESSAGE, result);
    }
}
