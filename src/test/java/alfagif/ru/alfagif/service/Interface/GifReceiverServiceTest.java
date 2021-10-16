package alfagif.ru.alfagif.service.Interface;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class GifReceiverServiceTest {

    @Autowired
    GifReceiverService gifService;

    @Value("${giphy.tag.broke}")
    private String tagBroke;
    @Value("${giphy.tag.rich}")
    private String tagRich;

    @Test
    void getBrokeGif() throws Exception {
        ResponseEntity<byte[]> result = gifService.getRandomGif(tagBroke);
        assertNotEquals(0, result.getBody().length);
    }

    @Test
    void getRichGif() throws Exception {
        ResponseEntity<byte[]> result = gifService.getRandomGif(tagRich);
        assertNotEquals(0, result.getBody().length);
    }
}