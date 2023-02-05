/*
  (c) Copyright 2018, 2019 Phasmid Software
 */
package edu.neu.coe.info6205.sort.elementary;

import edu.neu.coe.info6205.sort.BaseHelper;
import edu.neu.coe.info6205.sort.Helper;
import edu.neu.coe.info6205.sort.SortWithHelper;
import edu.neu.coe.info6205.util.Config;
import org.ini4j.Ini;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class InsertionSort<X extends Comparable<X>> extends SortWithHelper<X> {

    /**
     * Constructor for any sub-classes to use.
     *
     * @param description the description.
     * @param N           the number of elements expected.
     * @param config      the configuration.
     */
    protected InsertionSort(String description, int N, Config config) {
        super(description, N, config);
    }

    /**
     * Constructor for InsertionSort
     *
     * @param N      the number elements we expect to sort.
     * @param config the configuration.
     */
    public InsertionSort(int N, Config config) {
        this(DESCRIPTION, N, config);
    }

    public InsertionSort(Config config) {
        this(new BaseHelper<>(DESCRIPTION, config));
    }

    /**
     * Constructor for InsertionSort
     *
     * @param helper an explicit instance of Helper to be used.
     */
    public InsertionSort(Helper<X> helper) {
        super(helper);
    }

    public InsertionSort() {
        this(BaseHelper.getHelper(InsertionSort.class));
    }

    /**
     * Sort the sub-array xs:from:to using insertion sort.
     *
     * @param xs   sort the array xs from "from" to "to".
     * @param from the index of the first element to sort
     * @param to   the index of the first element not to sort
     */
    public void sort(X[] xs, int from, int to) {
        int index;
        final Helper<X> helper = getHelper();
        if(helper.instrumented()){
            for(int i=from;i<(to-1);i++){
                index=i+1;
                while(helper.swapStableConditional(xs,index)){
                    index=index-1;
                    if(index==0)
                        break;}
            }

        }
        else{
            for (int i = from; i < (to - 1); i++) {
                for (int j = i + 1; j > from; j--) {
                    int k = xs[j].compareTo(xs[j - 1]);
                    if (k < 0) {
                        swap(xs, j - 1, j);
                    }
                    else if(k>0){
                        break;
                    }
                }
            }
        }



    }

    public static final String DESCRIPTION = "Insertion sort";

    public static <T extends Comparable<T>> void sort(T[] ts) {
        new InsertionSort<T>().mutatingSort(ts);
    }
    private static <T extends Comparable<T>> void swap(T[] arr,int i,int j){
        T temp;
        temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
