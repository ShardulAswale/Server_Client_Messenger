# TCP Client–Server Messenger

Java console application for exchanging messages between one client and one server.

## How it works

The server listens on TCP port `2000`; the client connects to `localhost`. They exchange UTF strings through data streams, with client messages followed by server replies.

## Usage

Requires a Java Development Kit. Compile from the repository root:

```sh
javac -d out src/cn4/*.java
```

Start the server first, then the client in another terminal:

```sh
java -cp out cn4.Prac3_CN
java -cp out cn4.Client
```

Enter messages in each console; `bye` ends the client conversation.

## Notes

The exchange is synchronous and supports one connected client. The server requests a reply before checking the client's termination message.
