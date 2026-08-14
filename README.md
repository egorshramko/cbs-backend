# Backend для системы бронирования билетов в кинотеатр
## Весь проект размещен [тут](https://github.com/egorshramko/cbs) 

## Сборка бэкенда для локальной разработки
0. Для сборки необходимо установить Maven и Java 21, а так же потребуется доступ к базе PostgreSQL (можно использовать этот [compose.yaml](https://github.com/egorshramko/cbs/blob/develop/compose/compose.yaml) для быстрого запуска базы в Docker).
1. В каталоге .mvn переименуйте maven.config.example в maven.config и заполните файл данными для подключения к своей базе
2. В Linux/MacOS собрать проект можно командой
```
./mvnw clean package
```
или для Windows
```
./mvnw.cmd clean package
```
После чего в каталоге target появится jar-файл, готовый к запуску

## Запуск бэкенда для локальных тестов
0. Установите в своей системе следующие переменные окружения:
    CBS_POSTGRES_URL - адрес для подключения к базе данных в формате *jdbc:postgresql://ваш_адрес:ваш_порт/название_базы*
    CBS_POSTGRES_USER - имя пользователя базы данных
    CBS_POSTGRES_PASSWORD - пароль пользователя базы данных
1. Запустите jar-файл *target/cbs-backend-{версия_сборки}.jar* командой
```
java -jar имя_файла
```