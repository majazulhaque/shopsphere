# ADR-014: Checkout idempotency in PostgreSQL; open-checkout guard; price-change 409

- **Status:** Accepted
- **Date:** 2026-11-11
- **Decision register:** D2
- **Blueprint:** v1.1.1 §5.4, §6.4

## Context

Redis isn't durable enough to guard against duplicate charges.

## Decision

`idempotency_keys` and `open_checkout` are written in the same transaction as `OrderPlaced`. One open checkout per user. Prices are re-checked at checkout: a change returns `409 ORDER_PRICE_CHANGED`.

## Alternatives considered

- **Idempotency keys in Redis:** a flush could allow duplicate charges.

## Consequences

A 24-hour purge job for idempotency keys.
