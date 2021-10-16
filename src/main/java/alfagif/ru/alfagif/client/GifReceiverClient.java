package alfagif.ru.alfagif.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

import java.net.URI;

/*
Feign клиент для загрузки гифки через uri
*/
@FeignClient(name = "gif-client", url = "https://null")
public interface GifReceiverClient {
    @GetMapping
    ResponseEntity<byte[]> getGif(URI uri);
}
