# 📝 QuickNotes API

A clean, layered Spring Boot REST API for managing personal notes, paired with a standalone HTML/CSS/JS frontend.

---

## Project Structure

```
notes-api/
├── frontend/
│   └── index.html                      ← Single-page frontend
├── src/main/java/com/example/notes/
│   ├── NotesApplication.java           ← Entry point
│   ├── model/
│   │   └── Note.java                   ← Data model
│   ├── repository/
│   │   └── NoteRepository.java         ← In-memory storage
│   ├── service/
│   │   └── NoteService.java            ← Business logic
│   └── controller/
│       └── NoteController.java         ← REST endpoints
├── src/main/resources/
│   └── application.properties
└── pom.xml
```

---

## REST API Endpoints

| Method | Path              | Description        |
|--------|-------------------|--------------------|
| POST   | `/api/notes`      | Create a new note  |
| GET    | `/api/notes`      | List all notes     |
| PUT    | `/api/notes/{id}` | Update a note      |
| DELETE | `/api/notes/{id}` | Delete a note      |

### Request / Response format

```json
{
  "id":      1,
  "title":   "Grocery List",
  "content": "Milk, Eggs, Bread"
}
```

---

## Running Locally

### Prerequisites
- Java 17+
- Maven 3.8+

### Backend

```bash
cd notes-api
mvn spring-boot:run
```

The API will start on **http://localhost:8080**.

### Frontend

Open `frontend/index.html` directly in your browser.  
It will call `http://localhost:8080/api/notes` automatically.

---

## Architecture

```
HTTP Request
    │
    ▼
NoteController        ← REST layer   (@RestController)
    │
    ▼
NoteService           ← Logic layer  (@Service)
    │
    ▼
NoteRepository        ← Data layer   (@Repository)
    │
    ▼
In-Memory ArrayList
```

> **Note:** Data is lost on every restart — this is expected behaviour for this project.
