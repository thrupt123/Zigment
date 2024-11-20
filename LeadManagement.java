import java.util.*;

public class LeadManagement {

    static class Lead {
        String companySize;
        String budget;
        String industry;
        String urgency;
        int score;
    }

    public static void main(String[] args) {
        List<Lead> leads = new ArrayList<>();

        // Simulate form submissions
        leads.add(createLead("1-50 employees", "< $10,000", "Technology", "Immediate"));
        leads.add(createLead("201-1000 employees", "$50,001-$100,000", "Healthcare", "Short-term"));

        for (Lead lead : leads) {
            lead.score = calculateScore(lead);
            System.out.println("Lead Score: " + lead.score);

            if (lead.score > 70) {
                System.out.println("Sending welcome email...");
            } else {
                System.out.println("Adding lead to nurturing campaigns...");
            }
        }
    }

    static Lead createLead(String size, String budget, String industry, String urgency) {
        Lead lead = new Lead();
        lead.companySize = size;
        lead.budget = budget;
        lead.industry = industry;
        lead.urgency = urgency;
        return lead;
    }

    static int calculateScore(Lead lead) {
        int score = 0;

        // Company Size
        if (lead.companySize.equals("1-50 employees")) score += 10;
        else if (lead.companySize.equals("51-200 employees")) score += 20;
        else if (lead.companySize.equals("201-1000 employees")) score += 30;
        else score += 40;

        // Budget
        if (lead.budget.equals("< $10,000")) score += 10;
        else if (lead.budget.equals("$10,000-$50,000")) score += 20;
        else if (lead.budget.equals("$50,001-$100,000")) score += 30;
        else score += 40;

        // Industry
        if (lead.industry.equals("Technology")) score += 40;
        else if (lead.industry.equals("Finance")) score += 30;
        else if (lead.industry.equals("Healthcare")) score += 20;
        else score += 10;

        // Urgency
        if (lead.urgency.equals("Immediate")) score += 40;
        else if (lead.urgency.equals("Short-term")) score += 30;
        else if (lead.urgency.equals("Medium-term")) score += 20;
        else score += 10;

        return score;
    }
}