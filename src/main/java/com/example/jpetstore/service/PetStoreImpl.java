package com.example.jpetstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.jpetstore.dao.AccountDao;
import com.example.jpetstore.dao.BlackListDao;
import com.example.jpetstore.dao.CategoryDao;
import com.example.jpetstore.dao.ItemDao;
import com.example.jpetstore.dao.OrderDao;
import com.example.jpetstore.dao.ProductDao;
import com.example.jpetstore.domain.Account;
import com.example.jpetstore.domain.BlackList;
import com.example.jpetstore.domain.Category;
import com.example.jpetstore.domain.Item;
import com.example.jpetstore.domain.Order;
import com.example.jpetstore.domain.Product;

/**
 * JPetStore primary business object.
 * 
 * <p>This object makes use of five DAO objects, decoupling it
 * from the details of working with persistence APIs. So
 * although this application uses iBATIS for data access,
 * a different persistence tool could be dropped in without
 * breaking this class.
 *
 * <p>The DAOs are made available to the instance of this object
 * using Dependency Injection. (The DAOs are in turn configured using
 * Dependency Injection themselves.) We use Setter Injection here,
 * exposing JavaBean setter methods for each DAO. This means there is
 * a JavaBean property for each DAO. In the present case, the properties
 * are write-only: there are no corresponding getter methods. Getter
 * methods for configuration properties are optional: Implement them
 * only if you want to expose those properties to other business objects.
 *
 * <p>There is one instance of this class in the JPetStore application.
 * In Spring terminology, it is a "singleton", referring to a
 * per-Application Context singleton. The factory creates a single
 * instance; there is no need for a private constructor, static
 * factory method etc as in the traditional implementation of
 * the Singleton Design Pattern. 
 *
 * <p>This is a POJO. It does not depend on any Spring APIs.
 * It's usable outside a Spring container, and can be instantiated
 * using new in a JUnit test. However, we can still apply declarative
 * transaction management to it using Spring AOP.
 *
 * <p>This class defines a default transaction annotation for all methods.
 *
 * @author Juergen Hoeller
 * @since 30.11.2003
 * @modified by Changsup Park
 */
@Service
@Transactional
public class PetStoreImpl implements PetStoreFacade { 
	@Autowired	// 
	@Qualifier("mybatisAccountDao")
	private AccountDao accountDao;
	
	@Autowired  
	//@Qualifier("jdbcTemplateCategoryDao") // �뜝�떎�뙋�삕  
	// @Qualifier("namedParameterJdbcTemplateCategoryDao")  // �뜝�떎�뙋�삕 
	// @Qualifier("jdbcDaoSupportCategoryDao")  // �뜝�떎�뙋�삕
	// @Qualifier("PureJdbcCategoryDao")
	@Qualifier("mybatisCategoryDao")
	private CategoryDao categoryDao;
	
	@Autowired  // 
	@Qualifier("mybatisProductDao")
	private ProductDao productDao;
	
	@Autowired	// 
	@Qualifier("mybatisItemDao")
	private ItemDao itemDao;
	
	@Autowired	// 
	@Qualifier("mybatisOrderDao")
	private OrderDao orderDao;
	
	@Autowired
	private BlackListDao BlackListDao;

	//-------------------------------------------------------------------------
	// Operation methods, implementing the PetStoreFacade interface
	//-------------------------------------------------------------------------

	

	public List<BlackList> getBlackList() {
		return BlackListDao.getBlackList();
	}
	
	public Account getAccount(String username) {
		return accountDao.getAccount(username);
	}

	public Account getAccount(String username, String password) {
		return accountDao.getAccount(username, password);
	}

	public void insertAccount(Account account) {
		accountDao.insertAccount(account);
	}

	public void updateAccount(Account account) {
		accountDao.updateAccount(account);
	}

	public List<String> getUsernameList() {
		return accountDao.getUsernameList();
	}

	public List<Category> getCategoryList() {
		return categoryDao.getCategoryList();
	}

	public Category getCategory(String categoryId) {
		return categoryDao.getCategory(categoryId);
	}

	public List<Product> getProductListByCategory(String categoryId) {
		return productDao.getProductListByCategory(categoryId);
	}

	public List<Product> searchProductList(String keywords) {
		return productDao.searchProductList(keywords);
	}

	public Product getProduct(String productId) {
		return productDao.getProduct(productId);
	}

	public List<Item> getItemListByProduct(String productId) {
		return itemDao.getItemListByProduct(productId);
	}

	public Item getItem(String itemId) {
		return itemDao.getItem(itemId);
	}

	public boolean isItemInStock(String itemId) {
		return itemDao.isItemInStock(itemId);
	}

	//insertOrder 占쎈뼄占쎈뻬 餓ο옙 占쎌궎�몴占� 占쎄문疫꿸퀡�늺 占쎌읈占쎌벥 占쎌삂占쎈씜占쎈즲 rollback 占쎈┷占쎈선占쎈튊占쎈맙
	//alter table inventory add constraint c1 check(qty >= 0) 占쎈�믭옙�뵠�뇡遺용퓠 占쎌뵠 占쎌젫占쎈튋鈺곌퀗援� �빊遺쏙옙占쎈퉸占쎈튊占쎈맙 
	//@Transactional 嚥∽옙 占쎄퐨占쎈섧占쎌읅 Transcation �꽴占썹뵳占� (insertOrder占쎈뮉 2揶쏆뮆占쏙옙 占쎈릭占쎄돌嚥∽옙 �눧�씈堉깍옙苑�..)
	public void insertOrder(Order order) {
		int point = (int) (order.getTotalPrice()*0.1);
		accountDao.updatePoint(order.getUsername(), point);
		order.setPoint(point);
		itemDao.updateQuantity(order);	    
		orderDao.insertOrder(order);
	}
	
	//Added method for showing list of my selling items
	public List<Item> getSellingItemListBySellerUsername(String username) {
		return itemDao.getSellingItemListBySellerUsername(username);
	}
	
	public Order getOrder(int orderId) {
		return orderDao.getOrder(orderId);
	}

	public List<Order> getOrdersByUsername(String username) {
		return orderDao.getOrdersByUsername(username);
	}
	
	@Override
	public void insertItem(Item item) {
		// TODO Auto-generated method stub
		itemDao.insertItem(item);
		itemDao.updateQuantityForInsertItem(item);
	}

	public void updatePoint(String username, int point) {
		accountDao.updatePoint(username, point);
	}
	
	public int getUserPoint(Account account) {
		return accountDao.getUserPoint(account);
	}
}