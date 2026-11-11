# ADR-035: Inter-service communication: asynchronous by default

- **Status:** Accepted
- **Date:** 2026-11-11
- **Decision register:** —
- **Blueprint:** v1.1.1 §1.3, §3.8

## Context

Synchronous call chains couple services and cascade failures.

## Decision

Only order → catalog pricing is synchronous, because it needs an immediate answer. The frontend combines product-page data itself; services don't fan out.

## Alternatives considered

- **Synchronous call chains:** coupling and cascading failures.
- **A dedicated BFF service:** not in the brief.

## Consequences

Eventual consistency in projections, with documented lags.
