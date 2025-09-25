package com.pagenavigatordemo.views;

import com.webforj.component.Composite;
import com.webforj.component.html.elements.Anchor;
import com.webforj.component.html.elements.Div;
import com.webforj.component.Component;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexLayout;
import java.util.ArrayList;
import java.util.List;
import com.webforj.router.RouteOutlet;
import com.webforj.router.annotation.Route;

@Route(value = "/content", outlet = MainLayout.class)
public class ContentLayout extends Composite<Div> implements RouteOutlet {
  private final Div self = getBoundComponent();

  private final Div mainArea = new Div();

  private final FlexLayout sideMenu = new FlexLayout();
  private final List<Component> sideMenuChildren = new ArrayList<>();

  static public String createSlug(String text) {
    return text.toLowerCase().replaceAll("[^a-z0-9]+", "-").replaceAll("(^-|-$)", "");
  }

  public ContentLayout() {
    self.addClassName("container");
    mainArea.addClassName("content");
    sideMenu.addClassName("side");

    self.add(mainArea);
    self.add(sideMenu);
  }

  public void add(Component c) {
    mainArea.add(c);
  }

  public void remove(Component c) {
    mainArea.remove(c);
  }

  @Override
  public void showRouteContent(Component component) {
    clearMain();
    if (component != null)
      add(component);
    if (component instanceof SideMenuProvider) {
      SideMenuProvider p = (SideMenuProvider) component;
      FlexLayout hl = setHeaders(p.getSideMenuItems());
      setSideMenu(hl);
    }
  }

  @Override
  public void removeRouteContent(Component component) {
    if (component != null)
      remove(component);
  }

  private void setSideMenu(Component c) {
    for (Component child : sideMenuChildren) {
      sideMenu.remove(child);
    }
    sideMenuChildren.clear();

    if (c != null) {
      sideMenu.add(c);
      sideMenuChildren.add(c);
    }
  }

  private void clearMain() {
    mainArea.removeAll();
  }

  public interface SideMenuProvider {
    List<String> getSideMenuItems();
  }

  private FlexLayout setHeaders(List<String> headers) {
    FlexLayout list = new FlexLayout();
    list.setDirection(FlexDirection.COLUMN);

    for (String h : headers) {
      Anchor a = new Anchor("#" + createSlug(h), h);
      a.addClassName("top-right-item");
      list.add(a);
    }

    return list;
  }

}
