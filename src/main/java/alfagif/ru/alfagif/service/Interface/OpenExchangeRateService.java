package alfagif.ru.alfagif.service.Interface;


public interface OpenExchangeRateService {
    double getLatestRate(String currency);
    double getYesterdayRate(String currency);

}
