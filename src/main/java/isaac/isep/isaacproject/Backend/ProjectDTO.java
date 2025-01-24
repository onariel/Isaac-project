package isaac.isep.isaacproject.Backend;

import java.util.Date;
import java.util.List;

public class ProjectDTO {
    public int id;
    public String name;
    public String description;
    public Date startDate;
    public Date endDate;
    public Boolean status;
    public EmployeeDTO projectManager;
    public List<EmployeeDTO> linkedEmployees;
    public List<TaskDTO> tasks;
    public float budget;

    public ProjectDTO(int id, String name, String description, Date startDate, Date endDate, Boolean status, EmployeeDTO projectManager, List<EmployeeDTO> linkedEmployees, List<TaskDTO> tasks, float budget) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.status = status;
        this.projectManager = projectManager;
        this.linkedEmployees = linkedEmployees;
        this.tasks = tasks;
        this.budget = budget;
    }

    public Project projectfromDTO() {
        Project project = new Project();
        project.setId(this.id);
        project.setName(this.name);
        project.setDescription(this.description);
        project.setStartDate(this.startDate);
        project.setEndDate(this.endDate);
        project.setStatus(this.status);
        Employee employee = this.getProjectManager().employeefromDTO();
        project.setProjectManager(employee);
        project.setBudget(this.budget);
        project.getEmployees().add(employee);
        employee.getProjects().add(project);
        employee.getProjects().add(project);
        for(TaskDTO task : tasks) {
            project.getTasks().add(task.TaskfromDTO());
        }

        return project;
    }

    public ProjectDTO() {
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public Date getStartDate() {
        return this.startDate;
    }

    public Date getEndDate() {
        return this.endDate;
    }

    public Boolean getStatus() {
        return this.status;
    }

    public EmployeeDTO getProjectManager() {
        return this.projectManager;
    }

    public List<EmployeeDTO> getLinkedEmployees() {
        return this.linkedEmployees;
    }

    public List<TaskDTO> getTasks() {
        return this.tasks;
    }

    public float getBudget() {
        return this.budget;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public void setProjectManager(EmployeeDTO projectManager) {
        this.projectManager = projectManager;
    }

    public void setLinkedEmployees(List<EmployeeDTO> linkedEmployees) {
        this.linkedEmployees = linkedEmployees;
    }

    public void setTasks(List<TaskDTO> tasks) {
        this.tasks = tasks;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof ProjectDTO)) return false;
        final ProjectDTO other = (ProjectDTO) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description))
            return false;
        final Object this$startDate = this.getStartDate();
        final Object other$startDate = other.getStartDate();
        if (this$startDate == null ? other$startDate != null : !this$startDate.equals(other$startDate)) return false;
        final Object this$endDate = this.getEndDate();
        final Object other$endDate = other.getEndDate();
        if (this$endDate == null ? other$endDate != null : !this$endDate.equals(other$endDate)) return false;
        final Object this$status = this.getStatus();
        final Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) return false;
        final Object this$projectManager = this.getProjectManager();
        final Object other$projectManager = other.getProjectManager();
        if (this$projectManager == null ? other$projectManager != null : !this$projectManager.equals(other$projectManager))
            return false;
        final Object this$linkedEmployees = this.getLinkedEmployees();
        final Object other$linkedEmployees = other.getLinkedEmployees();
        if (this$linkedEmployees == null ? other$linkedEmployees != null : !this$linkedEmployees.equals(other$linkedEmployees))
            return false;
        final Object this$tasks = this.getTasks();
        final Object other$tasks = other.getTasks();
        if (this$tasks == null ? other$tasks != null : !this$tasks.equals(other$tasks)) return false;
        if (Float.compare(this.getBudget(), other.getBudget()) != 0) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof ProjectDTO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getId();
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        final Object $startDate = this.getStartDate();
        result = result * PRIME + ($startDate == null ? 43 : $startDate.hashCode());
        final Object $endDate = this.getEndDate();
        result = result * PRIME + ($endDate == null ? 43 : $endDate.hashCode());
        final Object $status = this.getStatus();
        result = result * PRIME + ($status == null ? 43 : $status.hashCode());
        final Object $projectManager = this.getProjectManager();
        result = result * PRIME + ($projectManager == null ? 43 : $projectManager.hashCode());
        final Object $linkedEmployees = this.getLinkedEmployees();
        result = result * PRIME + ($linkedEmployees == null ? 43 : $linkedEmployees.hashCode());
        final Object $tasks = this.getTasks();
        result = result * PRIME + ($tasks == null ? 43 : $tasks.hashCode());
        result = result * PRIME + Float.floatToIntBits(this.getBudget());
        return result;
    }

    public String toString() {
        return "ProjectDTO(id=" + this.getId() + ", name=" + this.getName() + ", description=" + this.getDescription() + ", startDate=" + this.getStartDate() + ", endDate=" + this.getEndDate() + ", status=" + this.getStatus() + ", projectManager=" + this.getProjectManager() + ", linkedEmployees=" + this.getLinkedEmployees() + ", tasks=" + this.getTasks() + ", budget=" + this.getBudget() + ")";
    }
}
