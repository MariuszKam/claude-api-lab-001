# Claude Developer Foundations Lab

Hands-on Java project for **Claude Certified Developer – Foundations (CCDV-F v1.1)**.

## Prerequisites
- JDK 25 (the installed Temurin 25 toolchain)
- Gradle wrapper included in the repository
- Anthropic API key for **optional paid API calls**

## Run without API usage
```powershell
.\gradlew.bat test
.\gradlew.bat run --args="--dry-run"
```

## First real request (optional)
Configure `ANTHROPIC_API_KEY` as an environment variable in your own terminal or IntelliJ run configuration.
Do **not** commit credentials or paste keys into chat.
```powershell
.\gradlew.bat run --args="--ask Explain dependency injection in Java"
```
This makes a real request and can incur API charges. The model can be overridden with `ANTHROPIC_MODEL`.

## Structure
- `src/main/java/dev/claudefoundations/lab` — API client entry point and environment validation
- `src/test/java/dev/claudefoundations/lab` — automated unit tests
- `labs/lesson-01` — first lesson tasks

## Study rules
- Do not commit secrets.
- Never treat HTTP 200 as proof of a complete answer; inspect `stop_reason`.
- The example client intentionally leaves multi-turn conversation and full stop-reason handling as exercises.
- Streaming, retries, tools, MCP, caching, batches, and evaluation are future labs.

Official docs: https://platform.claude.com/docs/en/api/messages/create
