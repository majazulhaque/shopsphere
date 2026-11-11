# ADR-004: Spring Boot 4.1.x + Spring Cloud 2025.1.x + Gateway 5

- **Status:** Accepted
- **Date:** 2026-11-11
- **Decision register:** D7
- **Blueprint:** v1.1.1 §8.1

## Context

Spring Boot 3.5 reached end of OSS support in June 2026. Spring Boot 4.1 requires Spring Cloud 2025.1.x (2025.1.2 or later).

## Decision

Spring Boot 4.1.x, Spring Cloud 2025.1.x and Spring Cloud Gateway 5.0.x (server-webflux). **Pinned in Phase 0:** Spring Boot 4.1.2 (parent POM) and Spring Cloud 2025.1.4 (BOM import).

## Alternatives considered

- **Spring Boot 4.2:** too new at decision time; the Spring Cloud train lags behind it.
- **Spring Boot 3.5:** end of life.

## Consequences

Boot 4 breaking changes apply to all code: modular starters, Jackson 3, JUnit 6, Testcontainers 2, `@MockitoBean`, `RestTestClient`. The gateway uses `spring-cloud-starter-gateway-server-webflux` and the `spring.cloud.gateway.server.webflux.*` prefix. A 4.2 upgrade is a post-V1 task.
