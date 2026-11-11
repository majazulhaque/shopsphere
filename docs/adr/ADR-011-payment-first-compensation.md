# ADR-011: Payment-first compensation; reservation TTL longer than payment timeout

- **Status:** Accepted
- **Date:** 2026-11-11
- **Decision register:** —
- **Blueprint:** v1.1.1 §3.6, §4.5

## Context

Releasing stock before the payment is cancelled can strand a paid order with no stock.

## Decision

Cancel the payment before releasing stock. The reservation TTL (45 min) is longer than the payment timeout (30 min). Commit is defensive: if the allocation was released, re-reserve, otherwise reply `InventoryCommitFailed`, which leads to a refund.

## Alternatives considered

- **Release stock first:** can strand money.

## Consequences

One extra round-trip on cancellation.
