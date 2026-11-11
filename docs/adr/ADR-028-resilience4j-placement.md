# ADR-028: Resilience4j placement

- **Status:** Accepted
- **Date:** 2026-11-11
- **Decision register:** —
- **Blueprint:** v1.1.1 §3.12

## Context

Resilience patterns help on calls that can fail slowly, but applied everywhere they mask bugs.

## Decision

Circuit breaker + time limiter on gateway routes; circuit breaker + retry + timeout on order → catalog pricing; retry + circuit breaker + bulkhead on payment → Stripe. None on Kafka consumers (see ADR-016).

## Alternatives considered

- **Resilience4j everywhere:** masks bugs and adds latency.

## Consequences

Clear failure semantics: 503 Problem Details.
