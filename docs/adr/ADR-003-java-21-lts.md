# ADR-003: Java 21 LTS

- **Status:** Accepted
- **Date:** 2026-11-11
- **Decision register:** D7
- **Blueprint:** v1.1.1 §8.1

## Context

The backend needs an LTS JDK supported by Spring Boot 4 (17–25) with the broadest library track record.

## Decision

Eclipse Temurin 21 LTS (arm64 on the Mac); virtual threads available. **Pinned in Phase 0:** Temurin 21.0.13; the Enforcer requires Java `[21,22)`.

## Alternatives considered

- **Java 25:** also supported; its main additional benefit for us (AOT cache) isn't needed in V1.

## Consequences

A later upgrade is a one-line change plus a test run.
