import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.editor.Editor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.ui.Messages;

public class WordLengthAction extends AnAction {
    @Override
    public void actionPerformed(AnActionEvent e) {
        Editor editor = e.getData(CommonDataKeys.EDITOR);
        Project project = e.getProject();
        if (editor == null || project == null) {
            return;
        }

        String selectedText = editor.getSelectionModel().getSelectedText();
        if (selectedText == null || selectedText.isEmpty()) {
            Messages.showErrorDialog("Please select some text first.", "No Selection");
            return;
        }

        System.out.println(selectedText);

        try {
            WordLengthRunner runner = new WordLengthRunner(project);
            String result = runner.runWordLengthScript(selectedText);
            Messages.showInfoMessage(result, "Word Lengths");
        } catch (Exception ex) {
            Messages.showErrorDialog("Error running word length script: " + ex.getMessage(), "Error");
        }
    }
}
