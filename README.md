# 🎓 Smart University Lab Resource Management System

> **Design Patterns Lab — Assignment Project 1**  
> Student: Abd Al-Rhman Saleem Al Nawati | ID: 120230777

---

## 📌 Project Overview

A **Smart Lab Resource Management System** built in Java that simulates how university labs (AI, Robotics, Cybersecurity) create sessions, handle student resource requests, and enforce system-wide rules.

This project was developed as part of the **Design Patterns Lab** course to demonstrate the correct and meaningful application of three core design patterns.

---

## 🏗️ Design Patterns Used

### 1. 🏭 Factory Method Pattern
Used to create lab sessions without coupling the client to specific session types.

- `LabSessionFactory` → abstract factory base
- `AILabSessionFactory`, `RoboticsLabSessionFactory`, `CybersecurityLabSessionFactory` → concrete factories
- Each factory creates its own session type without `if/switch` logic
- Adding a new lab type = adding one new factory + one new session class, **no existing code is modified**

### 2. 🔨 Builder Pattern
Used to construct `ResourceRequest` objects that have many optional fields.

- Required fields (`studentId`, `resourceType`) go in the `Builder` constructor
- Optional fields (`duration`, `priority`, `notes`, `softwareRequired`, `supervisorApproval`) are set via chained methods
- Produces **immutable** request objects — all fields are `final`

```java
ResourceRequest req = new ResourceRequest.Builder("S123", "GPU")
        .duration(90)
        .priority(3)
        .notes("Training a transformer model")
        .build();
```

### 3. 🔒 Singleton Pattern
Used to ensure one shared configuration instance across the entire system.

- `LabSystemConfig.getInstance()` — single access point
- Private constructor prevents multiple instantiations
- All components read from the same config (capacity, allowed resources, limits)

---

## 📁 Project Structure

```
src/
├── Main.java                            # Entry point — demo flow
├── core/
│   ├── LabSession.java                  # Abstract base for all lab sessions
│   ├── LabSystemConfig.java             # Singleton system configuration
│   └── ResourceRequest.java            # Immutable request object (Builder)
├── factories/
│   ├── LabSessionFactory.java           # Abstract Factory Method base
│   ├── AILabSessionFactory.java         # Creates AI lab sessions
│   ├── RoboticsLabSessionFactory.java   # Creates Robotics lab sessions
│   └── CybersecurityLabSessionFactory.java  # Creates Cybersecurity sessions
└── sessions/
    ├── AILabSession.java                # AI lab behavior
    ├── RoboticsLabSession.java          # Robotics lab behavior
    └── CybersecurityLabSession.java     # Cybersecurity lab behavior
```

---

## ⚙️ System Configuration (Singleton)

| Setting | Value |
|---|---|
| Lab Capacity | 30 students |
| Max Requests per Student | 3 |
| Max Session Duration | 120 minutes |
| Allowed Resources | GPU, CPU, Robot Arm, Dataset |

---

## 🖥️ Example Run Output

```
=== Lab Management System Startup ===

System Config Loaded:
- Max Requests per Student: 3
- Allowed Resources: [GPU, CPU, Robot Arm, Dataset]
------------------------------------

--- Opening Lab Sessions ---
  [AI Lab] Loading CUDA drivers...
  [AI Lab] Initialising Jupyter environment...
  [AI Lab] GPU cluster is ready.
********

  [Robotics Lab] Calibrating robot arms...
  [Robotics Lab] Warming up 3D printers...
  [Robotics Lab] Safety sensors are active.
********

  [Cybersecurity Lab] Creating isolated virtual network...
  [Cybersecurity Lab] Installing Wireshark and Nmap...
  [Cybersecurity Lab] Firewall rules are active.
----------------------------

--- Submitting Requests ---
  [AI Lab] Allocating GPU for training task. Priority level: 3.
  [AI Lab] Scheduling GPU job on the cluster...
  [Robotics Lab] Reserving Robot Arm for student S456.
  Resource not allowed: Coffee Machine
  Duration exceeds maximum. Rejected.
----------------------------

--- Final Reports ---
=*= Session Summary =*=
Session ID: AI-2026-001
Lab: AI Lab
Status: OPEN
Total Requests: 1
  - Student: S123 | Resource: GPU | Duration: 90 min
=======================
=*= Session Summary =*=
Session ID: ROB-2026-042
Lab: Robotics Lab
Status: OPEN
Total Requests: 1
  - Student: S456 | Resource: Robot Arm | Duration: 60 min
=======================
=*= Session Summary =*=
Session ID: SEC-2026-007
Lab: Cybersecurity Lab
Status: OPEN
Total Requests: 0
=======================

Lab Descriptions:
- AI Lab — Supports deep learning, NLP, and computer vision workloads. Equipped with high-performance GPUs and large datasets.
- Cybersecurity Lab — Supports penetration testing and network security. Equipped with isolated networks and security analysis tools.
```

---

## 🚀 How to Run

1. Open the project in **IntelliJ IDEA**
2. Make sure the source root is set to `src/`
3. Run `Main.java`

Or compile manually:
```bash
javac -d out src/core/*.java src/factories/*.java src/sessions/*.java src/Main.java
java -cp out Main
```

---

## 📐 UML Diagram

The UML class diagram is included in the submission ZIP (`تصميم و عماره .drawio.png`).

---

## 📋 Validation Rules

Every submitted request is checked against 3 rules from the Singleton config:

1. **Resource must be allowed** — rejects unknown resource types (e.g., "Coffee Machine")
2. **Student request limit** — each student can submit at most 3 requests per session
3. **Duration limit** — requests exceeding 120 minutes are rejected

---

## 🛠️ Technologies

- **Language:** Java
- **IDE:** IntelliJ IDEA
- **Patterns:** Factory Method, Builder, Singleton
