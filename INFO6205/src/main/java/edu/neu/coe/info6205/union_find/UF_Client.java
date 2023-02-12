package edu.neu.coe.info6205.union_find;
import java.util.Scanner;
import java.util.Random;
public class UF_Client {
    public static void main(String args[]){
        int n=100;
        long connections;
        for(int i=1;i<6;i++) {
            connections = count(n);
            System.out.println(connections + " connections are being created to form a single fully connected component from "+n+" sites");

            n=n*5;
        }
    }
    public static long count(int n){
        UF_HWQUPC h=new UF_HWQUPC(n);
        Random rand=new Random();
        while(!(h.isConnected())){
            int a=rand.nextInt(n);
            int b=rand.nextInt(n);
            if(!(h.connected(a,b)))
                h.union(a,b);
        }

        return h.getConnections();

    }
}
