package alfagif.ru.alfagif.client;

import alfagif.ru.alfagif.model.GifDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/*
Feign клиент для giphy.com
*/
@FeignClient(name = "json-gif-client", url = "${giphy.url}")
public interface JSONGifReceiverClient {
    @GetMapping(value = "/random")
    ResponseEntity<GifDTO> getRandomGifJSON(
            @RequestParam("api_key") String api_key,
            @RequestParam("tag") String tag);
}
