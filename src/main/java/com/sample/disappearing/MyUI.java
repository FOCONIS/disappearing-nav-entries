
package com.sample.disappearing;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;


/**
 * This UI is the application entry point. A UI may either represent a browser window (or tab) or some part of a html page where a Vaadin
 * application is embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is intended to be overridden to add component to the user interface
 * and initialize non-component functionality.
 */
@Theme("mytheme")
public class MyUI extends UI {

	@WebServlet(urlPatterns = "/*", name = "MyUIServlet", asyncSupported = true)
	@VaadinServletConfiguration(ui = MyUI.class, productionMode = false)
	public static class MyUIServlet extends VaadinServlet {
		private static final long serialVersionUID = 1L;
	}

	private static final long serialVersionUID = 1L;
	
	private static final String vaadinVersion = com.vaadin.shared.Version.getFullVersion();

	@Override
	protected void init(final VaadinRequest vaadinRequest) {
		final VerticalLayout vertLayout = new VerticalLayout();
		vertLayout.setSizeFull();

		// Adding Vaadin version label
		Label versionLabel = new Label("Test with Vaadin Version: " + vaadinVersion);
		versionLabel.setId("vaadinVersionLabel");
		vertLayout.addComponent(versionLabel);
				
		VerticalLayout container = new VerticalLayout();
		container.setSizeFull();
		vertLayout.addComponent(container);
		vertLayout.setExpandRatio(container, 1);
		
		Navigator nav = new Navigator(getUI(), container);
		NavigationLayout navigationLayout = new NavigationLayout(nav);
		nav.addView("", new ViewImpl("Start View", navigationLayout));
		
		setContent(vertLayout);
		
		getPage().setTitle("Vaadin Disappearing TreeGrid Entries Test");
	}

}
