package player;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Area;

import game.Coordinate;

public final class SpriteCreator
{

	public static Rectangle[] fourSquareArrowFormation(Coordinate offsetPoint, int totalWidth, int totalHeight)
	{
		//Makes a shape like arrow keys
		/*
				 x 
		 		xxx
		 */
		//hordivheight = heightofrect,	vertdivwidth = widthofrect
		int zeroWidth = offsetPoint.x;
		int zeroHeight = offsetPoint.y;
		int vertDivWidth = totalWidth/3;
		int vertDiv1 = vertDivWidth + offsetPoint.x;
		int vertDiv2 = vertDivWidth * 2 + offsetPoint.x;
		//int vertDiv3 = vertDivWidth * 3 + offsetPoint.x; /*Should be right edge if perfectly divided*/ Commented because unused
		int horDivHeight = totalHeight/2;
		int horDiv1 = horDivHeight + offsetPoint.y;
		//int horDiv2 = horDivHeight * 2 + offsetPoint.y; /*Should be bottom edge if perfectly divided*/ Commented because unused
		Rectangle top = new Rectangle(vertDiv1, zeroHeight, vertDivWidth, horDivHeight);
		Rectangle lft = new Rectangle(zeroWidth, horDiv1, vertDivWidth, horDivHeight);
		Rectangle rgt = new Rectangle(vertDiv2, horDiv1, vertDivWidth, horDivHeight);
		Rectangle bot = new Rectangle(vertDiv1, horDiv1, vertDivWidth, horDivHeight);
		Rectangle[] rects = new Rectangle[]{top, lft, rgt, bot};
		return rects;
	}
	
	public static Shape combine(Shape[] shapes)
	{
		Area a = new Area();
		for(Shape cur : shapes)
		{
			a.add(new Area(cur));
		}
		return a;
	}
	
}
