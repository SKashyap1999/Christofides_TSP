package edu.neu.coe.info6205.threesum;
import edu.neu.coe.info6205.util.Stopwatch;
import java.util.function.Supplier;
public class jk {


    public static void main(String[] args){
        Triple[] triples;
        long time_elapsed;
        Stopwatch time;
        long[] quadrithmic_time=new long[5];
        long[] quad_time=new long[5];
        long[] cubic_time=new long[5];
        for(int i=0;i<10;i++) {
            Supplier<int[]> intsSupplier = new Source(250, 130, 2L).intsSupplier(10);
            int[] ints = intsSupplier.get();
            time = new Stopwatch();
            ThreeSum target_calipers = new ThreeSumQuadrithmic(ints);
            triples = target_calipers.getTriples();
            time_elapsed = time.lap();
            quadrithmic_time[0] += time_elapsed;
            System.out.println("Time taken for quadrithmic for n=250 is " + time_elapsed + " ms");
            triples = new ThreeSumQuadratic(ints).getTriples();
            time_elapsed = time.lap();
            quad_time[0] += time_elapsed;
            System.out.println("Time taken for quad for n=250 is " + time_elapsed + " ms");
            ThreeSum target_cubic = new ThreeSumCubic(ints);
            triples = target_cubic.getTriples();
            time_elapsed = time.lap();
            cubic_time[0] += time_elapsed;
            System.out.println("Time taken for cubic for n=250 is " + time_elapsed + " ms");
            time.close();
            intsSupplier = new Source(500, 260, 2L).intsSupplier(10);
            ints = intsSupplier.get();
            time = new Stopwatch();
            target_calipers = new ThreeSumQuadrithmic(ints);
            triples = target_calipers.getTriples();
            time_elapsed = time.lap();
            quadrithmic_time[1] += time_elapsed;
            System.out.println("Time taken for quadrithmic for n=500 is" + " " + time_elapsed + " ms");
            triples = new ThreeSumQuadratic(ints).getTriples();
            time_elapsed = time.lap();
            quad_time[1] += time_elapsed;
            System.out.println("Time taken for quad for n=500 is" + " " + time_elapsed + " ms");
            target_cubic = new ThreeSumCubic(ints);
            triples = target_cubic.getTriples();
            time_elapsed = time.lap();
            cubic_time[1] += time_elapsed;
            System.out.println("Time taken for cubic for n=500 is" + " " + time_elapsed + " ms");

            time.close();
            intsSupplier = new Source(1000, 800, 2L).intsSupplier(10);
            ints = intsSupplier.get();
            time = new Stopwatch();
            target_calipers = new ThreeSumQuadrithmic(ints);
            triples = target_calipers.getTriples();
            time_elapsed = time.lap();
            quadrithmic_time[2] += time_elapsed;
            System.out.println("Time taken for quadrithmic for n=1000 is" + " " + time_elapsed + " ms");
            triples = new ThreeSumQuadratic(ints).getTriples();
            time_elapsed = time.lap();
            quad_time[2] += time_elapsed;
            System.out.println("Time taken for quad for n=1000 is" + " " + time_elapsed + " ms");
            target_cubic = new ThreeSumCubic(ints);
            triples = target_cubic.getTriples();
            time_elapsed = time.lap();
            cubic_time[2] += time_elapsed;
            System.out.println("Time taken for cubic for n=1000 is" + " " + time_elapsed + " ms");

            time.close();
            intsSupplier = new Source(2000, 1100, 2L).intsSupplier(10);
            ints = intsSupplier.get();
            time = new Stopwatch();
            target_calipers = new ThreeSumQuadrithmic(ints);
            triples = target_calipers.getTriples();
            time_elapsed = time.lap();
            quadrithmic_time[3] += time_elapsed;
            System.out.println("Time taken for quadrithmic for n=2000 is" + " " + time_elapsed + " ms");
            triples = new ThreeSumQuadratic(ints).getTriples();
            time_elapsed = time.lap();
            quad_time[3] += time_elapsed;
            System.out.println("Time taken for quad for n=2000 is" + " " + time_elapsed + " ms");
            target_cubic = new ThreeSumCubic(ints);
            triples = target_cubic.getTriples();
            time_elapsed = time.lap();
            cubic_time[3] += time_elapsed;
            System.out.println("Time taken for cubic for n=2000 is" + " " + time_elapsed + " ms");

            time.close();
            intsSupplier = new Source(4000, 2500, 2L).intsSupplier(10);
            ints = intsSupplier.get();
            time = new Stopwatch();
            target_calipers = new ThreeSumQuadrithmic(ints);
            triples = target_calipers.getTriples();
            time_elapsed = time.lap();
            quadrithmic_time[4] += time_elapsed;
            System.out.println("Time taken for quadrithmic for n=4000 is" + " " + time_elapsed + " ms");
            triples = new ThreeSumQuadratic(ints).getTriples();
            time_elapsed = time.lap();
            quad_time[4] += time_elapsed;
            System.out.println("Time taken for quad for n=4000 is" + " " + time_elapsed + " ms");
            target_cubic = new ThreeSumCubic(ints);
            triples = target_cubic.getTriples();
            time_elapsed = time.lap();
            cubic_time[4] += time_elapsed;
            System.out.println("Time taken for cubic for n=4000 is" + " " + time_elapsed + " ms");


      /*   intsSupplier = new Source(8000, 5000, 2L).intsSupplier(10);
         ints = intsSupplier.get();

         target_calipers= new ThreeSumQuadraticWithCalipers(ints);
        triples=target_calipers.getTriples();
        System.out.println("Time taken for quad_cal for n=8000 is");
        triples = new ThreeSumQuadratic(ints).getTriples();
        System.out.println("Time taken for quad for n=8000 is");
         target_cubic = new ThreeSumCubic(ints);
        triples=target_cubic.getTriples();
        System.out.println("Time taken for cubic for n=8000 is");

*/

        }
        for(int i=0;i<5;i++){
            quadrithmic_time[i]/=10l;
            quad_time[i]/=10l;
            cubic_time[i]/=10l;
        }
        System.out.println("Quadrithmic times are ");
        for(int i=0;i<5;i++){
            System.out.println(quadrithmic_time[i]);
        }
        System.out.println("Quadratic times are ");
        for(int i=0;i<5;i++){
            System.out.println(quad_time[i]);
        }
        System.out.println("Cubic times are ");
        for(int i=0;i<5;i++){
            System.out.println(cubic_time[i]);
        }
    }
}
