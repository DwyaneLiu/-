package Model;

public class NewsList {

    private String company_name;
    private String new_title;
    private String new_date;
    private String new_href;
    private int new_id;
    
    
    public NewsList() {
        super();
    }
    
    public NewsList(String company_name,String new_title,String new_date,  String new_href,int new_id) {
        super();
        this.setCompany_name(company_name);
        this.setNew_date(new_date);
        this.setNew_title(new_title);
        this.setNew_href(new_href);
        this.setNew_id(new_id);
        
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
	public String getNew_href() {
		return new_href;
	}
	public void setNew_href(String new_href) {
		this.new_href = new_href;
	}
	public int getNew_id() {
		return new_id;
	}
	public void setNew_id(int new_id) {
		this.new_id = new_id;
	}


    
}