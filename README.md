# Java---Software-Development-3

Java program to work with graphs

Problem
========
Write a class called “HalifaxMap” that accepts city map data, a current location, and a
destination and then prints the sequence of intersections to traverse to get to the destination.
The class has at least 3 methods:
- Boolean newIntersection( int x, int, y ) – record a new intersection for the city. Return
true if we acknowledge the intersection and we didn’t know about it before. Return
false otherwise.
- Boolean defineRoad( int x1, int y1, int x2, int y2 ) -- record the existence of a road from
(x1, y1) to (x2, y2) in the city. Return true if this road is a new one for the map and has
been added to requests to consider. Return false otherwise.
- Void navigate( int x1, int y1, int x2, int y2 ) – print to the screen the sequence of
intersection coordinates to follow to go from (x1, y1) to (x2, y2) in the shortest distance
while staying on roads. Print “no path” if you can’t get from the location to the
destination.
Dijkstra’s algorithm for shortest paths in graphs is one possible approach to solving this
problem. You are welcome to use others.

Inputs
=========
All the inputs will be determined by the parameters used in calling your methods.

Outputs
=========
The navigate( ) method produces output to the screen. It produces a list of coordinates, one
per line. The x and y coordinates are separated by a tab character. The first line is the current
location of the person who is calling you. The last line is the location of the destination.
