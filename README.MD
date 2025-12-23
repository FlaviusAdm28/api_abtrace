# Projeto de Testes de API - Java 17, RestAssured & TestNG

Este projeto contém testes de integração e end-to-end para APIs, utilizando **Java 17**, **RestAssured**, **TestNG** e recomenda-se a IDE **IntelliJ IDEA**.

---

## Pré-requisitos

Antes de começar, certifique-se de ter instalado:

1. **Java 17 JDK**
    - Verifique com:
      ```bash
      java -version
      ```
    - Deve retornar algo como:
      ```
      java version "17.0.x"
      ```

2. **IntelliJ IDEA** (Community ou Ultimate Edition)
    - Recomendado para execução e depuração dos testes.

3. **Maven** ou **Gradle** (dependendo de como está configurado o projeto)
    - Para Maven:
      ```bash
      mvn -version
      ```
    - Para Gradle:
      ```bash
      gradle -version
      ```

4. **Acesso à API**
    - Certifique-se de ter:
        - URL base da API (`baseURI`)
        - Token de autenticação válido (Bearer token ou outro método suportado)
---

## !! IMPORTANT !! READ ME !! IMPORTANT !!

DEVE FORNECE O TOKEN DE API MANUALMENTE NA CLASSE: src/main/java/com/abtrace/api/utils/TokenRetriever.java

A geração do TOKEN pode também ser totalmente automatizado desde que tenha acesso ao "App Client do Cognito" podendo passar diretamente na class "AutoTokenRetriever" em src/main/java/com/abtrace/api/utils/AutoTokenRetriever.java
