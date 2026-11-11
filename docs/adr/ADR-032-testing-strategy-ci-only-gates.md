# ADR-032: Testing strategy & CI-only gates

- **Status:** Accepted
- **Date:** 2026-11-11
- **Decision register:** —
- **Blueprint:** v1.1.1 §15

## Context

Some suites can't run on the 8 GB development machine.

## Decision

JUnit 6, Testcontainers 2, WireMock, ArchUnit, golden-file contracts and the §15.2 scenario matrix. Heavy suites are required CI status checks.

## Alternatives considered

- **Local-only verification:** impossible on 8 GB.

## Consequences

CI is part of the definition of done.
