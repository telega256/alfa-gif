package alfagif.ru.alfagif.controller;

import alfagif.ru.alfagif.service.Interface.GifReceiverService;
import alfagif.ru.alfagif.service.Interface.OpenExchangeRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/alfa-gif")
@RequiredArgsConstructor
public class MainController {

     private final GifReceiverService gifService;
     private final OpenExchangeRateService exchangeService;

    @Value("${giphy.tag.broke}")
    private String tag_broke;
    @Value("${giphy.tag.rich}")
    private String tag_rich;

    /*
    Возвращает случайную гифку в зависимости от курса переданной валюты к рублю
     */
    @GetMapping("/{currency}")
    public ResponseEntity<byte[]> ReceiveGif(@PathVariable String currency) {
        double todayRate = exchangeService.getLatestRate(currency);
        double yesterdayRate = exchangeService.getYesterdayRate(currency);
        String result = (todayRate > yesterdayRate) ? tag_rich : tag_broke;
        return gifService.getRandomGif(result);
    }
}
