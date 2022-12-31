## Server-Driven UI
#### THAT Conference 2023
#### Austin, TX

### Requirements
Java 8+
Environment variable: `tmdb_key` set to your api key from https://www.themoviedb.org/settings/api

### Server application
The server application for this project is a Ktor server (https://www.ktor.io) written in Kotlin.
To run this application, open the `server` directory in IntelliJ, open `Application.kt` from the `com.example` package folder, and click the green play arrow.
The api endpoints are defined in the `com.example.routes` package.  `Routing.kt` has the client-driven ui routes.  `ServerUiRouting.kt` has the server-driven ui routes.

### Client application
The client application for this project is an Android mobile app built with Kotlin.
To run this application, open the `android` directory in Android Studio and click the green play arrow.

### Repository Notes
There are two branches to this repository.  Main represents the client-driven UI implementation, and the `server-ui` branch has the Server-Driven UI implementation.
Switching to the `server-ui` branch will maintain all the client-driven ui, plus adds in the server-driven ui implementation.