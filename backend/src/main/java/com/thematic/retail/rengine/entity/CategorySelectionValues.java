package com.thematic.retail.rengine.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CATEGORY_SELECTION_VALUE")
public class CategorySelectionValues {

	@Id
	@Column(name = "cateoryselection_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Lob
	@Column(name = "value")
	private String value;
	
	@OneToOne(mappedBy = "cateoryselectionValues")
    private User user;
	
	public CategorySelectionValues(String value) {
		super();
		this.value = value;
	}

	public CategorySelectionValues() {
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	@Override
	public String toString() {
		return "CategorySelectionValues [id=" + id + ", value=" + value + ", user=" + user + "]";
	}

}
