# ADR-001: Record architecture decisions

- **Status:** Accepted
- **Date:** 2026-11-11
- **Decision register:** —
- **Blueprint:** v1.1.1 Appendix A

## Context

Architectural decisions must stay traceable for future changes and for explaining the system in interviews.

## Decision

Every significant decision is a Markdown ADR in `docs/adr/`, one file per decision, in the format Status · Context · Decision · Alternatives · Consequences. An accepted ADR is immutable: a changed decision is a new ADR that supersedes it, and the old one's status becomes "Superseded by ADR-NNN".

## Alternatives considered

- **Wiki pages:** drift away from the code they describe.

## Consequences

A small documentation overhead per decision. `docs/adr/README.md` indexes all ADRs.
