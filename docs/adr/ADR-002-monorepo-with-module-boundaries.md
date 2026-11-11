# ADR-002: Monorepo with module boundaries

- **Status:** Accepted
- **Date:** 2026-11-11
- **Decision register:** —
- **Blueprint:** v1.1.1 §12

## Context

One developer builds seven services, three platform applications and shared contracts (event envelope, libraries).

## Decision

A single repository. Services depend only on `backend/libs/*`, never on each other. App-to-app dependencies are banned by the Maven Enforcer `bannedDependencies` rule in the parent POM (in place since Phase 0) and by ArchUnit tests (from Phase 1). Libraries hold contracts and plumbing only, never domain logic. Each service keeps its own build, configuration, database and deployment.

## Alternatives considered

- **Polyrepo (one repository per service):** coordination overhead without benefit for a single developer.

## Consequences

Discipline is needed so the monorepo doesn't become a distributed monolith; the Enforcer and ArchUnit rules make violations fail the build.
