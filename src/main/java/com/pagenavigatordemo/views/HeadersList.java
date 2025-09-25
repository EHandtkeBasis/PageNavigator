package com.pagenavigatordemo.views;

import java.util.List;

import com.webforj.component.Composite;
import com.webforj.component.html.elements.Anchor;
import com.webforj.component.layout.flexlayout.FlexDirection;
import com.webforj.component.layout.flexlayout.FlexLayout;

public class HeadersList extends Composite<FlexLayout> {
  private final FlexLayout self = getBoundComponent();

  public HeadersList() {
    self.setDirection(FlexDirection.COLUMN);
    self.addClassName("headers-list");
  }

  public void setHeaders(List<String> headers) {
    if (headers == null) return;
    for (String h : headers) {
  String slug = h.toLowerCase().replaceAll("[^a-z0-9]+", "-").replaceAll("(^-|-$)", "");
  Anchor a = new Anchor("#" + slug, h);
  a.addClassName("top-right-item");
  self.add(a);
    }
  }
}
