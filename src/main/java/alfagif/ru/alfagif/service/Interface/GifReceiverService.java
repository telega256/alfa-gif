package alfagif.ru.alfagif.service.Interface;

import org.springframework.http.ResponseEntity;

public interface GifReceiverService {
    ResponseEntity<byte[]> getRandomGif(String tag);
}
