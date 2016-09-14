package comcast;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class PartOne {

	public static void main(String[] args) {
		String jsonfile="src/comcast/coordinates.json";
		List<Coordinate> coordinates=ReadCoordinates(jsonfile);

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean flag=true;
		int ox=0;
		int oy=0;
		while(flag) {
			try{
				System.out.print("Enter origin x:");
				String s=null;
				try {
					s = br.readLine();
				} catch (Exception e) {
					e.printStackTrace();
				}
				if(s==null || s.length()==0) {
					flag=false;
					continue;
				} else {
					ox=Integer.parseInt(s);
					System.out.print("Enter origin y:");
					s=br.readLine();
					if(s==null||s.length()==0) {
						flag=false;
					} else {
						oy=Integer.parseInt(s);
						List<Coordinate> clist=SortWithOrigin(coordinates, ox, oy);
						for(int i=0;i<clist.size();i++) {
							Coordinate c=clist.get(i);
							System.out.println("id="+c.id+", x="+c.x+" y="+c.y+" distance="+c.getDist());
						}
						System.out.println();

					}
				}

			} catch(NumberFormatException nfe){
				System.err.println("Invalid Format!");
				flag=false;
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	/**
	 * SortWithOrigin sorts the list of coordinates in order closest to furthest to given origin
	 * @param clist  The list of coordinates to be sorted
	 * @param ox x-coordinate of origin
	 * @param oy y-coordinate of origin
	 * @return Sorted List of cordinates
	 */
	public static List<Coordinate> SortWithOrigin(List<Coordinate> clist, int ox, int oy) {
		for(int i=0;i<clist.size();i++) {
			Coordinate c=clist.get(i);
			c.calcDist(ox,  oy);
		}
		Collections.sort(clist, new CoordinateComparator());
		return clist;
	}

	/**
	 * ReadCoordinates read Json file and return the list of Coordinates
	 * @param clist  The list of coordinates to be sorted
	 * @param ox x-coordinate of origin
	 * @param oy y-coordinate of origin
	 * @return Sorted List of cordinates
	 */
	public static ArrayList<Coordinate> ReadCoordinates(String jsonfile) {
		JSONParser parser = new JSONParser();
		ArrayList<Coordinate> alist=new ArrayList<Coordinate>();
		try {
			Object obj = parser.parse(new FileReader(jsonfile));
			JSONArray array=(JSONArray) obj;
			int len=array.size();
			for(int i=0;i<len;i++) {
				JSONObject coordinate= (JSONObject) array.get(i);
				String id=(String) coordinate.get("id");
				String value=(String) coordinate.get("value");
				String[] values=value.split(",");
				int x=Integer.parseInt(values[0]);
				int y=Integer.parseInt(values[1]);
				Coordinate c=new Coordinate(id, x, y);
				alist.add(new Coordinate(id, x, y));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return alist;
	}

}
