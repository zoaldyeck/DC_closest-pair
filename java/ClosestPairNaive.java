public class ClosestPairNaive {
    
    public final static double INF = java.lang.Double.POSITIVE_INFINITY;
    
    //
    // findClosestPair()
    //
    // Given a collection of nPoints points, find and ***print***
    //  * the closest pair of points
    //  * the distance between them
    // in the form "NAIVE (x1, y1) (x2, y2) distance"
    //
    
    // INPUTS:
    //  - points sorted in nondecreasing order by X coordinate
    //  - points sorted in nondecreasing order by Y coordinate
    //
    
    public static void findClosestPair(XYPoint points[], boolean print)
    {
	    int nPoints = points.length;
	
	//
	// Your code goes here!
	//
	    double minNaive=INF;
	    double d;
	    XYPoint po1 = null,po2=null;
	    for(int i=0;i<nPoints-1;i++)
	    	for(int j=i+1;j<nPoints;j++){
	    		d=points[i].dist(points[j]);
	    		if(d<minNaive){
	    			minNaive=d;
	    			po1=points[i];
	    			po2=points[j];
	    		}
	    	}    
	
	    if (print)
	    System.out.println("NAIVE " + po1.toString()+po2.toString()+(double)Math.round(100000*minNaive)/100000);
    }
}
