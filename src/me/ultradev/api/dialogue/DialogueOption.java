package me.ultradev.api.dialogue;

import java.util.HashMap;
import java.util.Map;

public class DialogueOption extends DialogueLine {

    private final Map<String, Dialogue> options = new HashMap<>();

    public DialogueOption(String line, Option... options) {
        super(line);
        for (Option option : options) {
            this.options.put(option.line, option.subDialogue);
        }
    }

    public Map<String, Dialogue> getOptions() {
        return options;
    }

    public record Option(String line, Dialogue subDialogue) {}

}
