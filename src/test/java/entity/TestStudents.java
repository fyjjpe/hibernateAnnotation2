package entity;

import com.entity.Address;
import com.entity.Students;
import com.entity.StudentsPK;
import com.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.Test;

import java.util.Date;

/**
 * Created by yuanjie.fang on 2018/3/1.
 */
public class TestStudents {

    //输出表结构
    @Test
    public void testSchemaExport() {
        Configuration config = new Configuration().configure();
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
        SessionFactory sessionFactory = config.buildSessionFactory(serviceRegistry);
        SchemaExport export = new SchemaExport(config);
        export.create(true, true);
    }


    //新增学生
    @Test
    public void addStudent() {
        Session session = HibernateUtil.getSession();
        Transaction tx = session.beginTransaction();
        Address address = new Address("111000", "苏州", "123456");
        StudentsPK pk = new StudentsPK();
        pk.setId("123456789987654321");
        pk.setSid("S0000001");
        Students s = new Students(pk, "张三丰", "男", new Date(), "太极拳", address);
        session.save(s);
        tx.commit();
        HibernateUtil.colseSession(session);
    }
}
