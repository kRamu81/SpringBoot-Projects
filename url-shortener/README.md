# URL Shortener

A simple URL Shortener with a Spring Boot backend and a plain HTML/JS frontend.

## Project Structure

```
url-shortener/
├── demo/                        ← Spring Boot Backend (port 8080)
│   ├── pom.xml
│   └── src/main/java/com/example/demo/
│       ├── DemoApplication.java
│       ├── controller/UrlController.java
│       ├── model/UrlRequest.java
│       ├── repository/UrlRepository.java
│       └── service/UrlService.java
│
└── frontend/                    ← Frontend (port 3000)
    ├── index.html
    └── FrontendLauncher.java
```

## How to Run

### Step 1 — Start the Backend

```bash
cd demo
./mvnw spring-boot:run
```

Or if you don't have the Maven wrapper:
```bash
cd demo
mvn spring-boot:run
```

The backend will start on **http://localhost:8080**

---

### Step 2 — Start the Frontend

```bash
cd frontend
javac FrontendLauncher.java
java FrontendLauncher
```

The frontend will be available at **http://localhost:3000**

---

### Step 3 — Use the App

1. Open **http://localhost:3000** in your browser
2. Paste a long URL into the input field
3. Click **Shorten URL**
4. Copy and use the shortened link!

## API Endpoints

| Method | Endpoint          | Description                      |
|--------|-------------------|----------------------------------|
| POST   | /api/shorten      | Shorten a URL (body: JSON)       |
| GET    | /{shortCode}      | Redirect to original URL         |

### Example Request

```bash
curl -X POST http://localhost:8080/api/shorten \
  -H "Content-Type: application/json" \
  -d '{"originalUrl": "https://www.google.com/search?q=url+shortener"}'
```

### Example Response

```json
{ "shortCode": "a1b2c3" }
```

## Notes

- URL mappings are stored **in-memory** and will be lost when the backend restarts.
- The short code is the first 6 characters of the MD5 hash of the original URL.
- CORS is enabled (`@CrossOrigin(origins = "*")`) so the frontend can communicate freely with the backend.
