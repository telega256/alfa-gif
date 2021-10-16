package alfagif.ru.alfagif.service.Implementation;

import alfagif.ru.alfagif.client.JSONOpenExchangeRateClient;
import alfagif.ru.alfagif.model.ExchangeDTO;
import alfagif.ru.alfagif.service.Interface.OpenExchangeRateService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class OpenExchangeRateServiceImpl implements OpenExchangeRateService {

    private final JSONOpenExchangeRateClient jsonExchangeRateClient;

    @Value("${openexchangerates.app.id}")
    private String appId;
    @Value("${openexchangerates.base.currency}")
    private String baseCurrency;

    /*
       Возвращет текущий курс валюты по отношению к базовой валюте
    */
    @Override
    public double getLatestRate(String currency) {
        ExchangeDTO todayExchange = jsonExchangeRateClient.getLatestRates(appId, currency).getBody();
        return Objects.requireNonNull(todayExchange).getRates().get(baseCurrency);
    }

    /*
    Возвращет вчерашний курс валюты по отношению к базовой валюте
     */
    @Override
    public double getYesterdayRate(String currency) {
        String yesterday = (LocalDate.now().minusDays(1)).format(DateTimeFormatter.ISO_DATE);
        ExchangeDTO yesterdayExchange =
                jsonExchangeRateClient.getHistoricalRates(yesterday, appId, currency).getBody();
        return Objects.requireNonNull(yesterdayExchange).getRates().get(baseCurrency);
    }
}
