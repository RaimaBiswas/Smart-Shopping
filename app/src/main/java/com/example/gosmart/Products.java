package com.example.gosmart;

public class Products {

    private String _id;
    private String _productname;
    private String _productprice;

    public Products(String id, String productname, String productprice) {
        this._id = id;
        this._productname = productname;
        this._productprice = productprice;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void set_productname(String _productname) {
        this._productname = _productname;
    }

    public void set_productprice(String _productprice) {
        this._productprice = _productprice;
    }

    public String get_id() {
        return _id;
    }

    public String get_productname() {
        return _productname;
    }

    public String get_productprice() {
        return _productprice;
    }
}
/*package com.example.joker.gosmart;

public class Products {

    private String _id;
    private String _productname;
    private String _productprice;

    public Products(String id, String productname, String productprice) {
        this._id = id;
        this._productname = productname;
        this._productprice = productprice;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public void set_productname(String _productname) {
        this._productname = _productname;
    }

    public void set_productprice(String _productprice) {
        this._productprice = _productprice;
    }

    public String get_id() {
        return _id;
    }

    public String get_productname() {
        return _productname;
    }

    public String get_productprice() {
        return _productprice;
    }
}
*/