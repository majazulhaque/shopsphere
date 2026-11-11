# ADR-009: Transactional outbox + idempotent inbox (`common-messaging`)

- **Status:** Accepted
- **Date:** 2026-11-11
- **Decision register:** —
- **Blueprint:** v1.1.1 §3.11, §5.1

## Context

A database transaction and a Kafka send can't be one atomic operation.

## Decision

The outbox row is written in the business transaction. A single active relay per service (PostgreSQL advisory lock) sends rows in sequence order with `acks=all` and an idempotent producer, restoring trace and correlation headers; errors back off exponentially and are reported by a backlog metric and health status. Consumers record `processed_event` in their own transaction. Sent rows are purged after 7 days.

## Alternatives considered

- **Debezium CDC:** extra infrastructure.
- **Kafka transactions:** don't cover the database.
- **Spring Modulith event registry:** monolith-oriented.

## Consequences

Publish latency up to about 0.5 s. Delivery is at-least-once; duplicates are absorbed by the inbox.
