package alfagif.ru.alfagif.service.Implementation;

import alfagif.ru.alfagif.client.JSONOpenExchangeRateClient;
import alfagif.ru.alfagif.model.ExchangeDTO;
import alfagif.ru.alfagif.service.Interface.OpenExchangeRateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

@Service
public class OpenExchangeRateServiceImpl implements OpenExchangeRateService {

    JSONOpenExchangeRateClient jsonExchangeRateClient;

    @Value("${openexchangerates.app.id}")
    private String app_id;
    @Value("${openexchangerates.base.currency}")
    private String base_currency;
    @Value("${openexchangerates.base.usd}")
    private String base_usd;
    @Autowired
    public OpenExchangeRateServiceImpl(
            JSONOpenExchangeRateClient jsonExchangeRateClient) {

        this.jsonExchangeRateClient = jsonExchangeRateClient;
    }

    /*
       Возвращет текущий курс валюты по отношению к базовой валюте
    */
    @Override
    public double getLatestRate(String currency) {
        ExchangeDTO todayExchange = jsonExchangeRateClient.getLatestRates(app_id, currency).getBody();
        double todayRate = Objects.requireNonNull(todayExchange).getRates().get(base_currency);
        return todayRate;
    }

    /*
    Возвращет вчерашний курс валюты по отношению к базовой валюте
     */
    @Override
    public double getYesterdayRate(String currency) {
        String yesterday = (LocalDate.now().minusDays(1)).format(DateTimeFormatter.ISO_DATE);
        ExchangeDTO yesterdayExchange =
                jsonExchangeRateClient.getHistoricalRates(yesterday, app_id, currency).getBody();
        double yesterdayRate = Objects.requireNonNull(yesterdayExchange).getRates().get(base_currency);
        return yesterdayRate;
    }
}
