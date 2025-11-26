# 1. Define a imagem base (Java 17 minimalista)
FROM eclipse-temurin:17-jdk-alpine

# 2. Cria um volume temporário (opcional, mas boa prática para Spring Boot)
VOLUME /tmp

# 3. Copia o arquivo .jar gerado pelo Maven para dentro do container com o nome "app.jar"
# Nota: O nome original depende do seu pom.xml (demo-0.0.1-SNAPSHOT.jar)
COPY target/*.jar app.jar

# 4. O comando que o container vai rodar ao iniciar
ENTRYPOINT ["java","-jar","/app.jar"]