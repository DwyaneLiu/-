package Model;

public class News {
	
  		private int new_id;
		private String company_name;
	    private String new_title;
	    private String new_date;
	    private String new_content;
	    
	    public News(){
	    	
	    }
	    public News(int new_id,String company_name,String new_date,String new_content,String new_title){
	    	
	    	this.company_name = company_name;
	    	this.new_date = new_date;
	    	this.new_content = new_content;
	    	this.new_id = new_id;
	    	this.new_title = new_title;
	    }
	    
		public int getNew_id() {
			return new_id;
		}
		public void setNew_id(int new_id) {
			this.new_id = new_id;
		}
		public String getCompany_name() {
			return company_name;
		}
		public void setCompany_name(String company_name) {
			this.company_name = company_name;
		}
		public String getNew_title() {
			return new_title;
		}
		public void setNew_title(String new_title) {
			this.new_title = new_title;
		}
		public String getNew_date() {
			return new_date;
		}
		public void setNew_date(String new_date) {
			this.new_date = new_date;
		}
		public String getNew_content() {
			return new_content;
		}
		public void setNew_content(String new_content) {
			this.new_content = new_content;
		}

}
