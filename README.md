# Kotlin4Android
Android apps made with Kotlin

## Fundamentals.
### 1. Look for the build.gradle(Project: HelloWorld) file.
* This file contains the configuration options that are common to all the modules that make up your project. Every Android Studio project contains a single, top-level Gradle build file. This file defines the Gradle repositories and dependencies that are common to all modules in the project.

### 2. Look for the build.gradle(Module:app) file.
* In addition to the project-level ```build.gradle``` file, each module has a ```build.gradle``` file of its own. The module-level ```build.gradle``` file allows you to configure build settings for each module. (The HelloWorld app has only one module, the module for the app itself.) This ```build.gradle``` file is the one you most often edit when changing app-level build configurations. For example, you edit this ```build.gradle``` file when you change the SDK level that your app supports, or when you declare new dependencies in the dependencies section. You learn more about both these things in a later codelab.

## 1. Dev Byte Viewer.
DevByte Viewer is an example app that has short videos of developers from Udacity and Google giving talks on android development and tools used.
**Demonstrates the following techniques:**
* [Room database](https://developer.android.com/topic/libraries/architecture/room) and a Repository to create an offline cache.
* [WorkManager](https://developer.android.com/topic/libraries/architecture/workmanager) for scheduling periodic work. Here it's used to setup a daily background data sync
* Data Binding with binding adapters.
* ViewModel and LiveData.
#### Screenshots.
<a href="url"><img src="https://github.com/RocqJones/Kotlin4Android/blob/master/img/dev1.png" height="400" width="300" ></a>
<a href="url"><img src="https://github.com/RocqJones/Kotlin4Android/blob/master/img/dev2.png" height="400" width="300" ></a>

## 2. Mars Real Estate
A simple demo app using ViewModel & LiveData with Retrofit, Glide and Moshi in Kotlin.
This app demonstrates the following views and techniques:
* [Retrofit](https://square.github.io/retrofit/) to make api calls to an HTTP web service
* [Moshi](https://github.com/square/moshi) which handles the deserialization of the returned JSON to Kotlin data objects
* [Glide](https://bumptech.github.io/glide/) to load and cache images by URL.
It leverages the following components from the Jetpack library:
* ViewModel
* LiveData
* Data Binding with binding adapters
* Navigation with the SafeArgs plugin for parameter passing between fragments
#### Screenshots.
<a href="url"><img src="https://github.com/RocqJones/Kotlin4Android/blob/master/img/mars1.png" height="400" width="300" ></a>
<a href="url"><img src="https://github.com/RocqJones/Kotlin4Android/blob/master/img/mars2.png" height="400" width="300" ></a>
<a href="url"><img src="https://github.com/RocqJones/Kotlin4Android/blob/master/img/mars3.png" height="400" width="300" ></a>

## 3. Android Kotlin Notification
#### Kotlin Structure
* /receiver—The receiver package contains two broadcast receivers named AlarmReceiver and SnoozeReceiver. AlarmReceiver is triggered by the AlarmManager to send the notification when the user-defined timer is up. SnoozeReceiver handles the user click to snooze the notification.
* /ui—This contains the EggTimerFragment which is part of the UI portion of the app. EggTimerViewModel is responsible for starting and canceling the timer and for other lifecycle-related app tasks.
* /util—In this package there are two files. BindingUtils.kt has binding adapters to enable data binding between the app UI and the ViewModel. NotificationUtils.kt has extension methods on the NotificationManager.

#### Style your notification.
NotificationCompat offers built-in styles for:
* BigTextStyle, which can display a large block of text, such as showing the contents of an email when expanded.
* BigPictureStyle, which shows large-format notifications that include a large image attachment.
* InboxStyle, which shows a conversation style text content.
* MediaStyle, which shows controls for media playback.
* MessagingStyle, which shows large-format notifications that include multiple messages between any number of people.

#### Notification badges.
Notification badges are small dots that appear on the launcher icon of the associated app when the app has an active notification. Users can long-press on the app icon to reveal the notifications.

<a href="url"><img src="https://github.com/RocqJones/Kotlin4Android/blob/master/img/dot1.png" height="200" width="300" ></a>
<a href="url"><img src="https://github.com/RocqJones/Kotlin4Android/blob/master/img/dot2.png" height="200" width="300" ></a>

#### Summary
* Using NotificationManager class to create, send, update, and cancel a notification using.
* A NotificationChannel object with the createNotificationChannel method to set a channel for the notification.
* Using addAction() to add quick actions to a notification.
* Using setShowBadge() to enable or disable badges,.
* Styling notifications using styles which extends from Notification.Style
* Setting importance level with NotificationChannel.setImportance()

## 4. Track Sleep Quality.
The SleepQualityTracker app is a demo app that helps you collect information about your sleep.
* Start time
* End time
* Quality
* Time slept

This app demonstrates the following views and techniques:
* Room database
* DAO
* Coroutines
It also uses and builds on the following techniques from previous lessons:
* Transformation map
* Data Binding in XML files
* ViewModel Factory
* Using Backing Properties to protect MutableLiveData
* Observable state LiveData variables to trigger navigation

#### Screenshots
<a href="url"><img src="https://github.com/RocqJones/Kotlin4Android/blob/master/img/sleep1.png" height="400" width="300" ></a>
<a href="url"><img src="https://github.com/RocqJones/Kotlin4Android/blob/master/img/sleep2.png" height="400" width="300" ></a>
<a href="url"><img src="https://github.com/RocqJones/Kotlin4Android/blob/master/img/sleep3.png" height="400" width="300" ></a>

## 5. GDG Finder
GDGs (Google Developer Groups) are communities of developers that focus on Google technologies - including Android - around the world. They host lots of different events like meetups, conferences, study jams, and more!
* GDG Finder helps you locate GDGs around the world or start one of your own. 
* It applies the principles of Material Design so you can implement professional looking designs and build Android apps that users love to use.
#### Screenshots.
<a href="url"><img src="https://github.com/RocqJones/Kotlin4Android/blob/master/img/gdg1.png" height="400" width="300" ></a>
<a href="url"><img src="https://github.com/RocqJones/Kotlin4Android/blob/master/img/gdg2.png" height="400" width="300" ></a>
<a href="url"><img src="https://github.com/RocqJones/Kotlin4Android/blob/master/img/gdg4.png" height="400" width="300" ></a>

## 6. Guess Word Game.
An app you can play with one or more friends. Your friends can then give you clues to help you guess the word. The app uses the following to make it interactive.
* ViewModels.
* LiveData.
#### Screenshots.
<a href="url"><img src="https://github.com/RocqJones/Kotlin4Android/blob/master/img/guess1.png" height="400" width="300" ></a>
<a href="url"><img src="https://github.com/RocqJones/Kotlin4Android/blob/master/img/guess2.png" height="400" width="300" ></a>
<a href="url"><img src="https://github.com/RocqJones/Kotlin4Android/blob/master/img/guess3.png" height="400" width="300" ></a>
<a href="url"><img src="https://github.com/RocqJones/Kotlin4Android/blob/master/img/guess4.png" height="400" width="300" ></a>
