package com.tts.exam.ExamApi.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.*;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "question")
@EntityListeners(AuditingEntityListener.class)
public class Question implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.TABLE)
	private int id;
	
	private String qname;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "qid")
	private List<Answer> answers;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQname() {
		return qname;
	}

	public void setQname(String qname) {
		this.qname = qname;
	}

	public List<Answer> getAnswers() {
		return answers;
	}

	public void setAnswers(List<Answer> answers) {
		this.answers = answers;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
