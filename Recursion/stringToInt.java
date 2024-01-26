
public class solution {

	public static int convertStringToInt(String input){
		// Write your code here
		return stringIntHelper(input,input.length() - 1);
	


	}
	private static int stringIntHelper(String input,int index){
		if(index<0) return 0;
		int num = input.charAt(index)-'0';
		int ans = 10*stringIntHelper(input,index-1)+num;
		return ans;
	}
}
