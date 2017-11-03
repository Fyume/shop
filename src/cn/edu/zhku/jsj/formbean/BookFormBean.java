package cn.edu.zhku.jsj.formbean;

import java.util.HashMap;
import java.util.Map;

public class BookFormBean {
	private String bookname;
	private String author;
	private String press;//出版社
	private float price;
	private String version;//记录用户定义的标签,用","隔开 取数据的时候用<c:forTokens> 标签 
	private String ISBN;
	private String description;
	private int store_id;  //外键 记住是哪家店的商品
	private int totalnum;   //货品的库存量
	
	private int book_id;
	public int getBook_id() {
		return book_id;
	}

	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}


	private Map<String,String> errormap = new HashMap<String,String>();

	public String getBookname() {
		return bookname;
	}

	public void setBookname(String bookname) {
		this.bookname = bookname;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getPress() {
		return press;
	}

	public void setPress(String press) {
		this.press = press;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
		ISBN = iSBN;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getStore_id() {
		return store_id;
	}

	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}

	public int getTotalnum() {
		return totalnum;
	}

	public void setTotalnum(int totalnum) {
		this.totalnum = totalnum;
	}

	public Map<String, String> getErrormap() {
		return errormap;
	}

	public void setErrormap(Map<String, String> errormap) {
		this.errormap = errormap;
	}
	
	
	public boolean checkoutData(){
		boolean b = false;
		if(this.bookname==null || this.bookname.trim().equals("")){
			errormap.put("bookname", "请输入书的名称");
			return b;
		}
		if(this.author==null || this.author.trim().equals("")){
			errormap.put("author", "请输入作者名称");
			return b;
		}
		if(this.press==null || this.press.trim().equals("")){
			errormap.put("press", "请输入出版社");
			return b;
		}
		if(this.version==null || this.version.trim().equals("")){
			errormap.put("version", "请输入版本类型");
			return b;
		}
		if(this.ISBN==null || this.ISBN.trim().equals("")){
			errormap.put("ISBN", "请输入书的ISBN号");
			return b;
		}
		if(this.ISBN.trim().length() != 13){
			errormap.put("ISBN", "书的ISBN号为13位数");
			return b;
		}
		if(this.description==null || this.description.trim().equals("")){
			errormap.put("description", "请输入书的简介");
			return b;
		}
		if(this.totalnum==0){
			errormap.put("totalnum", "请输入书的库存量");
			return b;
		}
		b = true;
		return b;
	}
	
}
