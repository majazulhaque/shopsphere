# ADR-025: Redis usage boundaries

- **Status:** Accepted
- **Date:** 2026-11-11
- **Decision register:** D2
- **Blueprint:** v1.1.1 §3.12

## Context

Redis is fast but not a system of record.

## Decision

Redis is used for the cart, caches and gateway rate limiting only; never for idempotency, stock, orders or money. AOF on locally; a TTL on every key.

## Alternatives considered

- **Redis for idempotency keys:** rejected in ADR-014.

## Consequences

In production, cache and cart would be separate instances.
