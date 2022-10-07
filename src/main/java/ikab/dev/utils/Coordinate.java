package ikab.dev.utils;

interface Coordinate {
  
  static Coordinate NULL = NullCoordinate.getInstance();
  boolean isNull();
  Direction getNearDirection(Coordinate coordinate);
  boolean inHorizontal(Coordinate coordinate);
  boolean inVertical(Coordinate coordinate);
  boolean inMainDiagonal(Coordinate coordinate);

}
