package com.CardTask.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;


@Entity
public class SubTask {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private boolean status = false; // false = 0, true = 1

    private boolean deleted = false;

    @ManyToOne
    @JoinColumn(name = "task_id")
    private Task task;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Task getTask() {
		return task;
	}

	public void setTask(Task task) {
		this.task = task;
	}

	@Override
	public String toString() {
		return "SubTask [id=" + id + ", title=" + title + ", status=" + status + ", deleted=" + deleted + ", task="
				+ task + "]";
	}

	public SubTask(Long id, String title, boolean status, boolean deleted, Task task) {
		super();
		this.id = id;
		this.title = title;
		this.status = status;
		this.deleted = deleted;
		this.task = task;
	}

	public SubTask() {
		super();
		// TODO Auto-generated constructor stub
	}
    
    
}
