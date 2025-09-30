# Word Length Calculator Plugin

A PyCharm/IntelliJ IDEA plugin that calculates the length of each word in selected text using a Python script.

## Features

- 🔤 Calculate character length for each word in selected text
- ⌨️ Keyboard shortcut support (`Alt+L`)
- 🐍 Python-powered word length calculation
- 💬 Display results in a user-friendly dialog
- 📝 Context menu integration in the editor

## Description

This plugin provides a convenient way to analyze word lengths in your text. Simply select any text in the editor, and the plugin will:
1. Parse the selected text into individual words
2. Calculate the character length of each word
3. Display the results showing each word with its character count

## Installation

### From Source

1. Clone this repository:
   ```bash
   git clone https://github.com/re-pixel/MyPlugIn.git
   cd MyPlugIn
   ```

2. Build the plugin:
   ```bash
   ./gradlew buildPlugin
   ```

3. Install the plugin in PyCharm/IntelliJ IDEA:
   - Go to `Settings/Preferences` → `Plugins` → `⚙️` → `Install Plugin from Disk...`
   - Select the generated ZIP file from `build/distributions/`

### Prerequisites

- **Python**: The plugin requires Python to be installed and available in your system PATH
- **PyCharm/IntelliJ IDEA**: Version 2024.1 or later

## Usage

There are two ways to use this plugin:

### Method 1: Keyboard Shortcut
1. Select some text in your editor
2. Press `Alt+L`
3. View the word lengths in the popup dialog

### Method 2: Context Menu
1. Select some text in your editor
2. Right-click to open the context menu
3. Click on "Calculate Word Length"
4. View the word lengths in the popup dialog

### Example

If you select the text: `Hello World Example`

The plugin will display:
```
Hello: 5 characters
World: 5 characters
Example: 7 characters
```

## Development

### Project Structure

```
MyPlugIn/
├── src/
│   └── main/
│       ├── java/
│       │   ├── WordLengthAction.java      # Action handler for the plugin
│       │   └── WordLengthRunner.java      # Executes Python script
│       └── resources/
│           ├── META-INF/
│           │   ├── plugin.xml             # Plugin configuration
│           │   └── pluginIcon.svg         # Plugin icon
│           └── python/
│               └── word_length_script.py  # Word length calculation logic
├── build.gradle.kts                       # Gradle build configuration
└── README.md                              # This file
```

### Building from Source

1. Ensure you have JDK 21 or later installed

2. Make the Gradle wrapper executable (Linux/macOS):
   ```bash
   chmod +x gradlew
   ```

3. Build the plugin:
   ```bash
   ./gradlew build
   ```

4. Run the plugin in a development IDE instance:
   ```bash
   ./gradlew runIde
   ```

### Technical Details

- **Language**: Java 21
- **Build System**: Gradle with Kotlin DSL
- **Target Platform**: PyCharm (PY) 2024.1+
- **Framework**: IntelliJ Platform SDK
- **Python Integration**: Executes Python scripts via ProcessBuilder

The plugin extracts the Python script from resources to a temporary location and executes it with the selected text as an argument. The script splits the text into words and calculates the length of each word.

## Configuration

The plugin is configured via `plugin.xml`:
- **Plugin ID**: `com.example.MyPlugin`
- **Plugin Name**: Word Length Calculator
- **Keyboard Shortcut**: `Alt+L`
- **Context Menu**: Available in editor popup menu

