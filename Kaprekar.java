/*
Verificar experimentalmente la conjetura del matemático indú Kaprekar: Sean un número entero de 4 cifras: num = 7498, por ejemplo. El proceso recurrente:
	min = menor número de 4 cifras tomadas de los dígitos de num, siguiendo el ejemplo: 4789
	max = mayor número de 4 cifras tomadas de los dígitos de num, siguiendo el ejemplo: 9874
	num = max - min  // redefinido
Luego de algunas recurrencias, num converge a 6174 = Kaprekar.

Caso de prueba:
       num   min   max   num
  1   7498  4789  9874  5085
  2   5085   558  8550  7992
  3   7992  2799  9972  7173
  4   7173  1377  7731  6354
  5   6354  3456  6543  3087
  6   3087   378  8730  8352
  7   8352  2358  8532  6174
Sigue ...
  8   6174  1467  7641  6174 = Kaprekar
  9   6174  1467  7641  6174
      ...
*/

class Kaprekar{
	final static int KAPREKAR = 6174;
	static int num = 7498, min, max, ii=1;
	public static void main(String[] args){
		System.out.println("       num   min   max   num");
		do verificar(); while(num != KAPREKAR);
		System.out.println("Sigue ...");
		for(int i=0; i<2; i++) verificar();
		System.out.println("      ...");
	}
	
	static void verificar(){
		int i, nums[] = new int[4];
		System.out.printf("%3d %6d", ii++, num);
		for(i=3;i>=0;i--){
			nums[i] = num%10;
			num /=10;
		}
		sort(4, nums);
		min = nums[0];		
		max = nums[3];
		for(i=0;i<3;i++){
			min = 10*min + nums[i+1];
			max = 10*max + nums[2-i];
		}
		num = max-min;
		System.out.printf("%6d%6d%6d\n", min, max, num);
	}
	
	static void sort(int n, int nums[]){
		int i=0, j, tem;
		for(i=0; i<n-1; i++)
			for(j=i+1; j<n; j++)
				if(nums[i]>nums[j]){
					tem = nums[i];
					nums[i] = nums[j];
					nums[j] = tem;
				}
	}
}
