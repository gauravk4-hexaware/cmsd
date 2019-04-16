package com.hexaware.FTP112.persistence;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import com.hexaware.FTP112.model.Customer;
import org.skife.jdbi.v2.sqlobject.Bind;
/**
 * CustomerDAO class used to fetch data from data base.
 * @author hexware
 */
public interface CustomerDAO {
    /**
     * @return the all the Customer record.
     * @param cusId to initializing customer Id.
     */
  @SqlQuery("Select CUS_ID,CUS_NAME,CUS_PHN_NO,CUS_USERNAME,CUS_EMAIL from Customer where cus_id = :cusId;")
    @Mapper(CustomerMapper.class)
    List<Customer> show(@Bind("cusId")int cusId);
    /**
     * @return the all the cus_id.
     * @param cusId to initializing customer Id.
     * @param password to initializing password.
     */
  @SqlQuery("select count(*) from customer where cus_id = :cusId and CUS_PASSWORD = :password;")
    int fetchCustomerId(@Bind("cusId")int cusId, @Bind("password")String password);
    /**
     * @return the all the cus_id.
     * @param cusId to initializing customer Id.
     */
  @SqlQuery("select count(*) from customer where cus_id = :cusId;")
    int fetchCusId(@Bind("cusId")int cusId);
}


