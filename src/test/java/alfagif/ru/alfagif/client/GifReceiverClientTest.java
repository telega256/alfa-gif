package alfagif.ru.alfagif.client;

import alfagif.ru.alfagif.service.Interface.GifReceiverService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.URI;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class GifReceiverClientTest {

    @Autowired
    private GifReceiverClient gifClient;

    @Test
    void getGif() throws Exception {
        URI uri = URI.create("https://media3.giphy.com/media/l46C8KMgAQrytwhe8/giphy.gif");
        ResponseEntity<byte[]> result = gifClient.getGif(uri);
        assertNotEquals(0, result.getBody().length);
    }
}