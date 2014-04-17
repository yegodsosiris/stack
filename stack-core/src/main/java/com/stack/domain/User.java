package com.stack.domain;

import java.util.HashSet;
import java.util.Set;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import com.stack.util.JacksonHelper;

@Document
public class User extends BaseMongoEntity  implements Comparable<User>{

private static final long serialVersionUID = -2096532557238867900L;
	
	@Indexed(unique = true)
	private String email;
	private String password;
	private Set<Role> roles = new HashSet<Role>();
	private String firstname;
	private String surname;

	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
    
    @Override
    public String toString() {
    	return JacksonHelper.convertToJSON(this);
    }

	@Override
	public int compareTo(User o) {
		return email.compareTo(o.getEmail());
	}


}
