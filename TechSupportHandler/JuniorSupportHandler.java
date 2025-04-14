public class JuniorSupportHandler extends SupportHandler {
    @Override
    public void handle(String issue) {
        System.out.println("[LOG] JuniorSupportHandler is checking issue: " + issue);
        if (issue.equalsIgnoreCase("refund_request") || issue.equalsIgnoreCase("billing_issue")) {
            System.out.println("[JuniorSupport] Handled " + issue);
        } else if (nextHandler != null) {
            nextHandler.handle(issue);
        } else {
            System.out.println("[JuniorSupport] No further handler for " + issue);
        }
    }
}