package com.crmapp.pojo;

public class Task {
	private long id;
	private String taskName;
	private String taskDes;
	private String startDay;
	private String endDay;
	private long idProject;
	private long idStatus;
	private long idUser;
	private Project project;
	private StatusTask statusTask;
	private Users users;
	
	
	
	public Users getUsers() {
		return users;
	}
	public void setUsers(Users users) {
		this.users = users;
	}
	public long getIdUser() {
		return idUser;
	}
	public void setIdUser(long idUser) {
		this.idUser = idUser;
	}
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	public StatusTask getStatusTask() {
		return statusTask;
	}
	public void setStatusTask(StatusTask statusTask) {
		this.statusTask = statusTask;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getTaskDes() {
		return taskDes;
	}
	public void setTaskDes(String taskDes) {
		this.taskDes = taskDes;
	}
	public String getStartDay() {
		return startDay;
	}
	public void setStartDay(String startDay) {
		this.startDay = startDay;
	}
	public String getEndDay() {
		return endDay;
	}
	public void setEndDay(String endDay) {
		this.endDay = endDay;
	}
	public long getIdProject() {
		return idProject;
	}
	public void setIdProject(long idProject) {
		this.idProject = idProject;
	}
	public long getIdStatus() {
		return idStatus;
	}
	public void setIdStatus(long idStatus) {
		this.idStatus = idStatus;
	}
	
}
