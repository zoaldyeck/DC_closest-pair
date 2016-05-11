import java.util.ArrayList;
import java.util.Arrays;

public class ClosestPairDC {
	
    public static XYPoint x1,x2;     
    public final static double INF = java.lang.Double.POSITIVE_INFINITY;
    public static double temp = INF,minDis=INF;
  
    public static double findClosestPair(XYPoint pointsByX[], 
				       XYPoint pointsByY[],
				       boolean print)
    {
    	int n = pointsByX.length,mid;
    	double disLR,disL,disR;
    //	minDis=findClosestPair(pointsByX,pointsByY,true);
    	if(n==1)               
    		temp=INF;
    	else
    		if(n==2){
    			temp=pointsByX[0].dist(pointsByX[1]);
    		if (temp<minDis){
    				minDis=temp;
    				x1=pointsByX[0];
    				x2=pointsByX[1];
    		        }}
    	                                            //base is 2 or 1
    		if(n>2){
    			mid=n/2;
    			XYPoint XL [] = Arrays.copyOfRange(pointsByX, 0,mid);
    			XYPoint XR [] = Arrays.copyOfRange(pointsByX, mid,n);
	            XYPoint YL [] = Arrays.copyOfRange(pointsByY, 0,mid);
	            XYPoint YR [] = Arrays.copyOfRange(pointsByY, mid,n);   //divide into 2 parts 
	    
	            disL=findClosestPair(XL,YL,false);
	            disR=findClosestPair(XR,YR,false);
	            disLR=(disL<disR)?disL:disR; 
	            minDis=disLR; //find the closest pair in the left or right group
	            
	            XYPoint midPoint=pointsByX[mid];
	   
	            
	        	
	        	int i=mid,j=mid,k=mid;
	        	double crossTemp=INF;       	
	        	for(i=mid;i>=0&&midPoint.x-pointsByX[i].x<=disLR;i--);
	        		j=i+1;
	        	for(i=mid;i<n&&pointsByX[i].x-midPoint.x<=disLR;i++);
	        		k=i;   		
	        	XYPoint ystrip[]=Arrays.copyOfRange(pointsByX, j, k);   //construct ystrip
	        	
	        	for(j=0;j<=ystrip.length-2;j++)
	        		for(k=j+1;k<=ystrip.length-1;k++)
	        			if(ystrip[k].y-ystrip[j].y<=disLR){
	        			crossTemp=ystrip[j].dist(ystrip[k]);
	        			if(crossTemp<minDis){
	        			minDis=crossTemp;
	        			x1=ystrip[j];
	        			x2=ystrip[k];
	        			 }	}	}
	        	if (print)
	       		    System.out.println("DC " + x1.toString()+x2.toString()+(double)Math.round(100000*minDis)/100000);
   	            
    	return minDis;      	
    }
};    	    