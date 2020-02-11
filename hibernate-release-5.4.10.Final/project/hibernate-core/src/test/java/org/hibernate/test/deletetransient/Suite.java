/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * License: GNU Lesser General Public License (LGPL), version 2.1 or later.
 * See the lgpl.txt file in the root directory or <http://www.gnu.org/licenses/lgpl-2.1.html>.
 */
package org.hibernate.test.deletetransient;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Gail Badner
 */
public class Suite {
	private Long id;
	private String location;
	private Set notes = new HashSet();

	public Suite() {
	}

	public Suite(String location) {
		this.location = location;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Set getNotes() {
		return notes;
	}

	public void setNotes(Set notes) {
		this.notes = notes;
	}
}
