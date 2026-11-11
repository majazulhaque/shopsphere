# ADR-022: openid-client + encrypted server-side session

- **Status:** Accepted
- **Date:** 2026-11-11
- **Decision register:** D8
- **Blueprint:** v1.1.1 §3.4, §9

## Context

Auth.js is in security-only maintenance (v5 still beta); tokens must never reach browser JavaScript.

## Decision

Authorization Code + PKCE through `openid-client`; a JWE-encrypted, httpOnly cookie; server-side refresh with rotation; logout revokes the refresh token. Covered by the dedicated D8 security test set.

## Alternatives considered

- **Auth.js v5 beta:** maintenance status.
- **Better Auth:** a second user store.
- **keycloak-js:** tokens in the browser.

## Consequences

About 200 lines of owned authentication code, with its own tests.
