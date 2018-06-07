package se.kth.hogk.poe_chat_parser.hello;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import java.net.URL;

import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class GreetingControllerIT {

    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate template;


    @Before
    public void setUp() throws Exception {
        this.base = new URL("http://localhost:" + port + "/");
    }

    @Test
    public void testHello() throws Exception {
        ResponseEntity<String> response = template.getForEntity(base.toString(),
                String.class);
        assertThat(response.getBody(), equalTo("Welcome to my program"));
    }

    @Test
    public void testGreeting() throws Exception {
        /*this.base = new URL(base + "greeting");
        ResponseEntity<String> response = template.getForEntity(base.toString(),
                String.class);
        assertThat(response.getBody(), equalTo("{\"id\":1,\"content\":\"Hello, World!\"}"));*/
        GreetingController greetingController = new GreetingController();
        Greeting result = greetingController.greeting("World");
        assertThat(result.getId(), Matchers.is((long)1));
        assertThat(result.getContent(), Matchers.is("Hello, World!"));
    }

    @Test
    public void testGreetingUser() throws Exception {
        GreetingController greetingController = new GreetingController();
        Greeting result = greetingController.greeting("User");
        assertThat(result.getId(), Matchers.is((long)1));
        assertThat(result.getContent(), Matchers.is("Hello, User!"));
    }

}
