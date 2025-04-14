import java.util.*;

public class SmartHomeApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Light livingRoomLight = new Light();
        Thermostat homeThermostat = new Thermostat();

        Command lightOn = new TurnOnLightCommand(livingRoomLight);
        Command lightOff = new TurnOffLightCommand(livingRoomLight);
        Command setThermostat = new SetThermostatCommand(homeThermostat, 18);

        List<Command> nightModeCommands = Arrays.asList(lightOff, setThermostat);
        Command nightMode = new MacroCommand(nightModeCommands);

        SmartHomeRemoteControl remote = new SmartHomeRemoteControl();
        remote.setCommand("1", lightOn);
        remote.setCommand("2", lightOff);
        remote.setCommand("3", setThermostat);
        remote.setCommand("4", nightMode);

        String choice;
        do {
            System.out.println("\nSmart Home Remote Control");
            System.out.println("1 - Turn ON Light");
            System.out.println("2 - Turn OFF Light");
            System.out.println("3 - Set Thermostat to 18°C");
            System.out.println("4 - Activate Night Mode");
            System.out.println("u - Undo last command");
            System.out.println("q - Quit");
            System.out.print("Choose option: ");
            choice = scanner.nextLine();

            switch (choice) {
                case "1":
                case "2":
                case "3":
                case "4":
                    remote.pressButton(choice);
                    break;
                case "u":
                    remote.undoButton();
                    break;
                case "q":
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option. Try again.");
            }
        } while (!choice.equals("q"));

        scanner.close();
    }
}