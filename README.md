# alfa-gif
# Описание
Cервис, который обращается к сервису курсов валют, и отдает gif в ответ:  
если курс по отношению к рублю за сегодня стал выше вчерашнего, то отдаем рандомную отсюда https://giphy.com/search/rich  
если ниже - отсюда https://giphy.com/search/broke  
Ссылки  
REST API курсов валют - https://docs.openexchangerates.org/  
REST API гифок - https://developers.giphy.com/docs/api#quick-start-guide  
Must Have  
Сервис на Spring Boot 2 + Java / Kotlin  
Запросы приходят на HTTP endpoint, туда передается код валюты  
Для взаимодействия с внешними сервисами используется Feign  
Все параметры (валюта по отношению к которой смотрится курс, адреса внешних сервисов и т.д.) вынесены в настройки  
На сервис написаны тесты (для мока внешних сервисов можно использовать @mockbean или WireMock)  
Для сборки должен использоваться Gradle  
Результатом выполнения должен быть репо на GitHub с инструкцией по запуску  
Nice to Have  
Сборка и запуск Docker контейнера с этим сервисом  
# Endpoints
Возвращает случайную гифку в зависимости от курса переданной валюты к рублю:  
```
alfa-gif/{currency}  
```
Пример:  
```
http://localhost:8080/alfa-gif/USD
```
# Инструкция по сборке и запуску .jar
- Склонировать удалённый репозиторий:
```
git clone https://github.com/telega256/alfa-gif.git
```
- Перейти в корневой каталог проекта и выполнить:
```
gradlew build && java -jar build/libs/alfa-gif-0.0.1.jar
```
# Сборка и запуск Docker контейнера
- Склонировать удалённый репозиторий:
```
git clone https://github.com/telega256/alfa-gif.git
```
- Перейти в корневой каталог проекта и выполнить:
```
gradlew build
```
- Собрать docker-образ:
```
docker build -t alfa-gif .
```
- Запустить контейнер с собранным docker-образом:
```
docker run -p 8080:8080 docker.io/library/alfa-gif
```
# Примечание
- Бесплатный тарифный план openexchangerates.org предоставляет информацию только для валюты 'USD' и ограничен 1000 запросами в месяц, 
поэтому данный сервис возвращает gif-изображение только для валюты 'git clone https://github.com/telega256/alfa-gif.git
gradlew build && java -jar build/libs/alfa-gif-0.0.1.jar
USD', иначе выдает ошибку.



