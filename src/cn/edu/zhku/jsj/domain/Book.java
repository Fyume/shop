package cn.edu.zhku.jsj.domain;

public class Book {
	private int book_id;
	/*private String type;//记录种类
*/	private String bookname;
	private String author;
	private String press;//出版社
	private float price;
	private String version;//记录用户定义的标签,用","隔开 取数据的时候用<c:forTokens> 标签 
	private String images; //记住各种书的 图片
	private String ISBN;
	private String description;
	private int store_id;  //外键 记住是哪家店的商品
	private int totalnum;   //货品的库存量
	public int getTotalnum() {
		return totalnum;
	}
	public void setTotalnum(int totalnum) {
		this.totalnum = totalnum;
	}
	public int getBook_id() {
		return book_id;
	}
	public void setBook_id(int book_id) {
		this.book_id = book_id;
	}
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

	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
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

}
