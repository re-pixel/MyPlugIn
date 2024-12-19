
import com.intellij.openapi.project.Project;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.stream.Collectors;

public class WordLengthRunner {
    private Project project;

    public WordLengthRunner(Project project) {
        this.project = project;
    }

    public String runWordLengthScript(String selectedText) throws Exception {
        // Create a temporary Python script
        Path tempScript = createTempPythonScript(selectedText);

        // Run the Python script
        Process process = Runtime.getRuntime().exec(new String[]{"python", tempScript.toString()});

        // Capture the output
        String output = new BufferedReader(new InputStreamReader(process.getInputStream()))
                .lines()
                .collect(Collectors.joining("\n"));

        // Wait for the process to complete
        process.waitFor();

        // Delete the temporary script
        Files.delete(tempScript);

        return output;
    }

    private Path createTempPythonScript(String selectedText) throws Exception {
        // Create a temporary Python script
        Path tempScript = Files.createTempFile("word_length_", ".py");

        // Write the script content
        String scriptContent = String.format(
                "# Temporary word length script\n" +
                        "text = '''\n%s\n'''\n" +
                        "words = text.split()\n" +
                        "for word in words:\n" +
                        "    print(f'{word}: {len(word)} characters')\n",
                selectedText
        );

        // Write the content to the temporary script
        Files.write(tempScript, scriptContent.getBytes(), StandardOpenOption.CREATE);

        return tempScript;
    }
}