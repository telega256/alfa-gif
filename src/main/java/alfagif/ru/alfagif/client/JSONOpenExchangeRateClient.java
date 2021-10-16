package alfagif.ru.alfagif.client;

import alfagif.ru.alfagif.model.ExchangeDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
/*
Feign клиент openexchangerates.org
*/
@org.springframework.cloud.openfeign.FeignClient(name = "openexchangerates-client", url = "${openexchangerates.url}")
public interface JSONOpenExchangeRateClient {

    @GetMapping("/latest.json")
    ResponseEntity<ExchangeDTO> getLatestRates(
            @RequestParam("app_id") String app_id,
            @RequestParam(value = "base", defaultValue = "USD") String base
    );

    @GetMapping("/historical/{date}.json")
    ResponseEntity<ExchangeDTO> getHistoricalRates(
            @PathVariable("date") String date,
            @RequestParam("app_id") String app_id,
            @RequestParam(value = "base", defaultValue = "USD") String base
    );
}
