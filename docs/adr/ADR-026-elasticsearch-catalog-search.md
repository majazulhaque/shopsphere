# ADR-026: Elasticsearch 9.4 for catalog search

- **Status:** Accepted
- **Date:** 2026-11-11
- **Decision register:** —
- **Blueprint:** v1.1.1 §3.10, §3.12

## Context

The brief requires Elasticsearch, and search needs facets, suggestions and relevance.

## Decision

Alias-based indices; external versioning for product snapshots; versioned partial updates for rating and stock; a re-index operation. Security and ML are disabled only locally and in CI.

## Alternatives considered

- **PostgreSQL full-text search:** weaker facets and relevance, and the brief requires Elasticsearch.

## Consequences

About 1 GB RAM when running, so it is profile-gated locally.
