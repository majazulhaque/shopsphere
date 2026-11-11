# ADR-007: Event Sourcing for the Order aggregate only, with a custom PostgreSQL event store

- **Status:** Accepted
- **Date:** 2026-11-11
- **Decision register:** —
- **Blueprint:** v1.1.1 §3.9, §5.4

## Context

The order history is the business record and drives the checkout saga.

## Decision

Only the Order aggregate is event-sourced, in `order_event_store` with `UNIQUE(aggregate_id, version)` and `UNIQUE(event_id)`. Event payloads are versioned and upcast on load. No snapshots (fewer than 20 events per order).

## Alternatives considered

- **Axon Framework:** heavy and hides the mechanics.
- **EventStoreDB:** extra infrastructure.
- **Kafka as the event store:** no per-aggregate load or optimistic concurrency.

## Consequences

About 300–500 lines of owned code. A version-conflict retry policy is required (reload and retry up to 5 times with jitter).
