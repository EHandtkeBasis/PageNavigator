package com.pagenavigatordemo.views;

import com.webforj.component.Composite;
import com.webforj.component.html.elements.Div;
import com.webforj.component.Component;
import com.webforj.component.layout.flexlayout.FlexLayout;
import java.util.ArrayList;
import java.util.List;
import com.webforj.router.RouteOutlet;
import com.webforj.router.annotation.Route;

@Route(value = "/content", outlet = MainLayout.class)
public class ContentLayout extends Composite<Div> implements RouteOutlet {
  private final Div self = getBoundComponent();

  private final Div mainArea = new Div();

  private final FlexLayout topRight = new FlexLayout();
  private final List<Component> topRightChildren = new ArrayList<>();

  public ContentLayout() {

    self.addClassName("container");

    mainArea.addClassName("content");

    topRight.addClassName("side");

    self.add(mainArea);
    self.add(topRight);
  }

  public void add(Component c) {
    mainArea.add(c);
  }

  public void remove(Component c) {
    mainArea.remove(c);
  }

  public void setTopRight(Component c) {
    for (Component child : topRightChildren) {
      topRight.remove(child);
    }
    topRightChildren.clear();

    if (c != null) {
      topRight.add(c);
      topRightChildren.add(c);
    }
  }

  public void clearTopRight() {
    setTopRight(null);
  }

  private void clearMain() {
    mainArea.removeAll();
  }

  @Override
  public void showRouteContent(Component component) {
    clearMain();
    if (component != null)
      add(component);
    if (component instanceof TopRightHeadersProvider) {
        TopRightHeadersProvider p = (TopRightHeadersProvider) component;
        HeadersList hl = new HeadersList();
        hl.setHeaders(p.getTopRightHeaders());
        setTopRight(hl);
      }
  }

  @Override
  public void removeRouteContent(Component component) {
    if (component != null)
      remove(component);
  }
}
