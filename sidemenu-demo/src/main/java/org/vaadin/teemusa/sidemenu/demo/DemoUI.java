package org.vaadin.teemusa.sidemenu.demo;

import javax.servlet.annotation.WebServlet;

import com.geepmd.ui.Dashboard;
import com.geepmd.ui.MotherRegistration;
import com.geepmd.ui.Survey;
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
import com.vaadin.server.Resource;
import com.vaadin.server.ThemeResource;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
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

	private final class FooView extends VerticalLayout implements View {

		public FooView(String text) {
			addComponent(new Label(text));
		}

		@Override
		public void enter(ViewChangeEvent event) {
		}
	}

	@WebServlet(value = "/*", asyncSupported = true)
	@VaadinServletConfiguration(productionMode = false, ui = DemoUI.class)
	public static class Servlet extends VaadinServlet {
	}

	private SideMenu sideMenu = new SideMenu();
	private boolean logoVisible = true;
	private ThemeResource logo = new ThemeResource("images/logo.png");
	private String menuCaption = "BASELINE SURVEY";

	@Override
	protected void init(VaadinRequest request) {
		setContent(sideMenu);
		Navigator navigator = new Navigator(this, sideMenu);
		setNavigator(navigator);

		// NOTE: Navigation and custom code menus should not be mixed.
		// See issue #8

		navigator.addView("", Dashboard.class);
		navigator.addView("MotherRegistration", MotherRegistration.class);
		navigator.addView("Survey", Survey.class);

		// Since we're mixing both navigator and non-navigator menus the
		// navigator state needs to be manually triggered.
		navigator.navigateTo("");

		sideMenu.setMenuCaption(menuCaption, logo);

		// Navigation examples
		sideMenu.addNavigation("Home", "");

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
			VerticalLayout content = new VerticalLayout();
			content.addComponent(new Label("Another layout"));
			sideMenu.setContent(content);
		});
				// Navigator has done its own setup, any menu can be selected.


		// User menu controls

        //initTreeMenu();

		//setUser("Guest", VaadinIcons.MALE);
	}

    /*private void initTreeMenu() {
        sideMenu.addTreeItem("Tree item", () -> Notification.show("Parent!"));
        sideMenu.addTreeItem("Tree item", "sub item", () -> {
            Notification.show("Sub item!");
            sideMenu.addComponent(
                new Button(
                    "Add sub sub item",
                    event -> subSubTreeItem = sideMenu.addTreeItem("sub item", "sub sub item", () -> Notification.show("Inception!"))));
            sideMenu.addComponent(new Button("Remove sub sub item", event -> {
                if (null != subSubTreeItem) {
                    subSubTreeItem.remove();
                    subSubTreeItem = null;
                }
            }));
        });
    }*/

    /*private void setUser(String name, Resource icon) {
		sideMenu.setUserName(name);
		sideMenu.setUserIcon(icon);

		sideMenu.clearUserMenu();
        sideMenu.addUserMenuItem("Settings", VaadinIcons.WRENCH, () -> Notification.show("Showing settings", Type.TRAY_NOTIFICATION));
        sideMenu.addUserMenuItem("Sign out", () -> Notification.show("Logging out..", Type.TRAY_NOTIFICATION));

		sideMenu.addUserMenuItem("Hide logo", () -> {
			if (!logoVisible) {
				sideMenu.setMenuCaption(menuCaption, logo);
			} else {
				sideMenu.setMenuCaption(menuCaption);
			}
			logoVisible = !logoVisible;
		});
	}*/
}
