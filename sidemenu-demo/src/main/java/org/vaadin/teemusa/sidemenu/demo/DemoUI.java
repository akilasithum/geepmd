package org.vaadin.teemusa.sidemenu.demo;

import javax.servlet.annotation.WebServlet;

import com.geepmd.ui.Dashboard;
import com.geepmd.ui.LoginPage;
import com.geepmd.ui.MotherRegistration;
import com.geepmd.ui.Survey;
import com.vaadin.server.*;
import org.vaadin.dialogs.ConfirmDialog;
import org.vaadin.teemusa.sidemenu.SideMenu;
import org.vaadin.teemusa.sidemenu.SideMenu.MenuRegistration;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.Title;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.annotations.Viewport;
import com.vaadin.icons.VaadinIcons;
import com.vaadin.navigator.Navigator;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Button;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("demo")
@Title("GEEPMD - RAPCO")
@Viewport("user-scalable=no,initial-scale=1.0")
public class DemoUI extends UI {

	private String previousPage;

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = DemoUI.class)
	public static class Servlet extends VaadinServlet {
	}

	private SideMenu sideMenu = new SideMenu();
	private boolean logoVisible = true;
	private ThemeResource logo = new ThemeResource("images/logo.png");
	private String menuCaption = "BASELINE SURVEY";
	Navigator navigator;

	@Override
	protected void init(VaadinRequest request) {
		setContent(sideMenu);
		navigator = new Navigator(this, sideMenu);
		setNavigator(navigator);

		// NOTE: Navigation and custom code menus should not be mixed.
		// See issue #8

		navigator.addView("Home", Dashboard.class);
		navigator.addView("MotherRegistration", MotherRegistration.class);
		navigator.addView("Survey", Survey.class);
		navigator.addView("Login", LoginPage.class);

		navigator.navigateTo("Login");
		sideMenu.showHideMenu(false);
		sideMenu.setMenuCaption(menuCaption, logo);

		// Navigation examples
		sideMenu.addNavigation("Home", "Home");

		sideMenu.addMenuItem("Mother Registration", VaadinIcons.ACCORDION_MENU, () -> {
			navigator.navigateTo("MotherRegistration");
		});

		// Arbitrary method execution
		sideMenu.addMenuItem("Add New Survey", VaadinIcons.FILE_TREE_SUB, () -> {
			navigator.navigateTo("Survey");
		});
		sideMenu.addMenuItem("Edit Profile", VaadinIcons.USER_CARD, () -> {
			VerticalLayout content = new VerticalLayout();
			content.addComponent(new Label("Another layout"));
			sideMenu.setContent(content);
		});

		sideMenu.addMenuItem("Sign Out", VaadinIcons.SIGN_OUT, () -> {
			logoutUser();
		});
	}


	public void navigateToDashboard(){
		previousPage = "Login";
		sideMenu.showHideMenu(true);
		navigator.navigateTo("Home");
	}

	public void hideMenu(){
		sideMenu.showHideMenu(false);
	}

	private void logoutUser(){
		ConfirmDialog.show(getUI(), "Logout", "Are you sure you want to log out from the system?",
				"Yes", "No", new ConfirmDialog.Listener() {
					public void onClose(ConfirmDialog dialog) {
						if (dialog.isConfirmed()) {
							getSession().setAttribute("userName","");
							getUI().getNavigator().navigateTo("Login");
							hideMenu();
						}
					}
				});
	}

}
