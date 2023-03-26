package me.ultradev.api.dialogue;

import me.ultradev.game.KeyListener;
import me.ultradev.game.data.Data;

import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class Dialogue {

    private String prefix;
    private String pinnedMessage;
    private final List<DialogueLine> lines = new ArrayList<>();

    public Dialogue() {
        this.prefix = null;
    }

    public Dialogue(String prefix) {
        this.prefix = prefix;
    }

    private void prefix(String prefix) {
        this.prefix = prefix;
    }

    public Dialogue pin(String message) {
        this.pinnedMessage = message;
        return this;
    }

    public Dialogue line(String line) {
        lines.add(new DialogueLine(line));
        return this;
    }

    public Dialogue option(String line, DialogueOption.Option... options) {
        lines.add(new DialogueOption(line, options));
        return this;
    }

    public void send() {
        String prefix = "[" + this.prefix + "] ";
        for (DialogueLine line : lines) {
            StringBuilder builder = new StringBuilder();
            if (pinnedMessage != null) builder.append(pinnedMessage).append("\n");
            if (line instanceof DialogueOption option) {
                /*
                String input;
                while (true) {
                    System.out.println(prefix + option.getLine());
                    input = ConsoleManager.getInput("(Enter a reply: " +
                            String.join(", ", option.getOptions().keySet().stream().map(s -> "\"" + s + "\"").toList()) + ")");
                    if (!option.getOptions().containsKey(input)) {
                        ConsoleManager.clear();
                        System.out.println(pinnedMessage);
                        System.out.println("Invalid reply!\n");
                    } else break;
                }
                Dialogue subDialogue = option.getOptions().get(input);
                if (subDialogue.prefix == null) {
                    subDialogue.prefix(this.prefix);
                }
                subDialogue.pin(pinnedMessage).send();
                 */
            } else {
                Data.TEXT_PANE.setText(builder
                        .append(prefix)
                        .append(line.getLine())
                        .append("\n(Press ENTER to continue)")
                        .toString());
                KeyListener.waitForKey(KeyEvent.VK_ENTER);
            }
        }
    }

}
