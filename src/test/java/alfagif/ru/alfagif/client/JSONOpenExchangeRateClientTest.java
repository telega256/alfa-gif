package alfagif.ru.alfagif.client;

import alfagif.ru.alfagif.model.ExchangeDTO;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class JSONOpenExchangeRateClientTest {

    @Autowired
    JSONOpenExchangeRateClient jsonExchangeRateClient;

    @Value("${openexchangerates.app.id}")
    private String app_id;
    @Value("${openexchangerates.base.usd}")
    private String base_usd;

    @Test
    void getLatestRate() throws Exception {
        ResponseEntity<ExchangeDTO> response = jsonExchangeRateClient.getLatestRates(app_id, base_usd);
        assertAll(
                () -> assertNotNull(response.getBody()),
                () -> assertNotNull(Objects.requireNonNull(response.getBody()).getRates().get("RUB"))
        );
    }

    @Test
    void getHistoricalRate() throws Exception {
        String yesterday = (LocalDate.now().minusDays(1)).format(DateTimeFormatter.ISO_DATE);
        ResponseEntity<ExchangeDTO> response = jsonExchangeRateClient.getHistoricalRates(yesterday, app_id, base_usd);
        assertAll(
                () -> assertNotNull(response.getBody()),
                () -> assertNotNull(Objects.requireNonNull(response.getBody()).getRates().get("RUB"))
        );
    }
}