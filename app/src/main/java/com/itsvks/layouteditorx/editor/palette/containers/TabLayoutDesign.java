package com.itsvks.layouteditorx.editor.palette.containers;

import com.google.android.material.tabs.TabLayout;
import com.itsvks.layouteditorx.Constants;
import com.itsvks.layouteditorx.utils.Utils;

import android.content.Context;
import android.graphics.Canvas;

public class TabLayoutDesign extends TabLayout {
  
  private boolean drawStrokeEnabled;
  private boolean isBlueprint;

  public TabLayoutDesign(Context context) {
    super(context);
  }

  @Override
  protected void dispatchDraw(Canvas canvas) {
    super.dispatchDraw(canvas);

    if (drawStrokeEnabled)
      Utils.drawDashPathStroke(
          this, canvas, isBlueprint ? Constants.BLUEPRINT_DASH_COLOR : Constants.DESIGN_DASH_COLOR);
  }

  public void setStrokeEnabled(boolean enabled) {
    drawStrokeEnabled = enabled;
    invalidate();
  }
  
  @Override
  public void draw(Canvas canvas) {
    if (isBlueprint) Utils.drawDashPathStroke(this, canvas, Constants.BLUEPRINT_DASH_COLOR);
    else super.draw(canvas);
  }

  public void setBlueprint(boolean isBlueprint) {
    this.isBlueprint = isBlueprint;
    invalidate();
  }
}
