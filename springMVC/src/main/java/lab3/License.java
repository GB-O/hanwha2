package lab3;

public class License {
	String title;
	int year;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "License [title=" + title + ", year=" + year + "]";
	}
	
	
}
