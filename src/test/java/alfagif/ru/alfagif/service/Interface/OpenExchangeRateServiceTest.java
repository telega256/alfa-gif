package alfagif.ru.alfagif.service.Interface;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(SpringRunner.class)
@SpringBootTest
class OpenExchangeRateServiceTest {

    @Autowired
    private OpenExchangeRateService exchangeService;

    @Test
    void getLatestRate() throws Exception {
        double result = exchangeService.getLatestRate("USD");
        assertNotEquals(0, result);
    }

    @Test
    void getHistoricalRate() throws Exception {
        double result = exchangeService.getYesterdayRate("USD");
        assertNotEquals(0, result);
    }
}