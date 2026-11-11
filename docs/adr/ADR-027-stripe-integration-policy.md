# ADR-027: Stripe integration policy

- **Status:** Accepted — **access BLOCKED (D5)**
- **Date:** 2026-11-11
- **Decision register:** D5, D13
- **Blueprint:** v1.1.1 §18, §2.5

## Context

Stripe accounts are invite-only in India and require a registered business; sandbox access is unconfirmed.

## Decision

Card-only PaymentIntents in INR with 3DS; idempotency keys on every mutating call; webhook signature check, deduplication and API-version alignment with the stripe-java pin; amount, currency and orderId verification; monotonic states; a reconciliation job; a refund retry schedule; an anti-corruption layer so Stripe types never leave payment-service. Test mode only.

## Alternatives considered

- **Fallbacks in §18.3** (an India-supported gateway behind the same ACL, or stripe-mock with signed fixtures): each needs explicit approval.

## Consequences

Phase 5 can't start until D5 is resolved (deadline: end of Day 14). The outcome will be recorded here and in `docs/runbooks/stripe-access.md`.
