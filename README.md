# 💬 Real-time Multi-user Chat Application (Java)

A real-time multi-user chat application built using **Java Sockets** and **Multithreading**, featuring a simple GUI, private messaging, and basic file sharing.
This project demonstrates core **Object-Oriented Programming (OOP)** concepts along with **client-server communication**.

---

## 🚀 Features

* 🔗 Multi-user chat (multiple clients at once)
* ⚡ Real-time message broadcasting
* 💬 Private messaging using `@username`
* 📂 File sharing (text files)
* 🧵 Multithreading (one thread per client)
* 🖥️ GUI using Java Swing
* 🔌 Reliable communication using TCP sockets
* ⌨️ Send messages using **Enter key or Button**

---

## 🛠️ Technologies Used

* Java
* Socket Programming (TCP)
* Multithreading
* Java Swing (GUI)
* Collections Framework

---

## 📁 Project Structure

```
Real-time Chat Application/
│
├── ChatServer.java
├── ClientHandler.java
├── ChatClient.java
```

---

## ⚙️ How to Run

### 1️⃣ Compile the files

```
javac ChatServer.java ClientHandler.java ChatClient.java
```

### 2️⃣ Run the Server

```
java ChatServer
```

### 3️⃣ Run Clients (open multiple terminals)

```
java ChatClient
```

👉 Enter different usernames (e.g., Disha, Piyush, Adi)

---

## 💡 Usage Guide

### 🔹 Normal Message

```
Hello everyone
```

### 🔹 Private Message

```
@Piyush Hello this is private
```

👉 Only Piyush will receive this message

### 🔹 File Sharing

* Click **File button**
* Select a `.txt` file
* File content will be shared with all users

---

## 🖥️ Sample Output

### Server Console

```
=== Server Started ===
New client connected
Disha joined
Adi joined
Piyush joined
```

### Chat Example

```
Disha: Hello everyone
Adi: Hi!
Piyush: Hey guys!
```

---

## 🧠 OOP Concepts Demonstrated

* **Classes & Objects** → ChatServer, ClientHandler, ChatClient
* **Inheritance** → ChatClient extends JFrame
* **Encapsulation** → Private variables and methods
* **Polymorphism** → Method overriding (run method)
* **Interfaces** → Runnable
* **Exception Handling** → Try-catch for network errors

---

## 🎯 Applications

* 🏫 College communication systems
* 🏢 Office internal messaging
* 🎮 Online gaming chat systems
* 📚 Educational platforms
* 🤝 Team collaboration tools

---

## 🔮 Future Enhancements

* 🔐 User authentication (login system)
* 🌐 Internet-based communication (not just localhost)
* 📱 Android/mobile app integration
* 🎨 Advanced UI (chat bubbles like WhatsApp)
* 📎 File sharing for images & PDFs

---

## 👩‍💻 Author

**Disha Borse**

---
