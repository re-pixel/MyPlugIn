# Word Length Calculator Plugin

An IntelliJ/PyCharm plugin that calculates and displays the length of each word in selected text. This plugin demonstrates integration between Java and Python within an IntelliJ Platform plugin.

## Features

- **Word Length Calculation**: Select any text in the editor and calculate the character length of each word
- **Python Integration**: Uses a Python script to perform the word length calculations
- **Keyboard Shortcut**: Quick access via `Alt + L` keyboard shortcut
- **Context Menu**: Available in the editor's right-click context menu

## Requirements

- **Python**: The plugin requires Python to be installed and available in your system PATH
- **IntelliJ Platform**: Compatible with IntelliJ-based IDEs (PyCharm, IntelliJ IDEA, etc.)
- **IDE Version**: 2024.1 or later (build 241+)
- **Java**: JDK 21 or later

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

3. The plugin JAR will be created in `build/distributions/`

4. Install the plugin in your IDE:
   - Go to `Settings/Preferences` → `Plugins`
   - Click the gear icon (⚙️) → `Install Plugin from Disk...`
   - Select the generated JAR file
   - Restart the IDE

### Development Setup

1. Clone the repository
2. Open the project in IntelliJ IDEA
3. Wait for Gradle to sync
4. Run the plugin in a sandbox IDE:
   ```bash
   ./gradlew runIde
   ```

## Usage

1. **Select Text**: Highlight any text in your editor
2. **Activate Plugin**: Use one of these methods:
   - Press `Alt + L`
   - Right-click and select `Calculate Word Length` from the context menu
3. **View Results**: A dialog will display each word with its character count

### Example

If you select the text:
```
Hello World from Java
```

The plugin will display:
```
Hello: 5 characters
World: 5 characters
from: 4 characters
Java: 4 characters
```

## Project Structure

```
MyPlugIn/
├── src/
│   └── main/
│       ├── java/
│       │   ├── WordLengthAction.java    # Main action handler
│       │   └── WordLengthRunner.java    # Python script executor
│       └── resources/
│           ├── META-INF/
│           │   ├── plugin.xml           # Plugin configuration
│           │   └── pluginIcon.svg       # Plugin icon
│           └── python/
│               └── word_length_script.py # Python calculation script
├── build.gradle.kts                      # Gradle build configuration
└── README.md                             # This file
```

## Technical Details

### Architecture

- **WordLengthAction**: IntelliJ action that triggers when the user invokes the plugin
- **WordLengthRunner**: Java class that manages the Python script execution
- **word_length_script.py**: Python script that performs the actual word length calculation

### How It Works

1. User selects text in the editor
2. `WordLengthAction` captures the selected text
3. `WordLengthRunner` extracts the Python script from resources to a temporary file
4. The script is executed with the selected text as an argument
5. Results are collected and displayed in a dialog

## Development

### Building

```bash
# Build the plugin
./gradlew build

# Build plugin distribution
./gradlew buildPlugin

# Run in sandbox IDE
./gradlew runIde

# Run tests
./gradlew test
```

### Plugin Configuration

The plugin is configured in `src/main/resources/META-INF/plugin.xml`:
- Plugin ID: `com.example.MyPlugin`
- Name: Word Length Calculator
- Keyboard shortcut: `Alt + L`

## Troubleshooting

### "Python not found" Error

Make sure Python is installed and available in your system PATH:
```bash
python --version
```

### Plugin Not Loading

1. Check IDE compatibility (build 241+)
2. Ensure all dependencies are installed
3. Try rebuilding: `./gradlew clean build`

## Contributing

Contributions are welcome! Please feel free to submit a Pull Request.

## License

This project is open source and available under the MIT License.

## Author

YourName

## Version History

- **2.0**: Current version with Python integration
- **1.0**: Initial release
