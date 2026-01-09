# Phone-Book-Client-Server-Application

A simple Java program to store and search phone numbers using a client and server.

---

## Features

- Add a contact (name and number)  
- Search for a number by name  
- Works over the network using TCP sockets  
- Simple menu for user input

---

## How to Run

### Start the Server
```bash
javac PhoneNumberServer.java
java PhoneNumberServer
````

The server listens on port 9999.

### Run the Client

```bash
javac PhoneNumberClient.java
java PhoneNumberClient <server-ip>
```

Use `localhost` if running on the same computer.

---

## How to Use

The client shows a menu:

```
Menu: 1-add, 2-search, 0-quit
```

* Press **1** to add a contact
* Press **2** to search for a contact
* Press **0** to quit

Example:

```
1
Enter name: ✪ ☉ △ ⊗ △ ✧ ✧ △
Enter number: 1234567890
Server: ok

2
Enter name: ⊗ △ ⊗ △ ✦
Server: 1234567890

0
```

---

## How It Works

* Server keeps contacts in memory using a HashMap.
* Client sends commands to the server (`add`, `search`, `quit`).
* Server responds with the result or `"error"` for wrong commands.
* Data is **lost when the server stops**.

---

## Notes

* Name searches are **case-sensitive**
* Names cannot have spaces
* Server handles **one client at a time**

---

## Possible Improvements

* Support multiple clients
* Save data to a file or database
* Add a GUI client

---

## Project Structure

```
PhoneBookProject/
├── PhoneNumberServer.java
├── PhoneNumberClient.java
└── README.md
```

---



