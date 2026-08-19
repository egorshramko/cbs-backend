ARG JDK_VERSION=21-jdk 
ARG JRE_VERSION=21-jre 

#==================================================
# Этап 1: Установка зависимостей и сборка
#==================================================

FROM eclipse-temurin:${JDK_VERSION} AS build
WORKDIR /cbs-backend
COPY . .
RUN ./mvnw package -DskipTests

#==================================================
# Этап 2: Запуск приложения
#==================================================

FROM eclipse-temurin:${JRE_VERSION} AS runner
WORKDIR /app

COPY --from=build /cbs-backend/target/*.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]

