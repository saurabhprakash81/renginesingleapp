package com.thematic.retail.rengine.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.thematic.retail.rengine.model.NForceFactors;

import com.thematic.retail.rengine.model.CategoryHierarchy;
import com.thematic.retail.rengine.model.ForceFactors;
import com.thematic.retail.rengine.util.CommonUtil;

@Entity
@Table(name = "USERS")
public class User {

	@Id
	@Column(name = "user_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String username;
	private String password;
	private boolean enabled;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "forceFactorVal_id", referencedColumnName = "forcefactorentry_id")
	private ForceFactorsValues forceFactorValues;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cateoryselectionVal_id", referencedColumnName = "cateoryselection_id")
	private CategorySelectionValues cateoryselectionValues;
	
	public User() {
	}

	public User(String username, String password, boolean enabled, Set<Role> roles) {
		super();
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.roles = roles;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "users_roles", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles = new HashSet<>();

	public Long getId() {
		return id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ForceFactorsValues getForceFactorValues() {
		if( forceFactorValues == null) {
			System.out.println("ForceFactors : reading from file.....");
			//ForceFactors forceFactors = CommonUtil.getForceFactorsFromFile();
			ForceFactors forceFactors = CommonUtil.getForceFactors();
			//System.out.println("forceFactors.toString() : " + forceFactors);
			forceFactorValues = new ForceFactorsValues(CommonUtil.getJsonStringFromForceFactors(forceFactors));
		}
		return forceFactorValues;
	}

	public ForceFactorsValues getNForceFactorValues() {
		if( forceFactorValues == null) {
			System.out.println("ForceFactors : reading from file.....");
			NForceFactors[] nforceFactors = CommonUtil.getNForceFactors();
			forceFactorValues = new ForceFactorsValues(CommonUtil.getJsonStringFromNForceFactors(nforceFactors));
		}
		return forceFactorValues;
	}


	public void setForceFactorValues(ForceFactorsValues forceFactorValues) {
		this.forceFactorValues = forceFactorValues;
	}
	
	public CategorySelectionValues getCateoryselectionValues() {
		if( cateoryselectionValues == null) {
			System.out.println("CategorySelection : reading from file.....");
			CategoryHierarchy categoryHierarchy = CommonUtil.getCategoryHierarchyObject();
			cateoryselectionValues = new CategorySelectionValues(CommonUtil.getJsonStringFromCategoryHierarchy(categoryHierarchy));
		}
		return cateoryselectionValues;
	}

	public void setCateoryselectionValues(CategorySelectionValues cateoryselectionValues) {
		this.cateoryselectionValues = cateoryselectionValues;
	}

//	@Override
//	public String toString() {
//		return "User [id=" + id + ", username=" + username + ", password=" + password + ", enabled=" + enabled
//				+ ", forceFactorValues=" + forceFactorValues + ", cateoryselectionValues=" + cateoryselectionValues
//				+ ", roles=" + roles + "]";
//	}
}
