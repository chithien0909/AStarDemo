# AStarDemo
- Execute the src/Main.java, and the main form is shown with default Map.inp is opened
- We offer the map structure as follows:
<height> <width> <src_row> <src_col> <dst_row> <dst_col> (row, col are 0-based index)
<map_content, with 1 indicates walls>
## How to create a map ?
Example:
Here is the map with 6 row and 8 cols, where agent starts from (0, 0) to reach (7, 4)
```
6 8 0 0 7 4
0 0 1 0 0 0 0 0
0 0 1 1 1 0 0 0
1 0 0 0 1 0 0 0
0 0 0 0 1 1 0 0
0 0 0 1 0 0 1 0
0 0 0 0 0 0 0 0
```
Obviously, there is a way to go from (0, 0) to (7, 4)
