# MadarSoftTask
madar soft task using room clean clean architecture and dependency injection framework using dagger-hilt and coroutines for managing threads and navigation component . and make unit test of search use case and mocking the room

# Architecture
I choose to use MVVM (Model-View-ViewModel) as my project architecture in order to provide a cleaner code, with clear separation between the view, the data and the business logic.
The following diagram shows all the modules and how each module interact with one another after. This architecture using a layered software architecture.
![68747470733a2f2f646576656c6f7065722e616e64726f69642e636f6d2f746f7069632f6c69627261726965732f6172636869746563747572652f696d616765732f66696e616c2d6172636869746563747572652e706e67](https://user-images.githubusercontent.com/55722619/81968739-a8bec700-95d1-11ea-8682-48fe879c25ff.png)
# Built With 🛠
* [Kotlin](https://kotlinlang.org/) - official programming language for Android development .
* [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) - for asynchronous programming .
* [Android Architecture Components](https://developer.android.com/topic/libraries/architecture) - Collection of libraries that help you design robust, testable, and maintainable apps.
  - [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - Data objects that notify views when the underlying database changes.
  - [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Stores UI-related data that isn't destroyed on UI changes. 
  - [Room](https://developer.android.com/topic/libraries/architecture/room) - Access your app's SQLite database with in-app objects and compile-time checks.
  - [Navigation](https://developer.android.com/guide/navigation) - 
* [dagger-hilt](https://dagger.dev/hilt/) - Dependency Injection Framework (Kotlin).
* [Fragment](https://developer.android.com/guide/components/fragments)
* [unit testing]
