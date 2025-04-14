public class Thermostat {
    private int previousTemperature = 20;
    private int currentTemperature = 20;

    public void setTemperature(int temperature) {
        previousTemperature = currentTemperature;
        currentTemperature = temperature;
        System.out.println("[Thermostat] Setting temperature to " + temperature + "°C");
    }

    public void revertTemperature() {
        System.out.println("[Thermostat] Reverting to previous temperature: " + previousTemperature + "°C");
        currentTemperature = previousTemperature;
    }
}