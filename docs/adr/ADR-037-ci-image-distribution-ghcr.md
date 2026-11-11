# ADR-037: CI image distribution via GHCR public packages

- **Status:** Accepted (v1.1.1)
- **Date:** 2026-11-11
- **Decision register:** —
- **Blueprint:** v1.1.1 §22.7

## Context

Several jobs need the same images, and kind holding host and node copies would exceed the disk budget.

## Decision

Push SHA-tagged images to GHCR once; jobs and the kind node pull directly. A weekly cleanup keeps the last 20 SHAs plus release tags.

## Alternatives considered

- **`docker save` artifacts:** slower, with double copies in kind (kept as the fallback).
- **Rebuilding per job:** slow and not reproducible.

## Consequences

Images are public; they contain only already-public code, and the Trivy secret scan enforces that they contain no secrets.
