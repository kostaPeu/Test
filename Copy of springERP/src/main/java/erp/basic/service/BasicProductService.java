package erp.basic.service;

import java.util.List;

import erp.basic.domain.ListModelProduct;
import erp.basic.domain.Product;
import erp.basic.domain.ProductGroup;
import erp.basic.domain.Standards;

public interface BasicProductService {

	public List<ProductGroup> pgroupList() throws Exception;

	public List<Standards> standardList() throws Exception;

	public ListModelProduct productList(int page) throws Exception;

	public void productInsert(Product product) throws Exception;

	public void productUpdate(Product product) throws Exception;

	public void productDelete(String product_id) throws Exception;

	public List<Product> productCodeJson(String word) throws Exception;

}
