package action;
import bean.Product;
import org.apache.struts2.ServletActionContext;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 准备数据
 */
public class ProductAction {

    private Product product;
    public String show(){
        /*HttpServletRequest request=ServletActionContext.getRequest();
        HttpServletResponse response=ServletActionContext.getResponse();*/

        //准备数据
        product=new Product();
        product.setName("iphone11");
        return "show";
    }

    public String add(){
        System.out.println("product.name:"+product.getName());
        return "show";
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
