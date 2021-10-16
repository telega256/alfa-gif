package alfagif.ru.alfagif.service.Implementation;

import alfagif.ru.alfagif.client.GifReceiverClient;
import alfagif.ru.alfagif.client.JSONGifReceiverClient;
import alfagif.ru.alfagif.model.GifDTO;
import alfagif.ru.alfagif.service.Interface.GifReceiverService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class GifReceiverServiceImpl implements GifReceiverService {

    private final JSONGifReceiverClient jsonGifClient;
    private final GifReceiverClient gifClient;

    @Value("${giphy.api.key}")
    private String apiKey;

    /*
    Возвращет случайную гифку с giphy.com по тегу
     */
    public ResponseEntity<byte[]> getRandomGif(String tag) {
        GifDTO gifDTO = jsonGifClient.getRandomGifJSON(apiKey, tag).getBody();
        URI uri = URI.create(String.valueOf(Objects.requireNonNull(gifDTO).getData().get("image_original_url")));
        return gifClient.getGif(uri);
    }
}
