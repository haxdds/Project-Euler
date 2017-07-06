package problems1_100;

public class Problem_19 {
	int answer = 0;
	
	int year = 1;
	int month = 1;
	// The first Sunday of the century fell on January 7th
	int date = 6;
	
	/*
	Thirty days has September,
	April, June and November.
	All the rest have thirty-one,
	Saving February alone,
	Which has twenty-eight, rain or shine.
	And on leap years, twenty-nine.
	A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
	*/
	
	// Jan(1) = 31 days, Feb(2) = 28/29 days, Mar(3) = 31 days
	// Apr(4) = 30 days, May(5) = 31 days, Jun(6) = 30 days
	// Jul(7) = 31 days, Aug(8) = 31 days, Sep(9) = 30 days
	// Oct(10) = 31 days, Nov(11) = 30 days, Dec(12) = 31 days
	
	//finds first Sunday of every month
	private void findSun(){
		int daysLeft;
		
		if(month == 1 || month == 3 || month == 5 || month ==  7|| month == 8 || month == 10 || month == 12){
			daysLeft = 31 - date;
		    date = 7 -(daysLeft % 7);
		    
		    
		    
		    if(date == 1){
				answer += 1;
			}
		    
		    
		    month++;
		    if(month == 13){
		    month = 1;		    
		    year++;
		    }
		}
		
		if(month == 4 || month == 6 || month == 9 || month ==  11){
			daysLeft = 30 - date;
		    date = 7 -(daysLeft % 7);
		    
		    if(date == 1){
				answer += 1;
			}
		    
		    
		    month++;
		    if(month == 13){
		    month = 1;
		    year++;
		    }
		}
		
		if(month == 2 && year % 4 == 0){
			daysLeft = 29 - date;
		    date = 7 -(daysLeft % 7);
		    
		    if(date == 1){
				answer += 1;
			}		    
		    
		    month++;
		    if(month == 13){
		    month = 1;
		    year++;
		    }
		}
		
		if(month == 2 && year % 4 != 0){
			daysLeft = 28 - date;
		    date = 7 -(daysLeft % 7);
		    
		    if(date == 1){
				answer += 1;
			}
		    		    
		    month++;
		    if(month == 13){
		    month = 1;
		    year++;
		    }
		    
		}
		
		
		
		
	}
	
	private void iterate(){
		while(year <= 100){
			findSun();
		}
		
	}
	
	public void problem19(){
		iterate();
		System.out.println(answer);
	}
	
	
		
}

