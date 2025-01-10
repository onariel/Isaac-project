package isaac.isep.isaacproject;

import com.itextpdf.kernel.colors.ColorConstants;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.property.TextAlignment;
import com.itextpdf.layout.property.UnitValue;

import java.io.FileNotFoundException;
import java.util.Date;
import java.util.List;

public class Report {

    public String generateProjectProgressReport(Project project) {
        List<Task> tasks = project.getTasks();
        int totalTasks = tasks.size();
        int completedTasks = 0;
        float totalTaskBudget = 0;

        for (Task task : tasks) {
            if (task.getStatus()) {
                completedTasks++;
            }
            totalTaskBudget += task.getBudget();
        }

        float progressPercentage = (float) completedTasks / totalTasks * 100;

        Date currentDate = new Date();
        long totalTime = project.getEndDate().getTime() - project.getStartDate().getTime();
        long elapsedTime = currentDate.getTime() - project.getStartDate().getTime();
        float timeProgressPercentage = (float) elapsedTime / totalTime * 100;

        String formattedTimeProgressPercentage = String.format("%.2f", timeProgressPercentage);

        StringBuilder employeesList = new StringBuilder();
        for (Employee employee : project.getEmployees()) {
            employeesList.append(employee.getName()).append(", ");
        }
        if (!employeesList.isEmpty()) {
            employeesList.setLength(employeesList.length() - 2); // Remove the trailing comma and space
        }

        StringBuilder budgetAllocation = new StringBuilder();
        for (Task task : tasks) {
            budgetAllocation.append("Task: ").append(task.getName())
                    .append(", Budget: $").append(task.getBudget()).append("\n");
        }

        String report = "Project: " + project.getName() + "\n" +
                "Description: " + project.getDescription() + "\n" +
                "Start Date: " + project.getStartDate() + "\n" +
                "End Date: " + project.getEndDate() + "\n" +
                "Progress: " + progressPercentage + "%\n" +
                "Time Progress: " + formattedTimeProgressPercentage + "%\n" +
                "Project Manager: " + project.getProjectManager().getName() + "\n" +
                "Employees: " + employeesList.toString() + "\n" +
                "Status: " + (project.getStatus() ? "Finished" : "Not Finished") + "\n" +
                "Budget: $" + project.getBudget() + "\n" +
                "Budget Allocation:\n" + budgetAllocation.toString();

        return report;
    }

    public void exportReportToPDF(String report, String filePath) {
        try {
            PdfWriter writer = new PdfWriter(filePath);
            PdfDocument pdfDoc = new PdfDocument(writer);
            Document document = new Document(pdfDoc);

            // Add title
            Paragraph title = new Paragraph("Project Progress Report")
                    .setTextAlignment(TextAlignment.CENTER)
                    .setFontSize(20)
                    .setBold();
            document.add(title);

            // Add a table for the report content
            Table table = new Table(UnitValue.createPercentArray(new float[]{1, 3}))
                    .useAllAvailableWidth();

            // Add table headers
            table.addHeaderCell(new Cell().add(new Paragraph("Field").setBold()).setBackgroundColor(ColorConstants.LIGHT_GRAY));
            table.addHeaderCell(new Cell().add(new Paragraph("Value").setBold()).setBackgroundColor(ColorConstants.LIGHT_GRAY));

            // Split the report into lines and add them to the table
            String[] lines = report.split("\n");
            for (String line : lines) {
                String[] parts = line.split(": ", 2);
                if (parts.length == 2) {
                    table.addCell(new Cell().add(new Paragraph(parts[0])));
                    table.addCell(new Cell().add(new Paragraph(parts[1])));
                } else {
                    table.addCell(new Cell(1, 2).add(new Paragraph(parts[0])));
                }
            }

            document.add(table);
            document.close();
            System.out.println("PDF created successfully.");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void generateTaskDelayReport(Project project) {
        // Logic to generate task delay report
    }

    public void generateBudgetReport(Project project) {
        // Logic to generate budget report
    }

    public void printReport(String report) {
        // Logic to print the report
    }
}