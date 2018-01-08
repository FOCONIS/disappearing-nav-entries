/*
 * Licensed Materials - Property of FOCONIS AG
 * (C) Copyright FOCONIS AG.
 */

package com.sample.disappearing;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.shared.ui.ContentMode;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.Grid;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;

/**
 * Implementation of a view as {@link HorizontalLayout}. On the left side there is the navigation and on the right side a grid.
 *
 * @author Alexander Wagner, FOCONIS AG
 *
 */
public class ViewImpl extends HorizontalLayout implements View {

	private static final long serialVersionUID = 1L;

	private NavigationLayout navigationLayout;
	
	public ViewImpl(String content, NavigationLayout navigationLayout) {
		this.navigationLayout = navigationLayout;
		
		setSizeFull();
		
		CssLayout mainLayout = new CssLayout();
		mainLayout.setSizeFull();
		addComponent(mainLayout);
		setExpandRatio(mainLayout, 1);
		
		mainLayout.addComponent(new Label(content + "\n"
				+ "This is just some text on the main page. After using the navigation 'Item 4' it disappears.",	
				ContentMode.PREFORMATTED));
		
		Grid<String> grid = new Grid<>();
		grid.setSizeFull();
		List<String> list = new ArrayList<>();
		
		for (int i = 0; i < 100; i++) {
			list.add(content + "-" + i);
		}
		
		grid.addColumn(str -> "1-" + str);
		grid.addColumn(str -> "2-" + str);
		grid.addColumn(str -> "3-" + str);
		grid.addColumn(str -> "4-" + str);
		grid.setItems(list);
		// mainLayout.addComponent(grid);
	}
	
	public void enter(ViewChangeEvent event) {
		addComponentAsFirst(navigationLayout);
	}
	
}
