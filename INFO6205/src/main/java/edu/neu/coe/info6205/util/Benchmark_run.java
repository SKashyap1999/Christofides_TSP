package edu.neu.coe.info6205.util;

import edu.neu.coe.info6205.sort.elementary.InsertionSort;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class Benchmark_run {
    public static void main(String[] args) {

        System.out.println("Started benchmarking procedure");
        ArrayList<Double> random_times=new ArrayList<>();
        ArrayList<Double> partial_times=new ArrayList<>();
        ArrayList<Double> sorted_times=new ArrayList<>();
        ArrayList<Double> reverse_times=new ArrayList<>();
        double d;
        int n = 200;
        int growth_iterations = 6;
        int runs = 40;
        Random rand = new Random();
        InsertionSort<Integer> is = new InsertionSort<>();
        String description = "Insertion Sort";
        UnaryOperator<Integer[]> fPre = array -> {return array.clone();};
        Consumer<Integer[]> fRun = array -> new InsertionSort<Integer>().sort(array,0,array.length);
        Consumer<Integer[]> fPost = null;
        Benchmark_Timer<Integer[]> bt = new Benchmark_Timer<>("Insertion Sort", fPre, fRun, fPost);
        for(int i=1; i<=growth_iterations; i++) {
            n = n*2;

            /* Random generated Array*/

            System.out.println("Random Array Sorting "+ i + " n = "+n);
            Integer[] random_arr = new Integer[n];
            for(int j=0; j<random_arr.length; j++) {
                random_arr[j] = rand.nextInt(100000);
            }
            d=bt.run(random_arr, runs);
            System.out.println("Mean lap time: "+d);
            random_times.add(d);

           /* Partially Sorted Array*/
            System.out.println("Partially Sorted Array Sorting "+ i + " n = "+n);
            is.sort(random_arr, 0, random_arr.length/2);
            Integer[] partial_sort = new Integer[n];
            for(int j=0; j<random_arr.length; j++) {
                partial_sort[j] = random_arr[j];
            }
            d=bt.run(random_arr, runs);
            System.out.println("Mean lap time: "+d);
            partial_times.add(d);


           /* Ordered Array,
           The array taken is a sorted version of random_arr
            */
            System.out.println("Fully Sorted Array Sorting "+ i + " n = "+n);
            is.sort(random_arr,0,random_arr.length);
            Integer[] ordered_arr = new Integer[n];
            for(int j=0; j<random_arr.length; j++) {
                ordered_arr[j] = random_arr[j];
            }
            d=bt.run(random_arr, runs);
            System.out.println("Mean lap time: "+d);
            sorted_times.add(d);
            /* Reverse-ordered Array,
            The array taken is a reversed version of sorted random_arr.
             */

            System.out.println("Reverse Sorted Array Sorting "+ i + " n = "+n);
            Integer[] reverse_arr = new Integer[n];
            for(int j=0,k=random_arr.length-1; j<random_arr.length && k>-1; j++,k--) {
                reverse_arr[k] = ordered_arr[j];
            }
            d=bt.run(reverse_arr, runs);
            System.out.println("Mean lap time: "+d);
            reverse_times.add(d);
        }

        System.out.println("Benchmarking completed successfully");
   for(double db:random_times)
       System.out.print(db+" ");
   System.out.println("\n");
        for(double db:partial_times)
            System.out.print(db+" ");
        System.out.println("\n");
        for(double db:sorted_times)
            System.out.print(db+" ");
        System.out.println("\n");
        for(double db:reverse_times)
            System.out.print(db+" ");
        System.out.println("\n");

    }
}
