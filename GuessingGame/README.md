# GUESSING GAME 🎲

A fun, interactive number guessing game built with Java! Test your luck and intuition by guessing a randomly generated number between 1 and 100. With limited attempts, can you unlock the mystery and achieve a high score?

## Getting Started

Welcome to the VS Code Java world. This guide will help you get started writing Java code in Visual Studio Code.

### Prerequisites

- **Java JDK**: Ensure you have the Java Development Kit (JDK) installed. [Download JDK here](https://www.oracle.com/java/technologies/javase-downloads.html).
- **Visual Studio Code**: If you haven’t installed VS Code, you can [download it here](https://code.visualstudio.com/).
- **Java Extension Pack for VS Code**: Install the Java Extension Pack by Microsoft for optimal support when working with Java in VS Code.

### Folder Structure

The workspace contains two folders by default:

- `src`: The folder to maintain source code.

Compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings.

### Installing the Java Extension Pack

1. Open **VS Code**.
2. Go to **Extensions** (or press `Ctrl+Shift+X`).
3. Search for **Java Extension Pack** by Microsoft.
4. Click **Install**.

The Java Extension Pack includes essential tools for working with Java in VS Code, such as project management, debugging, and Maven/Gradle support.

### Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).

## Features

- 🎲 **Random Number Generation**: Each game generates a new mystery number between 1 and 100.
- 🔢 **Limited Attempts**: Players have a maximum of 5 attempts to guess the number correctly.
- 📈 **Score Calculation**: Points are awarded based on the number of remaining attempts when the player guesses correctly.
- 🔄 **Replay Option**: Players can play multiple rounds, with their total score accumulating over each game.
- 🎮 **Interactive Feedback**: After each guess, feedback guides the player on whether the guess is too high or too low.
- 🚫 **Input Validation**: Ensures players enter valid integers to avoid errors.

## Game Rules

1. A mystery number between 1 and 100 is generated at the start of each game.
2. You have 5 attempts to guess the number correctly.
3. After each guess, feedback will indicate if the guess is too high or too low.
4. If you guess correctly, you score points based on the number of remaining attempts.
5. You can play additional rounds, with scores accumulating over each round.
6. To stop playing, type "no" when asked if you want to play again.

## Example Gameplay

```plaintext
Unlock the mystery! Enter a number between 1 and 100:
Attempt 1: 50
Oops, that's a bit high! But you're almost there - try a smaller number and keep going!
Attempt 2: 30
Oops, that's a bit low! But you're almost there - try a larger number and keep going!
Attempt 3: 40
Amazing! You've solved the mystery!
Your score for this round is: 3
Your total score so far is: 3
Do you want to play again? (yes/no): yes
