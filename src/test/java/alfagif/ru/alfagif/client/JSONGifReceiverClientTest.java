package alfagif.ru.alfagif.client;

import alfagif.ru.alfagif.model.GifDTO;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class JSONGifReceiverClientTest {

    @Autowired
    JSONGifReceiverClient jsonGifClient;

    @Value("${giphy.api.key}")
    private String apiKey;
    @Value("${giphy.tag.broke}")
    private String tagBroke;
    @Value("${giphy.tag.rich}")
    private String tagRich;

    @Test
    void getBrokeGifJSON() throws Exception {
        ResponseEntity<GifDTO> response = jsonGifClient.getRandomGifJSON(apiKey, tagBroke);
        assertAll(
                () -> assertNotNull(response.getBody()),
                () -> assertNotNull(Objects.requireNonNull(response.getBody()).getData().get("image_original_url"))
        );
    }

    @Test
    void getRichGifJSON() throws Exception {
        ResponseEntity<GifDTO> response = jsonGifClient.getRandomGifJSON(apiKey, tagRich);
        assertAll(
                () -> assertNotNull(response.getBody()),
                () -> assertNotNull(Objects.requireNonNull(response.getBody()).getData().get("image_original_url"))
        );
    }
}