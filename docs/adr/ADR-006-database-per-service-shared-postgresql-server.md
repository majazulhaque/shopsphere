# ADR-006: Database per service on a shared PostgreSQL 18 server

- **Status:** Accepted
- **Date:** 2026-11-11
- **Decision register:** —
- **Blueprint:** v1.1.1 §5, §3.12

## Context

Each service must own its data (no shared database), yet everything must fit on an 8 GB laptop.

## Decision

One PostgreSQL 18 server with a separate database and login role per service, and `REVOKE CONNECT … FROM PUBLIC`. No cross-database queries. Flyway per service; `ddl-auto=validate`.

## Alternatives considered

- **A PostgreSQL container per database:** too much RAM.
- **A shared schema:** violates database-per-service ownership.

## Consequences

The single server is a development single point of failure (documented limitation). Isolation is proven by a test that a service's role can't connect to another service's database.
