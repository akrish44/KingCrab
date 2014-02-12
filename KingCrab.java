import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.awt.Color;
import java.util.ArrayList;

public class KingCrab extends CrabCritter {
  public KingCrab() {
    setColor(Color.CYAN);
  }

  public int distanceBetween(Location loc, Location loc1) {
    int x = loc.getRow();
    int y = loc.getCol();
    int x1 = loc1.getRow();
    int y1 = loc1.getCol();
    double distance = Math.sqrt((x-x1) * (x - x1) + (y - y1) * (y-y1) + 0.5);
    return (int)Math.floor(distance);

  }


  private boolean moveOneSpace(Actor a) {
    ArrayList<Location> locs = getGrid().getEmptyAdjacentLocations(a.getLocation());
    for (Location loc : locs) {
      if (distanceBetween(getLocation(), loc) > 1) {
        a.moveTo(loc);
        return true;
      } else {
        return false;
      }
    }
}
      public void processActors(ArrayList<Actor> actors) {
        for (Actor a : actors ) {
          if (!moveOneSpace(a)) {
            a.removeSelfFromGrid();
          }
        }
      }
    }
