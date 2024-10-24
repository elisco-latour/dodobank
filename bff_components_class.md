# BFF Web Service
This code diagram provides a clearer picture of how the BFF components are structured and how they collaborate to handle authentication and API proxying.

## Class Diagram
``` mermaid
classDiagram
    class AuthController {
        -tokenService: TokenService
        +login(): ResponseEntity<Void>
        +callback(): ResponseEntity<String>
    }

    class TokenService {
        -jwtDecoder: JwtDecoder
        +decodeToken(token: String): DecodedJWT
        +extractUserInfo(decodedJWT: DecodedJWT): User
    }

    class ProxyController {
        -sessionService: SessionService
        -tokenService: TokenService
        +proxyRequest(request: HttpServletRequest): Mono<ResponseEntity<String>>
    }

    class SessionService {
        +createSession(user: User): String
        +getSession(sessionId: String): User
        +deleteSession(sessionId: String): void
    }

    AuthController --> TokenService : Uses
    ProxyController --> SessionService : Uses
    ProxyController --> TokenService : Uses
```

This diagram visualizes the classes and their relationships within the BFF Components:

- **Classes**: Each box represents a class (e.g., `AuthController`, `TokenService`).
- **Methods:** Lines within each box represent methods and their return types (e.g., login(): ResponseEntity<Void>).
- **Relationships:** Arrows indicate dependencies and how classes interact:
    - `AuthController` uses (Uses) `TokenService` for token-related operations.
    - `ProxyController` uses both `SessionService` (for session management) and `TokenService` (for token validation).

Explanation:

1. AuthController:
    - Handles authentication endpoints like `/login` and `/callback`.
    - Uses `TokenService` to decode and process tokens received from Keycloak.
2. TokenService:
    - Provides methods for decoding JWT tokens, extracting user information from them, and potentially handling token refresh.
3. ProxyController:
    - Intercepts API requests from the frontend.
    - Uses SessionService to check if a valid session exists (meaning the user is authenticated).
    - Uses TokenService to validate the JWT token if session management is not used or as an additional security layer.
    - Forwards the request to the Resource Server if authorized.
4. SessionService:

    - Manages user sessions, typically using a persistent store like Redis.
    - Provides methods to create, retrieve, and delete session data.
