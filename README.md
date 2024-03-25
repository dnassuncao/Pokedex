# Pokedex

This Android app allows users to list Pokémon and view their details. It was built using Kotlin and integrates with the [PokeAPI](https://pokeapi.co/) to fetch Pokémon data.

## Architecture

The app follows the MVI (Model-View-Intent) architecture for a reactive and maintainable codebase. It uses the following layers:

- **Jetpack Compose**: For creating the user interface screens.
- **Jetpack Paging**: For listing the Pokémon with support for paging.
- **ViewModel**: For managing UI-related data and handling lifecycle events.
- **Kotlin Flow**: For handling asynchronous data streams.
- **Use Case**: For encapsulating business logic.
- **Repository**: For accessing the PokeAPI data.

## Dependency Injection

- **Koin**: Used for dependency injection to provide instances of repositories, use cases, and other components.

## Future Work

- Write tests for UI and ViewModel to ensure app stability and reliability.
- Implement a feature to favorite Pokémon. This feature will work offline using Room database, allowing users to save their favorite Pokémon and view them even without an internet connection.
- Add search functionality to allow users to search for specific Pokémon by name or other attributes.

## Getting Started

To run the app, you'll need Android Studio installed on your machine. Clone this repository and open it in Android Studio. Then, build and run the app on an Android emulator or device.

## Contributing

Contributions are welcome! If you'd like to contribute to this project, please fork the repository and create a pull request with your changes.

## License

This project is licensed under the [MIT License](LICENSE).
