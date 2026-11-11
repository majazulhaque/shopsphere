# ADR-005: Maven multi-module build

- **Status:** Accepted
- **Date:** 2026-11-11
- **Decision register:** D7
- **Blueprint:** v1.1.1 §8.1, §12

## Context

The monorepo needs one build tool for all backend modules.

## Decision

Maven multi-module with a parent POM (Spring Boot parent, Spring Cloud BOM, Enforcer rules) and the Maven Wrapper. **Pinned in Phase 0:** Maven 3.9.16 via Maven Wrapper 3.3.4 (`only-script`, distribution verified by SHA-256).

## Alternatives considered

- **Gradle:** faster incremental builds, but more build-logic complexity.

## Consequences

Single-service builds use `./mvnw -pl <module> -am`.
