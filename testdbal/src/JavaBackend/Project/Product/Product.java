package JavaBackend.Project.Product;

public class Product {
    private String idProd;
    private int idClass;
    private String idQuantity;
    private String idDescription;
    private String nameProd;
    private long priceUnit;
    private int storing;
    private int ordered;
    private int delivered;
    private String  detailDiscount;
    private String image;
    private String  detail_infor;
    private String onlineDiscount;
    public Product(){

    }

    public Product(String idProd, int idClass, String idQuantity, String idDescription, String nameProd,
                   long priceUnit, int storing, int ordered, int delivered, String detailDiscount, String image,
                   String detail_infor, String onlineDiscount) {
        this.idProd = idProd;
        this.idClass = idClass;
        this.idQuantity = idQuantity;
        this.idDescription = idDescription;
        this.nameProd = nameProd;
        this.priceUnit = priceUnit;
        this.storing = storing;
        this.ordered = ordered;
        this.delivered = delivered;
        this.detailDiscount = detailDiscount;
        this.image = image;
        this.detail_infor = detail_infor;
        this.onlineDiscount = onlineDiscount;
    }

    public String getIdProd() {
        return idProd;
    }

    public void setIdProd(String idProd) {
        this.idProd = idProd;
    }

    public int getIdClass() {
        return idClass;
    }

    public void setIdClass(int idClass) {
        this.idClass = idClass;
    }

    public String getIdQuantity() {
        return idQuantity;
    }

    public void setIdQuantity(String idQuantity) {
        this.idQuantity = idQuantity;
    }

    public String getIdDescription() {
        return idDescription;
    }

    public void setIdDescription(String idDescription) {
        this.idDescription = idDescription;
    }

    public String getNameProd() {
        return nameProd;
    }

    public void setNameProd(String nameProd) {
        this.nameProd = nameProd;
    }

    public long getPriceUnit() {
        return priceUnit;
    }

    public void setPriceUnit(long priceUnit) {
        this.priceUnit = priceUnit;
    }

    public int getStoring() {
        return storing;
    }

    public void setStoring(int storing) {
        this.storing = storing;
    }

    public int getOrdered() {
        return ordered;
    }

    public void setOrdered(int ordered) {
        this.ordered = ordered;
    }

    public int getDelivered() {
        return delivered;
    }

    public void setDelivered(int delivered) {
        this.delivered = delivered;
    }

    public String getDetailDiscount() {
        return detailDiscount;
    }

    public void setDetailDiscount(String detailDiscount) {
        this.detailDiscount = detailDiscount;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDetail_infor() {
        return detail_infor;
    }

    public void setDetail_infor(String detail_infor) {
        this.detail_infor = detail_infor;
    }

    public String getOnlineDiscount() {
        return onlineDiscount;
    }

    public void setOnlineDiscount(String onlineDiscount) {
        this.onlineDiscount = onlineDiscount;
    }
}
