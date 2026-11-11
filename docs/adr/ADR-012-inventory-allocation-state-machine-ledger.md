# ADR-012: Inventory allocation state machine + append-only stock ledger

- **Status:** Accepted
- **Date:** 2026-11-11
- **Decision register:** —
- **Blueprint:** v1.1.1 §4.2, §5.3

## Context

Releasing a reservation and restocking committed stock are different operations, and both must be idempotent.

## Decision

Each order line has an allocation state (`RESERVED`, `COMMITTED`, `RELEASED`, `RESTOCKED`). Every transition writes `stock_movements` with `UNIQUE(order_id, sku, type)`. Database CHECKs prevent negative stock and overselling. Commands in the wrong state get explicit replies.

## Alternatives considered

- **A generic compensate command:** can't distinguish release from restock.
- **Admin re-receive of stock:** not idempotent.

## Consequences

A provable invariant: `on_hand = Σ delta_on_hand` and `reserved = Σ delta_reserved` per SKU.
