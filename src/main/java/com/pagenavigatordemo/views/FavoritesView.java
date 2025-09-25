package com.pagenavigatordemo.views;

import com.pagenavigatordemo.views.ContentLayout.SideMenuProvider;
import com.webforj.component.Composite;
import com.webforj.component.html.elements.H3;
import com.webforj.component.html.elements.Span;
import com.webforj.component.layout.flexlayout.FlexLayout;
import com.webforj.router.annotation.FrameTitle;
import com.webforj.router.annotation.Route;

@Route(value = "/favorites", outlet = ContentLayout.class)
@FrameTitle("Favorites")
public class FavoritesView extends Composite<FlexLayout> implements SideMenuProvider {
  private FlexLayout self = getBoundComponent();

  public FavoritesView() {
    self.setHeight("100%");
    self.setDirection(com.webforj.component.layout.flexlayout.FlexDirection.COLUMN);
    self.setSpacing("1rem");

    addSection("Section 1", "Content for section 1. " + longText());
    addSection("Section 2", "Content for section 2. " + longText());
    addSection("Section 3", "Content for section 3. " + longText());
    addSection("Section 4", "Content for section 4. " + longText());
    addSection("Section 5", "Content for section 5. " + longText());
    addSection("Section 6", "Content for section 6. " + longText());
  }

  private void addSection(String title, String body) {

    H3 h = new H3(title);
    h.setAttribute("id", com.pagenavigatordemo.views.ContentLayout.createSlug(title));
    self.add(h);
    for (int i = 0; i < 6; i++) {
      self.add(new Span(body));
    }
  }

  private String longText() {
    return "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.";
  }

  @Override
  public java.util.List<String> getSideMenuItems() {
    return java.util.Arrays.asList("Section 1", "Section 2", "Section 3", "Section 4", "Section 5", "Section 6");
  }
}
