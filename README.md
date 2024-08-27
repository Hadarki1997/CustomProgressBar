# 📊 CustomProgressBar Library

## 📘 Project Description
This library provides a set of customizable progress bars for Android applications. It includes various types of progress indicators to enhance the user interface and improve user experience.

## 🔧 Prerequisites
- Android Studio
- Minimum SDK version: API 21 (Android 5.0 Lollipop)
- Java Development Kit (JDK)
  
## 📚 External Libraries

This project utilizes the following external libraries:

- AndroidX AppCompat: For backward compatibility and modern Android features
- AndroidX ConstraintLayout: For flexible and responsive UI layouts
- Google Material Design: For modern, standardized UI components including CircularProgressIndicator

These libraries are included as dependencies in the project's `build.gradle` file.

## 🚀 Installation

To use this library in your project, follow these steps:

### Step 1: Add the JitPack repository

Add it in your root build.gradle at the end of repositories:

```gradle
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```
### Step 2: Add the dependency
Add the dependency to your app's build.gradle file:
```gradle
dependencies {
    implementation 'com.github.Hadarki1997:CustomProgressBar:v1.0.0'
}
```
## Usage
The library includes four types of progress bars:

1.VertiProgress

2.CircleStep

3.TrackLine

4.StepFlow

**VertiProgress** 

`VertiProgress` is a vertical progress bar with an icon and text.

**XML Usage:**
```xml
<com.example.customprogressbar_library.VertiProgress
    android:id="@+id/vertiProgress"
    android:layout_width="match_parent"
    android:layout_height="wrap_content" />
```
**Java Usage:**
```java
VertiProgress vertiProgress = findViewById(R.id.vertiProgress);
vertiProgress.setStatus("Completed", 100, "Task Finished");
```
## 🖼️ Examples:
![VertiProgress Example](path_to_your_image/verti_progress_example.png)


**CircleStep** 

`CircleStep` displays steps in a process with a circular indicator.

**XML Usage:**
```xml
<com.example.customprogressbar_library.CircleStep
    android:id="@+id/circleStep"
    android:layout_width="match_parent"
    android:layout_height="wrap_content" />
```
**Java Usage:**
```java
CircleStep circleStep = findViewById(R.id.circleStep);
circleStep.setStepStatus(CircleStep.StepStatus.PROGRESSING, 2, 4);
circleStep.setTitle("Payment");
circleStep.setDescription("Processing your payment");
```
**TrackLine** 

`TrackLine` shows progress on a horizontal line with multiple steps.

**XML Usage:**
```xml
<com.example.customprogressbar_library.TrackLine
    android:id="@+id/trackLine"
    android:layout_width="match_parent"
    android:layout_height="wrap_content" />
```
**Java Usage:**
```java
TrackLine trackLine = findViewById(R.id.trackLine);
List<String> steps = Arrays.asList("Order", "Payment", "Shipping", "Delivery");
trackLine.setSteps(steps);
trackLine.setCurrentStep(2);
```
**StepFlow** 

`StepFlow` displays a multi-step process with navigation between steps.

**XML Usage:**
```xml
<com.example.customprogressbar_library.StepFlow
    android:id="@+id/stepFlow"
    android:layout_width="match_parent"
    android:layout_height="wrap_content" />
```
**Java Usage:**
```java
StepFlow stepFlow = findViewById(R.id.stepFlow);
List<StepFlow.Step> steps = Arrays.asList(
    new StepFlow.Step("Personal Info", "Enter your personal information"),
    new StepFlow.Step("Address", "Provide your shipping address"),
    new StepFlow.Step("Payment", "Enter payment details")
);
stepFlow.setSteps(steps);
stepFlow.setCurrentStep(1);
```

### 🤝 Contributing
Hadar givoni

###  Demo
https://github.com/user-attachments/assets/785c423b-de9d-430a-8b8f-28bb6a18bdd0

