import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class SmartHomeRemoteControl {
    private Map<String, Command> commandSlots = new HashMap<>();
    private Stack<Command> commandHistory = new Stack<>();

    public void setCommand(String slot, Command command) {
        commandSlots.put(slot, command);
    }

    public void pressButton(String slot) {
        Command command = commandSlots.get(slot);
        if (command != null) {
            command.execute();
            commandHistory.push(command);
        } else {
            System.out.println("[Remote] No command assigned to slot: " + slot);
        }
    }

    public void undoButton() {
        if (!commandHistory.isEmpty()) {
            Command lastCommand = commandHistory.pop();
            System.out.println("Undo last command");
            lastCommand.undo();
        } else {
            System.out.println("Nothing to undo");
        }
    }
}