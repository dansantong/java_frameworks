package com.action;

import com.dao.ProductDAO;
import com.pojo.Product;

import java.util.List;

public class ProductAction {
    ProductDAO productDAO=new ProductDAO();

    Product product;
    List<Product> products;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public String add(){
        productDAO.addProduct(product);
        return "list";
    }

    public String edit(){
        product=productDAO.getProduct(product.getId());
        return "edit";
    }

    public String delete(){
        productDAO.deleteProduct(product.getId());
        return "list";
    }

    public String update(){
        productDAO.update(product);
        return "list";
    }

    public String list(){
        products=productDAO.listProduct();
        return "listJsp";
    }
}
