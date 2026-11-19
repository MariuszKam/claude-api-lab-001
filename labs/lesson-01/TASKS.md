# Lesson 01 — Messages API: request to response

Domain: **2. Applications and Integration** (CCDV-F v1.1).

## Your tasks
1. Explain `system`, `user`, `assistant` and content blocks.
2. Implement a `ClaudeMessageService` with a `sendMessage(String prompt)` method.
3. Distinguish `end_turn`, `max_tokens` and `tool_use` instead of blindly returning the first block.
4. Implement a second conversation turn by sending the relevant history.
5. Add unit tests without making real paid API requests.
6. Identify how errors 400, 401, 429, 500 and 529 should be handled.

## Acceptance criteria
- `gradlew test` passes.
- No API key is stored in tracked files.
- `--dry-run` never contacts the API.
- Incomplete output is not silently marked as complete.
- Tests cover the main branches without network access.

Do not copy a full solution. Implement and explain your choices; submit code for review.
