import com.intellij.openapi.util.io.FileUtil;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class WordLengthRunner {

    public String runWordLengthScript(String selectedText) throws Exception {
        String scriptPath = getScriptFromResources();
        if (scriptPath == null) {
            throw new IllegalStateException("Could not find Python script in resources");
        }

        ProcessBuilder processBuilder = new ProcessBuilder(
                "python",
                scriptPath,
                selectedText
        );

        processBuilder.redirectErrorStream(true);
        Process process = processBuilder.start();

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(process.getInputStream(), StandardCharsets.UTF_8))) {
            String output = reader.lines().collect(Collectors.joining("\n"));

            int exitCode = process.waitFor();
            if (exitCode != 0) {
                throw new RuntimeException("Python script failed with exit code: " + exitCode);
            }

            return output;
        }
    }

    private String getScriptFromResources() throws IOException {
        // Get the script from resources and copy it to a temporary location
        // This is necessary because we can't execute directly from the JAR
        InputStream scriptStream = getClass().getResourceAsStream("/python/word_length_script.py");
        if (scriptStream == null) {
            return null;
        }

        File tempScript = File.createTempFile("word_length_script", ".py");
        tempScript.deleteOnExit();
        FileUtil.copy(scriptStream, new FileOutputStream(tempScript));

        return tempScript.getAbsolutePath();
    }
}