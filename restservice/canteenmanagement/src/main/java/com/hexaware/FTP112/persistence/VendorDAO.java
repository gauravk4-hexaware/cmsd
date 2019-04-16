package com.hexaware.FTP112.persistence;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;
import java.util.List;
import org.skife.jdbi.v2.sqlobject.Bind;
import com.hexaware.FTP112.model.Vendor;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
/**
 * VendorDAO class used to fetch data from data base.
 * @author hexware
 */
public interface VendorDAO {
    /**
     * @return the all the Vendor record.
     * @param venId to initialize vendor id.
     */
  @SqlQuery("Select VEN_ID,VEN_NAME,VEN_PHN_NO,VEN_USERNAME,VEN_EMAIL,VEN_BALANCE from Vendor where  ven_id = :vendorId;")
    @Mapper(VendorMapper.class)
    List<Vendor> show(@Bind("vendorId")int venId);

    /**
     * @return the count.
     * @param venId to initialize vendor id.
     * @param vendorPassword to initialize vendor password.
     */
  @SqlQuery("select count(*) from vendor where ven_id = :vendorId and ven_password = :vendorPassword;")
    int authenticateVendor(@Bind("vendorId")int venId, @Bind("vendorPassword")String vendorPassword);
    /**
     * @return the count.
     * @param venId to initialize vendor id.
     */
  @SqlQuery("select count(*) from vendor where ven_id = :vendorId;")
    int authenticateVendorId(@Bind("vendorId")int venId);
    /**
     * @return the vendor Balance.
     * @param venId to initialize vendor id.
     */
  @SqlQuery("Select VEN_BALANCE from vendor where ven_id = :venId;")
    double vendorBalance(@Bind("venId")int venId);
    /**
     * @param totalOrderPrice to initialize totalOrderPrice.
     * @param venId to initialize vendor id.
     */
  @SqlUpdate("update vendor set VEN_BALANCE = :totalOrderPrice where ven_id = :venId;")
    void vendorWallet(@Bind("totalOrderPrice")double totalOrderPrice, @Bind("venId")int venId);
    /**
     * @param price to initialize price.
     * @param vendorId to initialize vendor id.
     */
  @SqlUpdate("update vendor set VEN_BALANCE = ven_balance - :price where ven_id = :vendorId;")
    void refund(@Bind("price")double price, @Bind("vendorId")int vendorId);


}
