public class FAQBotHandler extends SupportHandler {
    @Override
    public void handle(String issue) {
        System.out.println("[LOG] FAQBotHandler is checking issue: " + issue);
        if (issue.equalsIgnoreCase("password_reset")) {
            System.out.println("[FAQBot] Handled " + issue);
        } else if (nextHandler != null) {
            nextHandler.handle(issue);
        } else {
            System.out.println("[FAQBot] No further handler for " + issue);
        }
    }
}