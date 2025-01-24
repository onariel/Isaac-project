package isaac.isep.isaacproject.Backend;


import isaac.isep.isaacproject.Apiconector.PostgresqlManager;

import java.util.Date;

public class TaskDTO {
    public int id;

    public String name;

    public String description;

    public int priority;

    public Date dueDate;

    public Long status;

    public float budget;

    public long employeeId;

    public TaskDTO(int id, String name, String description, int priority, Date dueDate, Long status, float budget) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.priority = priority;
        this.dueDate = dueDate;
        this.status = status;
        this.budget = budget;
    }

    public TaskDTO() {
    }

    public Task TaskfromDTO() {
        Task task = new Task();
        PostgresqlManager postgresqlManager = new PostgresqlManager();
        task.setId(this.id);
        task.setName(this.name);
        task.setDescription(this.description);
        task.setPriority(this.priority);
        task.setDueDate(this.dueDate);
        task.setStatus(this.status);
        task.setBudget(this.budget);
        task.setEmployee(postgresqlManager.getEmployee(this.employeeId));
        return task;
    }

    public int getId() {
        return this.id;
    }

    public void setEmployeeId(long employeeId) {
        this.employeeId = employeeId;
    }

    public long getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public int getPriority() {
        return this.priority;
    }

    public Date getDueDate() {
        return this.dueDate;
    }

    public Long getStatus() {
        return this.status;
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

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public void setBudget(float budget) {
        this.budget = budget;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof TaskDTO)) return false;
        final TaskDTO other = (TaskDTO) o;
        if (!other.canEqual((Object) this)) return false;
        if (this.getId() != other.getId()) return false;
        final Object this$name = this.getName();
        final Object other$name = other.getName();
        if (this$name == null ? other$name != null : !this$name.equals(other$name)) return false;
        final Object this$description = this.getDescription();
        final Object other$description = other.getDescription();
        if (this$description == null ? other$description != null : !this$description.equals(other$description))
            return false;
        if (this.getPriority() != other.getPriority()) return false;
        final Object this$dueDate = this.getDueDate();
        final Object other$dueDate = other.getDueDate();
        if (this$dueDate == null ? other$dueDate != null : !this$dueDate.equals(other$dueDate)) return false;
        final Object this$status = this.getStatus();
        final Object other$status = other.getStatus();
        if (this$status == null ? other$status != null : !this$status.equals(other$status)) return false;
        if (Float.compare(this.getBudget(), other.getBudget()) != 0) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof TaskDTO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        result = result * PRIME + this.getId();
        final Object $name = this.getName();
        result = result * PRIME + ($name == null ? 43 : $name.hashCode());
        final Object $description = this.getDescription();
        result = result * PRIME + ($description == null ? 43 : $description.hashCode());
        result = result * PRIME + this.getPriority();
        final Object $dueDate = this.getDueDate();
        result = result * PRIME + ($dueDate == null ? 43 : $dueDate.hashCode());
        final Object $status = this.getStatus();
        result = result * PRIME + ($status == null ? 43 : $status.hashCode());
        result = result * PRIME + Float.floatToIntBits(this.getBudget());
        return result;
    }

    public String toString() {
        return "TaskDTO(id=" + this.getId() + ", name=" + this.getName() + ", description=" + this.getDescription() + ", priority=" + this.getPriority() + ", dueDate=" + this.getDueDate() + ", status=" + this.getStatus() + ", budget=" + this.getBudget() + ")";
    }
}
