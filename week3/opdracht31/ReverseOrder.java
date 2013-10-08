package week3.opdracht31;
// ReverseOrder
// auteur: J.Kaldeway

import java.util.Comparator;

public class ReverseOrder<T extends Comparable<T>> implements Comparator<T>
{
     public int compare(T o1, T o2)
     {
         return o2.compareTo(o1);  // let op: o1 en o2 zijn verwisseld!
     }
}