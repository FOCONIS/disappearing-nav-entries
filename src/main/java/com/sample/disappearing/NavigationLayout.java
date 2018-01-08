/*
 * Licensed Materials - Property of FOCONIS AG
 * (C) Copyright FOCONIS AG.
 */

package com.sample.disappearing;

import java.util.Arrays;

import com.vaadin.data.TreeData;
import com.vaadin.data.provider.TreeDataProvider;
import com.vaadin.navigator.Navigator;
import com.vaadin.ui.Label;
import com.vaadin.ui.TreeGrid;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Grid.Column;

/**
 * The navigation layout.
 *
 * @author Alexander Wagner, FOCONIS AG
 *
 */
public class NavigationLayout extends VerticalLayout {

	private static final long serialVersionUID = 1L;

	private TreeGrid<NavigationEntry> navigationTree = new TreeGrid<>();

	private Navigator nav;
	
	/**
	 * Constructor.
	 */
	public NavigationLayout(Navigator nav) {
		this.nav = nav;
		setSpacing(false);
		setMargin(false);
		
		setWidth("250px");
		setHeight("100%");
		
		addComponent(new Label("Navigation"));
		addComponent(navigationTree);
		setExpandRatio(navigationTree, 1);
		
		buildNavigationTree();
	}
	
	private void buildNavigationTree() {
		TreeData<NavigationEntry> data = new TreeData<>();

		NavigationEntry c1 = addNavEntry(data, null, "Caption 1");
		addNavEntry(data, c1, "Item 1");
		addNavEntry(data, c1, "Item 2");
		addNavEntry(data, c1, "Item 3");

		NavigationEntry c2 = addNavEntry(data, null, "Caption 2");
		addNavEntry(data, c2, "Item 4");
		addNavEntry(data, c2, "Item 5");
		addNavEntry(data, c2, "Item 6");

		NavigationEntry c3 = addNavEntry(data, null, "Caption 3");
		addNavEntry(data, c3, "Item 7");
		addNavEntry(data, c3, "Item 8");

		NavigationEntry c4 = addNavEntry(data, null, "Caption 4");
		addNavEntry(data, c4, "Item 9");
		addNavEntry(data, c4, "Item 10");
		addNavEntry(data, c4, "Item 11");
		addNavEntry(data, c4, "Item 12");

		NavigationEntry c5 = addNavEntry(data, null, "Caption 5");
		addNavEntry(data, c5, "Item 13");
		addNavEntry(data, c5, "Item 14");
		
		TreeDataProvider<NavigationEntry> dataProvider = new TreeDataProvider<>(data);
		navigationTree.setDataProvider(dataProvider);

		navigationTree.setWidth("250px");
		// Setting the height to 100% causes problem with flickering grid and disappearing items
		navigationTree.setHeight("100%");
		// Workaround: Use a fixed height for the grid and the flickering goes away
		//navigationTree.setHeight("700px");
		
		Column<NavigationEntry, String> colTitle = navigationTree.addColumn(item -> item.getName());
		colTitle.setId("colTitle");

		navigationTree.setHierarchyColumn("colTitle");
		
		navigationTree.expand(Arrays.asList(c1, c2, c3, c4, c5));
		
		navigationTree.addItemClickListener(evt -> {
			NavigationEntry item = evt.getItem();
			UI.getCurrent().getNavigator().navigateTo(item.getName());
		});
	}
	
	private NavigationEntry addNavEntry(TreeData<NavigationEntry> data, NavigationEntry parent, String name) {
		NavigationEntry ret = new NavigationEntry(name);
		data.addItem(parent, ret);
		nav.addView(name, new ViewImpl(name, this));
		return ret;
	}
	
}
