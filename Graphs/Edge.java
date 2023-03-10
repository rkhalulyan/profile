/*
Robert Khalulyan
Project 3
12/04/2022
 */

public class Edge {
  int u;
  int v;

  public Edge(int u, int v) {
    this.u = u;
    this.v = v;
  }

  @Override // Test if two edges are identical
  public boolean equals(Object o) {
    return u == ((Edge)o).u && v == ((Edge)o).v;
  }
}