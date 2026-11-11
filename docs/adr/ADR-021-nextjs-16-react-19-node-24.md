# ADR-021: Next.js 16 + React 19.2 + Node 24 (replacing Next.js 14)

- **Status:** Accepted
- **Date:** 2026-11-11
- **Decision register:** D6
- **Blueprint:** v1.1.1 §8.2

## Context

Next.js 14 reached end of life in October 2025, Next.js 15 in October 2026, and Node 20 in April 2026.

## Decision

Next.js 16, React 19.2, Node 24 LTS (pinned with `.nvmrc` in Phase 0).

## Alternatives considered

- **Keep Next.js 14:** unsupported.

## Consequences

Async request APIs, `proxy.ts` instead of `middleware.ts`, Turbopack by default. The claude.ai project description still says Next.js 14 (assumption A10).
