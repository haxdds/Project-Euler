package problems1_100;

public class Problem_17 {
	private int answer = 0;
	
	private int onesval(int ones){
		int value = 0;
		if(ones == 1 ){
			//one
			value += 3;
		}if(ones == 2 ){
			//two
			value += 3;
		}if(ones == 3 ){
			//three
			value += 5;
		}if(ones == 4 ){
			//four
			value += 4;
		}if(ones == 5 ){
			//five
			value += 4;
		}if(ones == 6 ){
			//six
			value += 3;
		}if(ones == 7 ){
			//seven
			value += 5;
		}if(ones == 8 ){
			//eight
			value += 5;
		}if(ones == 9 ){
			//nine
			value += 4;
		}		
		return value;
	}
	private int tensval(int n){
		int value = 0;
		if(n > 9 && n < 20){
			if(n == 10){
				//ten
				value += 3;
			}
			if(n == 11){
				//eleven
				value += 6;
			}
			if(n == 12){
				//twelve
				value += 6;
			}
			if(n == 13){
				//thirteen
				value += 8;
			}
			if(n == 14){
				//fourteen
				value += 8;
			}
			if(n == 15){
				//fifteen
				value += 7;
			}
			if(n == 16){
				//sixteen
				value += 7;
			}
			
			if(n == 17){
				//seventeen
				value += 9;
			}
			if(n == 18){
				//eighteen
				value += 8;
			}
			if(n == 19){
				//nineteen
				value += 8;
			}
				
		}
		
		if(n > 19 && n < 30){
			//twenty
			value += 6;
		}
		if(n > 29 && n < 40){
			//thirty
			value += 6;
		}
		if(n > 39 && n < 50){
			//forty
			value += 5;
		}
		if(n > 49 && n < 60){
			//fifty
			value += 5;
		}
		if(n > 59 && n < 70){
			//sixty
			value += 5;
		}
		if(n > 69 && n < 80){
			//seventy
			value += 7;
		}
		if(n > 79 && n < 90){
			//eighty
			value += 6;
		}
		if(n > 89 && n < 1000){
			//ninety
			value += 6;
		}
		return value;
		
	}
	private int hundredsval(int n){
		int value = 0;
		
		if(n > 100 & n<200){
			//one hundred and
			value += 13;
		}
		if(n > 200 & n<300){
			//two hundred and
			value += 13;
		}
		if(n > 300 & n<400){
			//three hundred and
			value += 15;
		}
		if(n > 400 & n<500){
			//four hundred and
			value += 14;
		}
		if(n > 500 & n<600){
			//five hundred and
			value += 14;
		}
		if(n > 600 & n<700){
			//six hundred and
			value += 13;
		}
		if(n > 700 & n<800){
			//seven hundred and
			value += 15;
		}
		if(n > 800 & n<900){
			//eight hundred and
			value += 15;
		}
		if(n > 900 & n<1000){
			//nine hundred and
			value += 14;
		}
		
		if(n % 100 == 0){
			value += onesval(n / 100);
			value += 7;
		}			
			
		
		return value;
	}
	
	
	public int lettercount(int n){
		int sum = 0;
		
		while(n != 0){
		if(n<10){
			sum += onesval(n);
			n /= 10;			
		}
		if(n>=10 && n<100){
			sum += tensval(n);
				if(n>19){
				n =	n % 10;
				}else if(n <= 19){
					n = 0;
				}
				
		}
		if(n >= 100 && n < 1000){
			sum += hundredsval(n);
			n = n % 100;
			
		}
		
		if(n == 1000){
			// one thousand
			sum += 11;
			n = 0;
		}
		
		}
		return sum;
	}
	
	private void sum(){
		int val = 0;
		for(int k = 1; k <= 1000; k++){
			val += lettercount(k);
			
		}
		answer = val;
	}
	
	public void problem17(){
		sum();
		System.out.print(answer);
	}
	
}
