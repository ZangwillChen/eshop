package com.czw.eshop.test;

import com.czw.eshop.dao.BaseDao;
import com.czw.eshop.dao.UserDao;
import com.czw.eshop.dao.UserDaoImpl;
import com.czw.eshop.entity.Goods;
import com.czw.eshop.entity.Order;
import com.czw.eshop.entity.OrderItem;
import com.czw.eshop.entity.User;
import com.czw.eshop.service.constants;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.fail;

/**
 * Created by chenzhaowen on 2017/9/1.
 */
public class BasicTest {

    private static SessionFactory sessionFactory;

    @BeforeClass
    public static void beforeClass(){

        sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();

    }

    @AfterClass
    public static void afterClass(){
        sessionFactory.close();
    }

    //@Test
    public void testSchemaExport(){

        new SchemaExport(new AnnotationConfiguration().configure()).create(false,true);

    }

//    @Test
//    public void test(){
//        fail("not yet implemented");
//    }

    @Test
    public void saveOrder(){

        Session session = sessionFactory.getCurrentSession();

        session.beginTransaction();

        Integer s = new Integer(2);

        Long id = Long.parseLong(s.toString());

        User user = (User) session.get(User.class,id);

        Goods goods = (Goods) session.get(Goods.class,id);

        System.out.println(user.getUserName());

        OrderItem item = new OrderItem(2,goods);

        Order order = new Order(1,user);

        order.setOrderName("12211");

        item.setOrderID(order);

        order.getItems();

        System.out.println(order.getOrderPrice());

        session.save(item);

        session.save(order);

        System.out.println();

        session.getTransaction().commit();

        for (Long id1 : order.getItems().keySet()){
            System.out.println(order.getItems().get(id1).getGoodID().getGoodName());
        }
        System.out.println(constants.OrderStatus(order.getStatus()));
    }
//    @Test
//    public void save(){
//
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-common.xml");
//        BaseDao baseDao = (BaseDao) context.getBean("baseDao");
//
//        User user = baseDao.getEntityById(User.class,(long)1);
//
//        Goods good1 = baseDao.getEntityById(Goods.class,(long)1);
//        Goods good2 = baseDao.getEntityById(Goods.class,(long)2);
//
//        OrderItem item1 = new OrderItem();
//        item1.setGoodID(good1);
//        item1.setItemAmount(2);
//        System.out.println(item1.getItemAmount());
//        System.out.println(good1.getGoodPrice());
//
//        item1.setCost(item1.getItemAmount() * good1.getGoodPrice());
//
//
//
//        OrderItem item2 = new OrderItem();
//        item2.setGoodID(good2);
//        item2.setItemAmount(2);
//        item2.setCost(item2.getItemAmount() * good2.getGoodPrice());
//
//        Map<Long,OrderItem> items = new HashMap<Long,OrderItem>();
//        items.put(good1.getGoodID(),item1);
//        items.put(good2.getGoodID(),item2);
//
//        Order order = new Order(constants.ORDER_STATUS_POST,user);
//        item1.setOrderID(order);
//        item2.setOrderID(order);
//        order.setItems(items);
//
//        order.setOrderName("89");
//        baseDao.saveEntity(order);
//    }

    @Test
    public void list(){

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-common.xml");

        BaseDao baseDao = (BaseDao) context.getBean("baseDao");

        List<Order> orders = baseDao.getAllEntity("Order");

        for (Order o : orders){
            System.out.println(o.getOrderName());
            System.out.println(o.getStatus());
        }
    }

    @Test
    public void query(){

        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-common.xml");

        BaseDao baseDao = (BaseDao) context.getBean("baseDao");

        Goods good1 = baseDao.getEntityById(Goods.class,(long)3);

        System.out.println(good1.getGoodName());

        good1.setGoodName("dog");

        baseDao.updateEntity(good1);
    }

    @Test
    public void user(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-common.xml");

        UserDao userDao = (UserDao) context.getBean("userDao");

        User user =	userDao.getEntityById(User.class, (long)1 );

        String name = user.getUserName();

        String password =  String.valueOf(user.getUserPwd() );

        System.out.println(name);

        System.out.println( password);

        User u1 =  userDao.loginCheck("zang", "123" );

        System.out.println( u1);
    }

    @Test
    public void loginTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-common.xml");

        UserDaoImpl userDao = (UserDaoImpl) context.getBean("userDao");

        String hql = "from User user where user.userName = ? and user.userPwd = ?";

        List<User> list = userDao.getHibernateTemplate().find(hql,new String []{"zang","123"});

        System.out.println(list.size());

    }
}
