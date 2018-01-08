
package com.sample.disappearing;

/**
 * Class for a navigation entry.
 *
 * @author Alexander Wagner, FOCONIS AG
 *
 */
public class NavigationEntry {

	private String name;

	public NavigationEntry(final String name) {
		this.setName(name);
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

}
