#  Mars Rover Navigation System (Spring Boot)

A simple REST-based Mars Rover navigation system built using **Spring Boot**.

This project simulates a rover moving on a 10x10 grid using commands:

* `F` → Move Forward
* `L` → Turn Left
* `R` → Turn Right

---

## 📂 Project Structure

```
com.example.demo
│
├── RoverApplication.java
├── controller
│     └── RoverController.java
├── service
│     └── RoverService.java
└── model
      └── Rover.java
```

---

## 🛠 Technologies Used

* Java 21
* Spring Boot
* Maven
* REST API
* HTML + JavaScript (Frontend)

---

## ▶ How to Run the Project

### ✅ Method 1: Run Using IDE (IntelliJ / Eclipse)

1. Clone the repository:

```
git clone https://github.com/kRamu81/SpringBoot-Projects/Rover.git
```

2. Open the project in IntelliJ or Eclipse

3. Run:

```
RoverApplication.java
```

4. Open browser:

```
http://localhost:8080/index.html
```

---

### ✅ Method 2: Run Using Command Line

1. Clone project:

```
git clone https://github.com/kRamu81/SpringBoot-Projects/Rover.git
```

2. Navigate into project folder:

```
cd Rover
```

3. Build project:

```
mvn clean install
```

4. Run project:

```
mvn spring-boot:run
```

5. Open browser:

```
http://localhost:8080
```

---

## 📡 API Endpoints

### 🔹 Get Rover Status

```
GET /api/status
```

### 🔹 Move Rover

```
POST /api/move?commands=FFRFF
```

### 🔹 Reset Rover

```
POST /api/reset
```

---

## 📌 Example Command

```
FFRFFL
```

Initial Position:

```
(0,0) facing North
```

After command:

```
Rover moves within 10x10 grid
```

---

## 👨‍💻 Author

Developed by Ramu 🚀
B.Tech Student | Spring Boot Learner
